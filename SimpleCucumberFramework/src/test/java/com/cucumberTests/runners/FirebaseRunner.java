package com.cucumberTests.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/features/firebase.feature",},
		glue = {"com.cucumberTests.steps"},
		monochrome = true,
		dryRun = false
		//tags = "@cal and @sub"
				
		)

public class FirebaseRunner extends AbstractTestNGCucumberTests{
	
}
