package com.testng.tests.day2;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgTestTwo extends BaseTest{
	
	@BeforeMethod
	public void setUpMethod(){
		System.out.println("inside beforeMethod TestNgTestTwo class setUpMethod");
			
	}
	
	@AfterMethod
	public static void tearDownMethod() {
		
		System.out.println("inside afterMethod TestNgTestTwo class tearDownMethod");
	}
	
	@Test
	public static void testScript_1() {
		System.out.println("i am in TestNgTestTwo class and testScript_1 ");
		
	}
	

}
