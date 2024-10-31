package stepdefinitions;

import commonMethod.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.ErrorCodesPage;
import pages.HomePage;
import pages.RateLimitsPage;
import hooks.hooks;

public class TaskOneSteps {

    WebDriver driver = hooks.getDriver();
    RateLimitsPage rateLimitsPage;
    HomePage homePage;
    ErrorCodesPage errorCodesPage;
    CommonMethods commonMethods;

    public TaskOneSteps() {
        this.rateLimitsPage = new RateLimitsPage(driver);
        this.homePage = new HomePage(driver);
        this.errorCodesPage = new ErrorCodesPage(driver);
        this.commonMethods = new CommonMethods(driver);
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
        } else if  (pageTitle.equalsIgnoreCase("Error codes")){
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

    @Then("verify limit type {string} is display with the limit {string}")
    public void verify_is_display_with_the_limit(String Limit_Type, String Limit_Value) {
        if(Limit_Type.equalsIgnoreCase("quota")) {
            rateLimitsPage.isLimitTypeQuotaValueDisplayed();
            rateLimitsPage.isLimitTypeQuotaValueDisplayed();
        } else if (Limit_Type.equalsIgnoreCase("Burst")) {

        } else {
            Assert.fail("Limit Type is not found in the table");
        }
    }

    @Then("verify error code {string} is display with the description {string}")
    public void verify_error_code_is_display_with_the_description(String errorCode, String errorDescription) {
        errorCodesPage.validate_Error_Code_With_Description_Table(errorCode,errorDescription);
    }

    @And("user navigate back to homepage")
    public void user_navigate_back_to_homepage() {
        homePage.navigateToHomePage();
    }

}
