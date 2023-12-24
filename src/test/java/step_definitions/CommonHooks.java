package step_definitions;

import java.util.concurrent.TimeUnit;

import io.cucumber.java.*;
import utilities.Driver;

public class CommonHooks {

	@Before//it will execute before each scenario
	public void setup() {
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.getDriver().manage().window().maximize();
	}
	@After//it will execute after each scenario
	public void teardown() {
		Driver.quitDriver();
	}
}
