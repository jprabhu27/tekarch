package com.testing.Appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculatorApp {
	
	static AndroidDriver<MobileElement> driver;

	public static void main(String[] args) throws Exception {
		
		DesiredCapabilities desiredCapability = new DesiredCapabilities();
		desiredCapability.setCapability("deviceName", "R58N121H16P");
		desiredCapability.setCapability("platformName", "Android");
		desiredCapability.setCapability("platformVersion", "10");

		
		desiredCapability.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		desiredCapability.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		//desiredCapability.setCapability("noReset", true);
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapability);
		

	}

}
