package com.testing.tests.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationScripts1 {
	@Test
	public void JavaTestparallel1Method3() throws InterruptedException {
		String expected="Selenium";
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://qa-tekarch.firebaseapp.com/");
		Thread.sleep(1000);
		String actual=driver.getTitle();
		Assert.assertEquals(actual,expected);
	//	System.out.println("JavaTestparallel1Method1 executed");
		driver.close();
		
	}
	
	@Test
	public void JavaTestparallel1Method4() throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/date-picker");
		Thread.sleep(1000);
		//String actual=driver.getTitle();
		//System.out.println("JavaTestparallel1Method2 executed");
		driver.close();
	
	}


}
