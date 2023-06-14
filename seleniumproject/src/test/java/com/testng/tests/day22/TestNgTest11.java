package com.testng.tests.day22;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgTest11 {
	
	@Test(groups = {"smoke","regression","functional"})
	public static void testMethod1() {
		System.out.println("inside TestNgTest11 class and testMethod1");
		//throw new ArithmeticException();
	}
	
	@Test(groups = {"smoke"})
	public static void testMethod2() {
		System.out.println("inside TestNgTest11 class and testMethod2");
		String exp="data";
		String actual="data1";
		
		Assert.assertEquals(exp, actual);
		System.out.println("completed");
				
	}
	
	@Test(groups = {"regression"})
	public static void testMethod3() {
		System.out.println("inside TestNgTest11 class and testMethod3");
	}


}
