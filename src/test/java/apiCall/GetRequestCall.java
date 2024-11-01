package apiCall;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequestCall {

    public static String getToken() {
        // Base URI for authentication
        RestAssured.baseURI = "https://login.microsoftonline.com";

        // Form parameters required for token generation
        Map<String, String> formParams = new HashMap<>();
        formParams.put("grant_type", "client_credentials"); // Generally, this is client_credentials
        formParams.put("client_id", "81ff7cef-a5f9-451a-b7b3-ebcf21e3a932");
        formParams.put("client_secret", "KRz8Q~~Oa_TFEhOIjTA0BtGsP.Pw64iRSD_ZkbHD");
        formParams.put("scope", "https://tapi.dvsa.gov.uk/.default");

        // Send the POST request to get the token with detailed logging
        Response response = given()
                .contentType(ContentType.URLENC) // Sets content-type to application/x-www-form-urlencoded
                .formParams(formParams)           // Adds form parameters
                .log().all()                      // Logs request details
                .post("/a455b827-244f-4c97-b5b4-ce5d13b4d00c/oauth2/v2.0/token")
                .then()
                .extract()
                .response();

        // Check for success and extract token if available
        if (response.statusCode() == 200) {
            return response.jsonPath().getString("access_token");
        } else {
            throw new RuntimeException("Failed to retrieve token: " + response.getStatusLine());
        }
    }

    public void verifyVehicleRegistration(String craRegistration) {
        String token = getToken();

        // Base URI for the API
        RestAssured.baseURI = "https://history.mot.api.gov.uk"; // Replace with your actual base URL

        // Perform the API request
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .header("X-API-Key","A7WDXHiOqy92NRCnoysDh6uaD0tyWOql9jnXgJBT")// Set the authorization token
                .pathParam("registration", craRegistration)     // Path parameter for registration number
                .when()
                .get("/v1/trade/vehicles/registration/{registration}")
                .then()
                .statusCode(200)                             // Validate the HTTP status code is 200
                .body("registration", equalTo(craRegistration)) // Validate the registration in the response
                .body("make", notNullValue())                // Validate the make is present in the response
                .body("model", notNullValue())               // Validate the model is present in the response
                .extract().response();                       // Extract the full response for further checks

        // Additional assertions if needed
        String make = response.jsonPath().getString("make");
        String model = response.jsonPath().getString("model");
        System.out.println("Make: " + make + ", Model: " + model);
    }
}
