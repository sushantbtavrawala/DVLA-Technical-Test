package stepdefinitions;

import apiCall.GetRequestCall;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApiSteps {

    GetRequestCall getRequestCall = new GetRequestCall();

    @When("user call get")
    public void userCallGet() {
        getRequestCall.verifyVehicleRegistration("FP64VVW");
    }


}
