package com.testng.tests.day2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	@BeforeSuite
	public static void setUpSuite() {
		System.out.println("inside beforeSuite BaseTest class setUpSuite");
		
		
	}
	@AfterSuite
	public static void tearDownSuite() {
		System.out.println("inside afterSuite BaseTest class tearDownSuite");
	}
	
	@BeforeTest
	public void setUpTest(){
		System.out.println("inside beforeTest BaseTest class setUpTest");
			
	}
	
	@AfterTest
	public static void tearDownTest() {
		
		System.out.println("inside afterTest BaseTest class tearDownTest");
	}
	
	
	@BeforeClass
	public static void setUpClass() {
		System.out.println("inside beforeclass BaseTest class setUpClass");
	}
	@AfterClass
	public static void tearDownclass() {
		System.out.println("inside afterclass BaseTest class tearDownclass");
	}
	

}
