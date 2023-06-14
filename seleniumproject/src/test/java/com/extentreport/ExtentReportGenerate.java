package com.extentreport;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentReportGenerate {
	
	public static void main (String[] args) {
		
		ExtentReports report = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("MySpark.html");
		report.attachReporter(spark);
		
		report.setSystemInfo("Host Name", "Salesforce");
		report.setSystemInfo("Environment", "QA");
		report.setSystemInfo("User Name", "Jaya");
		
		spark.config().setDocumentTitle("Test Execution Report");
		spark.config().setReportName("Salesforce regression Tests");
		spark.config().setTheme(Theme.DARK);
		

		ExtentTest reportLogger = report.createTest("testscript1");
		reportLogger.log(Status.INFO, "test started");
		reportLogger.log(Status.INFO, "browser launched");
		reportLogger.log(Status.INFO, "url entered");
		reportLogger.log(Status.INFO, "login button clicked");
		reportLogger.log(Status.PASS, "test completed with pass");
		reportLogger.log(Status.PASS, MarkupHelper.createLabel("PASSED",ExtentColor.GREEN));
		

		ExtentTest reportLogger1 = report.createTest("testscript2");
		reportLogger1.log(Status.INFO, "test started");
		reportLogger1.log(Status.INFO, "browser launched");
		reportLogger1.log(Status.INFO, "url entered");
		reportLogger1.log(Status.INFO, "login button clicked");
		reportLogger1.log(Status.SKIP, "test completed with pass");
		
		

		ExtentTest reportLogger2 = report.createTest("testscript3");
		reportLogger2.log(Status.INFO, "test started");
		reportLogger2.log(Status.INFO, "browser launched");
		reportLogger2.log(Status.INFO, "url entered");
		reportLogger2.log(Status.INFO, "login button clicked");
		reportLogger2.log(Status.FAIL, "test completed with pass");
		
				
				try {
					throw new ArithmeticException();
				}
				catch(ArithmeticException e) {
				reportLogger2.log(Status.FAIL, e);
				}
		report.flush();
		
		System.out.println("completed");
		
	}
	
}
