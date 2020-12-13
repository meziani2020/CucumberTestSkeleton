package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/resources/features",
        glue = "stepsDefinitions",
        tags =" @Assignment2",
        plugin = { "pretty", "html:target//cucumber-reports/Assignment2-reports.html" }
)
public class RunTestAssignment2 {
}
