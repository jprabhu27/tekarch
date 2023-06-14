package com.firebase.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class ChromePlugin extends BaseTest {

	public static void main(String[] args) {
		// Add Chrome Plugin
		
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
			
		
		File ext = new File("C:\\Users\\Ketogal\\Downloads\\momentum_2.8.1_0.crx");
		
		opt.addExtensions(ext);
		
		ChromeDriver driver = new ChromeDriver(opt);

		driver.get("chrome://extensions/");
		
		
		driver.close();
		//Use the 4.9.1 version 

	}

}
