package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Wiktor Szymanowski
 * Date: 20.03.2021
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"@Regression"},
        glue = {"hooks", "steps"},
        strict = true,
        features = {"src/test/resources"},
        plugin = {"pretty", "html:target/cucumber/html/qiagentests", "json:target/cucumber/report_qiagen_tests.json", "junit:target/cucumber/report_qiagen_tests.xml"}
)
public class Runner {
}
