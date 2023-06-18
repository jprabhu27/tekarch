package com.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/features/salesforce.feature",},
		glue = {"com.automation.steps"},
		monochrome = true,
		dryRun = false,
		plugin ={
			"pretty",
			"html:target/cucumber-reports",
			"json:target/cucumber.jason",
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		}
)

public class SalesforceRunner extends AbstractTestNGCucumberTests{
}
