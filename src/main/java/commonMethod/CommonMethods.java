package commonMethod;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class CommonMethods {

    WebDriver driver;
    WebDriverWait wait;

    public CommonMethods(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators and elements
    String homePageUrl = "https://documentation.history.mot.api.gov.uk/";

    //Common Methods
    private void takeScreenshot(String fileName) {
        // Take a screenshot and save it to the specified file name
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(fileName + ".png"));
            System.out.println("Screenshot taken: " + fileName + ".png");
        } catch (IOException e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}
