package com.testing.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.TouchAction;


public class CalculatorApp {
	
	static AndroidDriver<MobileElement> driver;

	public static void main(String[] args) throws Exception {
		
		DesiredCapabilities desiredCapability = new DesiredCapabilities();
		desiredCapability.setCapability("deviceName", "R58N121H16P");
		desiredCapability.setCapability("platformName", "Android");
		desiredCapability.setCapability("platformVersion", "10");

		
		desiredCapability.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		desiredCapability.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		desiredCapability.setCapability("noReset", true);
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapability);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		MobileElement button_five = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05"));
		button_five.click();
		System.out.println("button 5 clicked....");
		
		TouchAction action = new AndroidTouchAction(driver);
		
		MobileElement button_plus = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Plus\"]"));
		//button_plus.click();
		action.tap(TapOptions.tapOptions().withElement(ElementOption.element(button_plus))).perform();
		System.out.println("button plus clicked...");
		
		
		MobileElement button_four = driver.findElementByAccessibilityId("4");
		//button_four.click();
		action.tap(TapOptions.tapOptions().withElement(ElementOption.element(button_four))).perform();
		
		System.out.println("button four clicked...");
		
		//Android UI Automator (android) & XCUITest (iOS)
		
		/*MobileElement button_Equal = driver.findElementByAndroidUIAutomator("UiSelector()"
				+ ".resourceId(\"com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal\")");
				
		button_Equal.click();
		System.out.println("button equal clicked...");
		*/
		
		MobileElement button_Equal=driver.findElementByAndroidUIAutomator("UiSelector().text(\"=\")");
		//button_Equal.click();
		action.tap(TapOptions.tapOptions().withElement(ElementOption.element(button_Equal))).perform();
		System.out.println("Clicked on button Equal (=)");
		Thread.sleep(8000);
		action.tap(PointOption.point(300,900)).perform();
		System.out.println("my code executed successfully");
		
		Thread.sleep(4000);
		driver.quit();
		
		
	}

}
