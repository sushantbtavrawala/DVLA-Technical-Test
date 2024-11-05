package pages;

import commonUtils.CommonUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class RateLimitsPage {

    WebDriver driver;
    CommonUtils commonUtils;

    public RateLimitsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.commonUtils = new CommonUtils(driver);
    }

    //Locators
    @FindBy(xpath = "//h1")
    WebElement ratelimitTitleLocator;

    // Build XPath to get limit type table content based on limitType and limitValue
    private By getLimitTypeTableContent(String limitType, String limitValue) {
        return By.xpath(String.format("//tr[td[contains(text(),'%s')] and td[contains(text(),'%s')]]", limitType, limitValue));
    }

    //Actions
    public void isRateLimitTitleDisplayed() {
        commonUtils.waitForVisibility(ratelimitTitleLocator);
        Assert.assertTrue("Rate Limit title is not displayed.", ratelimitTitleLocator.isDisplayed());
    }

    public void validateLimitTypeWithLimitValue(String limitType, String limitValue) {
        List<WebElement> limitTypeTableContent = driver.findElements(getLimitTypeTableContent(limitType,limitValue));

        // Assert if the table do not match with requested data
        Assert.assertFalse(limitType + " with value " + limitValue + " not found in the table.", limitTypeTableContent.isEmpty());
    }
}
