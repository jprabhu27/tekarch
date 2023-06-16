package com.cucumberTests.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/features/simpleFeature.feature",
				"src/test/resources/features/simpleFeature4.feature" },
		glue = {"com.cucumberTests.steps"},
		monochrome = true,
		dryRun = true
				
		)
public class CalculatorRunner extends AbstractTestNGCucumberTests {
	
	

}
