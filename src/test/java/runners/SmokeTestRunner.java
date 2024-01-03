package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.*;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin ={"pretty", 
				"html:test_results/cucumber_report.html",
				"json:test_results/cucumber_report.json"},
		features="./src/test/resources/features",
		glue="step_definitions",
		tags="@smokeTest",
		publish=true
		//dryRun=false //It will scan the feature files and it will check if anything is not implemented. It wont run anything.
		)

public class SmokeTestRunner {

}
