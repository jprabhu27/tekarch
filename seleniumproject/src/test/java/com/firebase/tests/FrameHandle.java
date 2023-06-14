package com.firebase.tests;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FrameHandle extends BaseTest {

	public static void main(String[] args) throws InterruptedException {
		// Frame Handle
		
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://demoqa.com/frames");
		driver.switchTo().frame("frame1");
		String text = driver.findElement(By.xpath("//h1[@id ='sampleHeading']")).getText();
		System.out.println("text 1 = "+text);
		
		driver.switchTo().defaultContent(); //Go back to the default page
		driver.switchTo().frame("frame2");
		String text2 = driver.findElement(By.xpath("//h1[@id ='sampleHeading']")).getText();
		System.out.println("text 2 = "+text2);
		
		Thread.sleep(5000);
		driver.close();

	}

}
