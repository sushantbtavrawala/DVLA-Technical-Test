package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class hooks {
    private static WebDriver driver;

    @Before
    public void startUp() {
        // Check if the WebDriver instance is not already created
        if (driver == null) {
            // Setup the ChromeDriver using WebDriverManager, ensuring the correct version is downloaded
            WebDriverManager.chromedriver().setup();

            // Initialize a new ChromeDriver instance
            driver = new ChromeDriver();

            // Maximize the browser window for better visibility of tests
            driver.manage().window().maximize();

            // Set an implicit wait of 5 seconds, so the WebDriver waits up to 5 seconds
            // for elements to appear before throwing a NoSuchElementException
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
    }

    @After
    public void tearDown() {
        // Check if the WebDriver instance exists (i.e., is not null)
        if (driver != null) {
            // Close the browser and end the WebDriver session
            driver.quit();

            // Set the driver to null to ensure a fresh instance is created in the next test
            driver = null;
        }
    }

    // Static method to provide access to the WebDriver instance from other classes
    public static WebDriver getDriver() {
        return driver;
    }
}
