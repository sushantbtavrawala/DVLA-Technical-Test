package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.time.Duration;

public class hooks {
    private static WebDriver driver;

    @Before
    public void startUp() throws IOException {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Use quit instead of close to ensure all browser windows are closed
            driver = null; // Reset driver to ensure fresh instance for the next test
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
