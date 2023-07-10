package com.testing.Appium;

import java.net.URL;
import java.util.Set;
import java.io.File;

import org.openqa.selenium.By;
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
		//desiredCapability.setCapability("appActivity", "com.amazon.mShop.navigation.MainActivity");
		desiredCapability.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
		desiredCapability.setCapability("noReset", true);
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapability);
		
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"2 days until epic deals. Prime day is July 11-12. Video Player\"]/android.view.View/android.view.View/android.widget.TextView[2]")).click();
		
		Thread.sleep(3000);
		
		//Switch context from native to webview
		
		Set<String> contexts = driver.getContextHandles();
		
		//made sure we have web view content
		//assertThat(contexts.size(), greaterThan(1);
		
		for(String context:contexts) {
			
			System.out.println(contexts);
			if(!context.equals("Native_APP")) {
				driver.context((String)contexts.toArray()[1]);
				break;
			}
		}
		
		System.out.println("execute context switch successfully!!" +contexts.toArray()[1]);
		
		driver.findElement(By.id("com.amazon.mShop.android.shopping:id/bottom_chrome_bar_search_text_view")).click();
		
		
		
	}

}
