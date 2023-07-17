package com.restTests.utility;

import com.restTests.utility.Constants;

import org.testng.ITestListener;

//import com.automation.utility.ExtentReportsUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsUtility implements ITestListener{
	
	public static ExtentReports report;
	public static ExtentSparkReporter spark;
	public static ExtentTest testLogger;
	private static ExtentReportsUtility extentObject; // create an object of this class

	
	public static ExtentReportsUtility getInstance() {
		if (extentObject == null) {
			extentObject = new ExtentReportsUtility();
		}
		return extentObject;
	}

	// Initializes the extent and spark report and attach
	public void startExtentReport() {
		// Attach the spark report and set the system configuration

		report = new ExtentReports();
		spark = new ExtentSparkReporter(Constants.SPARKS_HTML_REPORT_PATH);
		report.attachReporter(spark);

		report.setSystemInfo("Host Name", "RestAssuredAutomationFramework");
		report.setSystemInfo("Environment", "QA");
		report.setSystemInfo("User Name", "Jaya");

		spark.config().setDocumentTitle("Test Execution Report");
		spark.config().setReportName("API Regression Tests");
		spark.config().setTheme(Theme.DARK);

	}

	// Will create a report for the single test
	// Here we have to dynamically send the automation script name to Start the
	// report

	public void StartSingleTestReport(String methodName) {
		testLogger = report.createTest(methodName);

	}
	// Closing the report

	public void endReport() {
		report.flush();
	}

	// text is what message you want to print here

	public void logTestInfo(String text) {
		testLogger.log(Status.INFO, text);

	}

	public void logTestPassed(String text) {
		testLogger.pass(MarkupHelper.createLabel(text, ExtentColor.GREEN));

	}

	public void logTestFailed(String text) {

		testLogger.fail(MarkupHelper.createLabel(text, ExtentColor.RED));
	}

	public void logTestFailedWithException(Throwable e) {

		testLogger.log(Status.FAIL, e);
	}

	
}



