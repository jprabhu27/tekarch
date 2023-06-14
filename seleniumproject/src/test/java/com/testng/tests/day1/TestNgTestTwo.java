package com.testng.tests.day1;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNgTestTwo {
	
	@Parameters({"browserName","version"})
	@Test
	public void testscript_1(String name,String version1) {
		System.out.println("name="+name+ " and version="+version1);
		System.out.println("i am in TestNgTestTwo class and testScript_1 ");
		
	}
	@Test
	public void testscript_2() {
		System.out.println("i am in TestNgTestTwo class and testScript_2");
		
	}
	

}
