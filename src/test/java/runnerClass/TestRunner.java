package runnerClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"stepdefinitions","hooks"},
        plugin = {"pretty","html:target/htmlreport.html"},
       // publish = true,
        tags = "@smoke"
       // dryRun = false
)

public class TestRunner extends AbstractTestNGCucumberTests {
}
