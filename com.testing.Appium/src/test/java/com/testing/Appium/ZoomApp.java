package com.testing.Appium;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ZoomApp {
	
	static AndroidDriver<MobileElement> driver;

	public static void main(String[] args) throws Exception {
		
		
		DesiredCapabilities desiredCapability = new DesiredCapabilities();
		desiredCapability.setCapability("deviceName", "R58N121H16P");
		desiredCapability.setCapability("platformName", "Android");
		desiredCapability.setCapability("platformVersion", "10");

		
		desiredCapability.setCapability("appPackage", "com.sec.android.gallery3d");
		desiredCapability.setCapability("appActivity", "com.samsung.android.gallery.app.activity.GalleryActivity");
		desiredCapability.setCapability("noReset", true);
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapability);
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("(//android.widget.FrameLayout[@content-desc=\"Button\"])[6]/android.widget.FrameLayout/android.widget.ImageView")).click();
		Dimension dimension = driver.manage().window().getSize();
		
		int x = (int)(dimension.width*0.5);
		int y = (int)(dimension.height*0.5);
		
		TouchAction action = new AndroidTouchAction(driver);
		
		Thread.sleep(3000);
		
		//zoom in
		action.press(PointOption.point(x, y)).release().perform()
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(20)))
		.press(PointOption.point(x, y)).release().perform();
		
	
		System.out.println("Image zoomed....");
		
		//Zoom out
		
		Thread.sleep(3000);
		action.press(PointOption.point(x, y)).release().perform()
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(20)))
		.press(PointOption.point(x, y)).release().perform();
		
		
		System.out.println("Image zoomed out....");	
		
		
		
}
}