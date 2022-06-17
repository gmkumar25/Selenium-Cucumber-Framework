package StepDefinitions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-reports/TestReport.html",
                "json:target/cucumber-reports/TestReport.json"
                              
        },
        features = {"src/test/resources/Features"},
        glue = {"StepDefinitions"},
        tags= "@tag2"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
