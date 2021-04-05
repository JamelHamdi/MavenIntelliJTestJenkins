package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = {"stepDefinitions"},
        monochrome = true,
        plugin = {"pretty","html:src/test/HtmlReports/report.html"})
public class TestRunner {
}
