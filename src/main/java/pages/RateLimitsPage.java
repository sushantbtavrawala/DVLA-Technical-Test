package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RateLimitsPage {

    WebDriver driver;

    public RateLimitsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(xpath = "//table[@class='govuk-table']//tr[1]/td[1]")
    WebElement limit_Type_Quota_Locator;

    @FindBy(xpath = "//table[@class='govuk-table']//tr[1]/td[3]")
    WebElement limit_Quota_Value_Locator;

    @FindBy(xpath = "//h1")
    WebElement rate_limit_Title_Locator;


    //Actions
    public void isLimitTypeQuotaDisplayed() {
        limit_Type_Quota_Locator.isDisplayed();
    }

    public void isLimitTypeQuotaValueDisplayed() {
        limit_Quota_Value_Locator.isDisplayed();
    }

    public void isRateLimitTitleDisplayed() {
        rate_limit_Title_Locator.isDisplayed();
    }



}
