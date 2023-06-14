package com.testing.tests.day3;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	
	public static String name;
	@Test(dataProvider = "sumData")
	public static void calculator(Integer a,Integer b,Integer c) {
		System.out.println(a+b+c);
		System.out.println(name);
	}
	
	
	@DataProvider(name="sumData")
	public static Object[][] getData() {
		Integer[][] data=new Integer[3][3];
		data[0][0]=1;
		data[0][1]=1;
		data[0][2]=1;
		data[1][0]=2;
		data[1][1]=2;
		data[1][2]=2;
		data[2][0]=3;
		data[2][1]=3;
		data[2][2]=3;
		
		return data;
		
	}


}
