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
import io.appium.java_client.MultiTouchAction;

public class MultiTouchApp {

	static AndroidDriver<MobileElement> driver;

	public static void main(String[] args) throws Exception {
		
		
		DesiredCapabilities desiredCapability = new DesiredCapabilities();
		desiredCapability.setCapability("deviceName", "R58N121H16P");
		desiredCapability.setCapability("platformName", "Android");
		desiredCapability.setCapability("platformVersion", "10");

		
		desiredCapability.setCapability("appPackage", "com.easylabs.multitouch");
		desiredCapability.setCapability("appActivity", "com.easylabs.multitouch.MenuActivity");
		desiredCapability.setCapability("noReset", true);
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapability);
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		MobileElement startbutton = driver.findElement(By.id("com.easylabs.multitouch:id/buttonStart"));
		startbutton.click();
		
		Dimension size = driver.manage().window().getSize();
		int x1=(int)(size.width*0.20);
		int y1=(int)(size.height*0.20);
		
		int x2=(int)(size.width*0.80);
		int y2=(int)(size.height*0.20);
		
		int x3 =(int)(size.width*0.20);
		int y3 =(int)(size.height*0.80);
		
		int x4 =(int)(size.width*0.80);
		int y4 =(int)(size.height*0.80);
		
		int x5 =(int)(size.width*0.50);
		int y5 =(int)(size.height*0.50);
		
		TouchAction action1 = new AndroidTouchAction(driver);
		action1.press(PointOption.point(x1, y1)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)));
		
		TouchAction action2 = new AndroidTouchAction(driver);
		action2.press(PointOption.point(x2, y2)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)));
		
		TouchAction action3 = new AndroidTouchAction(driver);
		action3.press(PointOption.point(x3, y3)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)));
		
		TouchAction action4 = new AndroidTouchAction(driver);
		action4.press(PointOption.point(x4, y4)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)));
		
		TouchAction action5 = new AndroidTouchAction(driver);
		action5.press(PointOption.point(x5, y5)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)));
		
		MultiTouchAction maction = new MultiTouchAction(driver);
		maction.add(action1).add(action2).add(action3).add(action4).add(action5).perform();
		
		

	}

}
