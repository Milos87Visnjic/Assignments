package net.avantage.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","json:target/cucumber.json",          // our report file gets the test data from cucumber.json file
// json: xml file, keeps data in key and value structure, this plugin creates target / cucumber.json file
                "html:target/default-html-reports", // default cucumber html report
                "rerun:target/rerun.txt"},
        features = "src/test/resources/features",
        glue = "net/avantage/step_definitions",
        dryRun = false,
        tags = "@apiPutNafis"

)
public class CukesRunner {
}

