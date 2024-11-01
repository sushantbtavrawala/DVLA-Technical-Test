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
    @FindBy(xpath = "//table[@class='govuk-table']//tr[1]/td[1]")
    WebElement limit_Type_Quota_Locator;

    @FindBy(xpath = "//table[@class='govuk-table']//tr[1]/td[3]")
    WebElement limit_Quota_Value_Locator;

    @FindBy(xpath = "//h1")
    WebElement rate_limit_Title_Locator;

    //Actions
    public void isRateLimitTitleDisplayed() {
        commonUtils.waitForVisibility(rate_limit_Title_Locator);
        Assert.assertTrue("Rate Limit title is not displayed.", rate_limit_Title_Locator.isDisplayed());
    }

    public void validateLimitTypeWithLimitValue(String limit_Type, String limit_Value) {
        List<WebElement> limitTypeTableContent = driver.findElements(
                By.xpath("//tr[td[contains(text(),'" + limit_Type +"')] and td[contains(text(),'" + limit_Value +"')]]"));

        // Assert if the table contains an entry for the given limit type and value
        Assert.assertFalse(limit_Type + " with value " + limit_Value + " not found in the table.", limitTypeTableContent.isEmpty());
    }
}
