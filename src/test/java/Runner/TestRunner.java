package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Feature", glue = { "StepDef" }, monochrome = true, plugin = { "pretty",
		"html:target/HTMLReports/Report.html", "junit:target/JUnitReports/Report.xml",
		"json:target/cucumber.json" }, tags = "@Regression")
public class TestRunner {

}
