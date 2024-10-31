package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class ErrorCodesPage {

    WebDriver driver;
    WebDriverWait wait;

    public ErrorCodesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(xpath = "//h1")
    WebElement error_Codes_Title_Locator;

    @FindBy(xpath = "//table[@class='govuk-table']")
    WebElement error_Codes_Table_Locator;

    //Actions
    public void isErrorCodesTitleDisplayed() {
        error_Codes_Title_Locator.isDisplayed();
    }

    public void verifyContainUrl(){

        WebElement errorCodesLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Error Codes")));
        errorCodesLink.click();

        // Verify we are on the Error Codes page
        Assert.assertTrue("Not on Error Codes page", driver.getCurrentUrl().contains("error-codes"));

        // Click on the "Home" link to navigate back to the homepage
        WebElement homeLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Home")));
        homeLink.click();

        // Final verification for homepage
        Assert.assertEquals("Did not navigate back to homepage", "https://documentation.history.mot.api.gov.uk/", driver.getCurrentUrl());
    }

    public void validate_Error_Code_With_Description_Table(String errCode, String errDescription) {

        // Retrieve all rows from the error codes table
        List<WebElement> rows = error_Codes_Table_Locator.findElements(By.tagName("tr"));

        // Loop through each row to check for the specified error code and description
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));

            // Ensure the row has at least two columns before checking values
            if (cells.size() >= 2) {
                // Retrieve error code and description from the first and second columns
                String tableErrorCode = cells.get(0).getText();
                String tableErrorDescription = cells.get(1).getText();

                // Verify that the error code matches and assert the description
                if (tableErrorCode.equals(errCode)) {
                    Assert.assertEquals("Error description does not match", errDescription, tableErrorDescription);
                    return; // Exit loop once the expected error code is found
                }
            }
        }
        // If the loop completes without finding the error code, fail the test
        Assert.fail("Error code not found in the table.");
    }
}


