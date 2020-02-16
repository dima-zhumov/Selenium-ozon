import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/"}, glue = {"com.aplana.steps"},
        plugin = {"json:target/cucumber-report.json",
                "pretty",
                "io.qameta.allure.cucumber3jvm.AllureCucumber3Jvm"})


public class CucumberRunner {

}
