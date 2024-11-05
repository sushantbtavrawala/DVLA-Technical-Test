package pages;

import commonUtils.CommonUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ErrorCodesPage {

    WebDriver driver;     // WebDriver instance for interacting with the browser
    CommonUtils commonUtils;     // CommonUtils instance for utility methods (like waits and interactions)

    public ErrorCodesPage(WebDriver driver) {
        this.driver = driver; // Initialize the driver instance
        PageFactory.initElements(driver, this); // Initialize all WebElements annotated with @FindBy
        this.commonUtils = new CommonUtils(driver); // Initialize CommonUtils with the driver instance
    }

    //Locators
    @FindBy(xpath = "//h1")
    WebElement errorCodesTitleLocator;

    // Build XPath for table rows based on error code and description
    private By getTableRowByErrorCodeAndDescription(String errCode, String errDescription) {
        return By.xpath(String.format("//tr[td[contains(text(),'%s')] and td[contains(text(),'%s')]]", errCode, errDescription));
    }

    //Actions
    public void isErrorCodesTitleDisplayed() {
        commonUtils.waitForVisibility(errorCodesTitleLocator);
        errorCodesTitleLocator.isDisplayed();
    }

    public void validate_ErrorCode_ErrorDescription(String errCode, String errDescription) {
        List<WebElement> tableRows = driver.findElements(getTableRowByErrorCodeAndDescription(errCode, errDescription));

        // Assert if the table do not match with requested data
        Assert.assertFalse(errCode + " contains do not found in the table.", tableRows.isEmpty());
    }
}


