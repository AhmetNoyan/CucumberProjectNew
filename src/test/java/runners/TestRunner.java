package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.*;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="./src/test/resources/features",
		glue="step_definitions",
		tags="@createItem",
		dryRun=false //It will scan the feature files and it will check if anything is not implemented. It wont run anything.
		)


public class TestRunner {

	
}
