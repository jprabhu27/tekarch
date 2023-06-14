package com.testing.tests.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationScripts2 {
	
	@Test
	public void JavaTestparallel1Method1() throws InterruptedException {
		String expected="Login | Salesforce";
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		Thread.sleep(1000);
		String actual=driver.getTitle();
		Assert.assertEquals(actual,expected);
		System.out.println("JavaTestparallel1Method1 executed");
		driver.close();
		
	}
	
	@Test
	public void JavaTestparallel1Method2() throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		Thread.sleep(1000);
		//String actual=driver.getTitle();
		System.out.println("JavaTestparallel1Method2 executed");
		driver.close();
	
	}

}
