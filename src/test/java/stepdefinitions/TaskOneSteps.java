package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ErrorCodesPage;
import pages.HomePage;
import pages.RateLimitsPage;
import hooks.hooks;

import java.util.List;
import java.util.Map;

public class TaskOneSteps {

    WebDriver driver = hooks.getDriver();
    RateLimitsPage rateLimitsPage;
    HomePage homePage;
    ErrorCodesPage errorCodesPage;

    public TaskOneSteps() {
        this.rateLimitsPage = new RateLimitsPage(driver);
        this.homePage = new HomePage(driver);
        this.errorCodesPage = new ErrorCodesPage(driver);
    }

    @Given("the user navigates to the {string}")
    public void theUserNavigatesToThe(String url) {
        driver.get(url);
    }

    @When("user click on the link {string}")
    public void userNavigatesToThePage(String pageUrl) {
        homePage.clickHomePageLinks(pageUrl);
    }

    @When("verify user is on {string} page")
    public void verify_user_is_on_page(String pageTitle) {
        if(pageTitle.equalsIgnoreCase("Rate limits")){
            rateLimitsPage.isRateLimitTitleDisplayed();
        } else if (pageTitle.equalsIgnoreCase("Error codes")){
            errorCodesPage.isErrorCodesTitleDisplayed();
        }
    }

    @Then("validate the limit type is {string}")
    public void validateTheLimitTypeIs(String Limit_Type) {
        rateLimitsPage.isLimitTypeQuotaDisplayed();
    }

    @And("validate the limit value is {string}")
    public void validateTheLimitValueIs(String expectedLimitValue) {
       rateLimitsPage.isLimitTypeQuotaValueDisplayed();
    }

    @Then("verify limit type {string} is display with the limit {Integer}")
    public void verify_is_display_with_the_limit(String Limit_Type, Integer Limit_Value) {
        if(Limit_Type.equalsIgnoreCase("quota")) {
            rateLimitsPage.assertValue(Limit_Type, Limit_Value);
        } else {
            Assert.fail("Limit Type is not found in the table");
        }
    }
    
    @And("user navigate back to homepage")
    public void user_navigate_back_to_homepage() {
        homePage.navigateToHomePage();
    }

    @When("verify error code is display with the error description")
    public void verifyErrorCodeIsDisplayWithTheErrorDescription(DataTable dataTable) {

        // Convert DataTable to List of Maps
        List<Map<String, String>> errorDetails = dataTable.asMaps(String.class, String.class);

        // Iterate through each row and print out error codes and messages
        for (Map<String, String> row : errorDetails) {
            String reqeustErrorCode = row.get("error_code");
            String requestErrorDescription = row.get("error_message");

            // Print or assert for verification
            errorCodesPage.validate_Error_Code_With_Description_Table(reqeustErrorCode,requestErrorDescription);
        }
    }
}
