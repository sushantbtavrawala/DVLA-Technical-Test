package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(linkText = "Rate limits")
    WebElement linkRateLimit;

    @FindBy(linkText = "Error codes")
    WebElement linkErrorCode;

    String homePageUrl = "https://documentation.history.mot.api.gov.uk/";

    public void clickHomePageLinks(String link){
        if(link.equalsIgnoreCase("rate limits")){
            linkRateLimit.click();
        } else if(link.equalsIgnoreCase("error codes")){
            linkErrorCode.click();
        }
    }

    //Common Methods
    public void navigateToHomePage() {
        driver.navigate().back();
        // Verify we are back on the homepage
        Assert.assertEquals("Homepage URL mismatch", homePageUrl, driver.getCurrentUrl());
       // takeScreenshot("navigationTestFailure");
    }
}
