package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/resources/features",
        glue = "stepsDefinitions",
        tags =" @Assignment3",
        plugin = { "pretty", "html:target//cucumber-reports/Assignment3-reports.html" }
)
public class RunTestAssignment3 {
}
