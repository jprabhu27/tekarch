package com.testing.Appium;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.*;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;

public class DragDropApp {
	

	static AndroidDriver<MobileElement> driver;

	public static void main(String[] args) throws Exception {
		
		
		DesiredCapabilities desiredCapability = new DesiredCapabilities();
		desiredCapability.setCapability("deviceName", "R58N121H16P");
		desiredCapability.setCapability("platformName", "Android");
		desiredCapability.setCapability("platformVersion", "10");

		
		desiredCapability.setCapability("appPackage", "dragdrop.stufflex.com.dragdrop");
		desiredCapability.setCapability("appActivity", "dragdrop.stufflex.com.dragdrop.splash");
		desiredCapability.setCapability("noReset", true);
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapability);
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		MobileElement button_first = driver.findElement(By.id("dragdrop.stufflex.com.dragdrop:id/btn_football"));
		button_first.click();
		
		MobileElement source_input = driver.findElement(By.id("dragdrop.stufflex.com.dragdrop:id/chooseB"));
		MobileElement destination_input = driver.findElement(By.id("dragdrop.stufflex.com.dragdrop:id/answer"));
		
		TouchAction action = new AndroidTouchAction(driver);
		action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(source_input)))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(ElementOption.element(destination_input)).release().perform();
		
		Thread.sleep(3000);
		
		action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(source_input)))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(ElementOption.element(destination_input)).release().perform();
		
		System.out.println("Successfully dropped the element...!!");
		
	
	}
}
