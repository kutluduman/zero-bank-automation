package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/zerobank/stepdefinitions",
        features = "src/test/resources/features",
        dryRun = false,
        strict = false,
        //tags= "@account_activity_search_description_case_sensitive",
        plugin = {"pretty",
                "html:target/default-report",
                "json:target/zerobank_cucumber.json"
        }
)
public class CukesRunner {

}