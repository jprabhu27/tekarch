package com.testing.Appium;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ChromeApp {
	
	
	static AndroidDriver<MobileElement> driver;

	public static void main(String[] args) throws Exception {
		
		
		DesiredCapabilities desiredCapability = new DesiredCapabilities();
		desiredCapability.setCapability("deviceName", "R58N121H16P");
		desiredCapability.setCapability("platformName", "Android");
		desiredCapability.setCapability("platformVersion", "10");

		//desiredCapability.setCapability(MobileCapabilityType.Browser_Name, "chrome");
		
		//desiredCapability.setCapability("browserName", "Chrome");
		//desiredCapability.setCapability("appium:chromeOptions",ImmutableMap.of("w3c",false));
		
		desiredCapability.setCapability("appPackage", "com.android.chrome");
		desiredCapability.setCapability("appActivity", "org.chromium.chrome.browser.ChromeTabbedActivity");
		desiredCapability.setCapability("noReset", true);
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapability);
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.get("http://google.com/");
		
		//Chrome://inspect   (use this command on the browser. Click inspect under google.com to go in developer mode)

}
}
