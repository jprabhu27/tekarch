package com.testng.tests.day1;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNgTestOne {
	
	@Test
	public void testscript_1() {
		System.out.println("i am in TestNgTestOne class and testScript_1 ");
		
	}
	@Parameters({"browserName"})
	@Test
	public void testscript_2(String name1) {
		System.out.println("name from testngOne ="+name1);
		System.out.println("i am in TestNgTestOne class and testScript_2");
		
	}
	
	
	
	

}
