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

    WebDriver driver;
    CommonUtils commonUtils;

    public ErrorCodesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.commonUtils = new CommonUtils(driver);
    }

    //Locators
    @FindBy(xpath = "//h1")
    WebElement errorCodesTitleLocator;

    //Actions
    public void isErrorCodesTitleDisplayed() {
        commonUtils.waitForVisibility(errorCodesTitleLocator);
        errorCodesTitleLocator.isDisplayed();
    }

    public void validate_ErrorCode_ErrorDescription(String errCode, String errDescription) {
        List<WebElement> tableRows = driver.findElements(
                By.xpath("//tr[td[contains(text(),'" + errCode +"')] and td[contains(text(),'" + errDescription +"')]]"));

        // Assert if the table do not match with requested data
        Assert.assertFalse(errCode + " contains do not found in the table.", tableRows.isEmpty());
    }
}


