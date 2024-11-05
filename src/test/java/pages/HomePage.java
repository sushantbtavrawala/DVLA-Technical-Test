package pages;

import commonUtils.CommonUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;
    CommonUtils commonUtils;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.commonUtils = new CommonUtils(driver);
    }

    //Locators
    @FindBy(linkText = "Rate limits")
    WebElement linkRateLimit;

    @FindBy(linkText = "Error codes")
    WebElement linkErrorCode;

    String homePageUrl = "https://documentation.history.mot.api.gov.uk/";

    //Actions
    public void clickHomePageLinks(String link){
        if(link.equalsIgnoreCase("rate limits")){
            commonUtils.waitForVisibility(linkRateLimit);
            linkRateLimit.click();
        } else if(link.equalsIgnoreCase("error codes")){
            commonUtils.waitForVisibility(linkErrorCode);
            linkErrorCode.click();
        }
    }

    public void navigateToHomePage() {
        driver.navigate().back();
        // Verify we are back on the homepage
        Assert.assertEquals("Homepage URL mismatch", homePageUrl, driver.getCurrentUrl());
    }
}
