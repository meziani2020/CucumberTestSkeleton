package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/resources/features",
        glue = "stepsDefinitions",
        tags =" @Assignment1",
        plugin = { "pretty", "html:target//cucumber-reports/Assignment1-reports.html" }
)
public class RunTestAssignment1 {
}
