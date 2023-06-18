package com.cucumberTests.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/features/firebase.feature",},
		glue = {"com.cucumberTests.steps"},
		monochrome = true,
		dryRun = false,
	
		plugin = {"pretty",
				"html:target/cucumber.html",
				"json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }
					
		)

public class FirebaseRunner extends AbstractTestNGCucumberTests{

}
