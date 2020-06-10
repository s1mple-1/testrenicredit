package testrenicredit;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"testrenicredit.steps"},
        features = {"src/test/resources/"}
)
public class CucumberRunnerTest {}
