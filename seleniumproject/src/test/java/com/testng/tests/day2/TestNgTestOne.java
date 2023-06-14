package com.testng.tests.day2;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgTestOne extends BaseTest{
	
	@BeforeMethod
	public void setUpMethod(){
		System.out.println("inside beforeMethod TestNgTestOne class setUpMethod");
			
	}
	
	@AfterMethod
	public static void tearDownMethod() {
		
		System.out.println("inside afterMethod TestNgTestOne class tearDownMethod");
	}
	
	
	
	
	@Test
	public static void testScript_1() {
		System.out.println("i am in TestNgTestOne class and testScript_1 ");
		
	}
	

}
