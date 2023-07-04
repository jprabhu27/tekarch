package com.testing.Appium;

import java.net.URL;
import java.io.File;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AmazonDemo {

	static AndroidDriver<MobileElement> driver;
	
	public static void main(String[] args) throws Exception{
		
		File app = new File("C:\\Users\\Ketogal\\com.amazon.mShop.android.shopping.apk");
		
		DesiredCapabilities desiredCapability = new DesiredCapabilities();
		desiredCapability.setCapability("deviceName", "R58N121H16P");
		desiredCapability.setCapability("platformName", "Android");
		desiredCapability.setCapability("platformVersion", "10");

		desiredCapability.setCapability("app", app.getAbsolutePath());
		desiredCapability.setCapability("appPackage", "com.amazon.mShop.android.shopping");
		desiredCapability.setCapability("appActivity", "com.amazon.mShop.navigation.MainActivity");
		desiredCapability.setCapability("noReset", true);
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapability);
		
		
	}

}
