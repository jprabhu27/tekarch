package com.testng.tests.day33;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners implements ITestListener{
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("test method started its execution");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("test method is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("test method failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("test method skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("main execution started");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("main execution ended");
	}


}
