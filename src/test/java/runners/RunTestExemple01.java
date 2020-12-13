package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/resources/features",
        glue = "stepsDefinitions",
        tags =" @Assignment0",
        plugin = { "pretty", "html:target//cucumber-reports/cucumber-reports.html" }
)
public class RunTestExemple01 {
}
