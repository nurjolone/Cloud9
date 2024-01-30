package com.openMRS.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/openMrs",
        glue = "src/test/java/com/openMRS/steps",
        dryRun = false,
       // tags = "smoke",
        plugin = {"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTests.txt"}
)
public class OpenMRSrunner {
}
