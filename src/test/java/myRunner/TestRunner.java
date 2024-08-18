package myRunner;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(features =".//Features/Login.feature",
glue = "stepDefinitions", plugin = {"pretty","html:test-output"}, dryRun = false, monochrome = true)
public class TestRunner {

}
