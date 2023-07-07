package com.testing.Appium;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;

public class ContactApp {

	static AndroidDriver<MobileElement> driver;

	public static void main(String[] args) throws Exception {
		DesiredCapabilities desiredCapability = new DesiredCapabilities();
		desiredCapability.setCapability("deviceName", "R58N121H16P");
		desiredCapability.setCapability("platformName", "Android");
		desiredCapability.setCapability("platformVersion", "10");

		
		desiredCapability.setCapability("appPackage", "com.samsung.android.app.contacts");
		desiredCapability.setCapability("appActivity", "com.samsung.android.contacts.contactslist.PeopleActivity");
		desiredCapability.setCapability("noReset", true);
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapability);
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		MobileElement contact_name = driver.findElementByAccessibilityId("Home");
		//contact_name.click();
		
		TouchAction action = new AndroidTouchAction(driver);
		//action.tap(TapOptions.tapOptions().withElement(ElementOption.element(contact_name))).perform();
		/*
		 * action.longPress(LongPressOptions.longPressOptions().withElement(
		 * ElementOption.element(contact_name)))
		 * .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5))).perform();
		 */
		
		MobileElement menu = driver.findElement(By.id("com.samsung.android.app.contacts:id/drawer_icon"));
		action.tap(TapOptions.tapOptions().withElement(ElementOption.element(menu))).perform();
		
		Thread.sleep(4000);
		
		/*
		 * //Swipe
		 * action.longPress(LongPressOptions.longPressOptions().withPosition(PointOption
		 * .point(624,810))) .moveTo(PointOption.point(71,810)).release().perform();
		 * 
		 */
		
		//Calculation of the window size
		System.out.println(driver.manage().window().getSize());
		
		Dimension dimension = driver.manage().window().getSize();
		
		Double screenHeightStart = dimension.getHeight()*0.5;
		int scrollStart = screenHeightStart.intValue();
		
		Double screenHeightEnd = dimension.getHeight()*0.2;
		int scrollEnd = screenHeightStart.intValue();
		
		int x = (int)(dimension.width*0.5);
		
		action.press(PointOption.point(x,scrollStart))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
		.moveTo(PointOption.point(x,scrollEnd)).release().perform();
		
		
		
		
		
		
		
	}

}
