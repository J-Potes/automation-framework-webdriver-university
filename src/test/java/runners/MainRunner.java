package runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = {"classpath:features"}, glue = {"stepDefinitions"},
        tags = "@login", monochrome = false, dryRun = false,
        plugin = {"pretty", "html:target/cucumber"})
public class MainRunner extends AbstractTestNGCucumberTests{
}
