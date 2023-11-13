package cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber.json","html:target/cucumber.html"},
        features = {"src/test/resources/features/"},
        glue = {"cucumber/definitions"})
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
