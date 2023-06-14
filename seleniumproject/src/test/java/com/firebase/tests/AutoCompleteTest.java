package com.firebase.tests;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class AutoCompleteTest extends BaseTest {

	public static void main(String[] args) throws InterruptedException {
		// Use find elements, extract all the div and compare the text with united
		// states of America
		// Get text and validate weather it is showing usa or not.
		// If true the test case will pass or fail

		launchBrowser("Chrome");

		driver.get("https://qa-tekarch.firebaseapp.com");
		enterTextById("email_field", "admin123@gmail.com");
		enterTextById("password_field", "admin123");
		WebElement loginButton = driver.findElement(By.tagName("button"));
		loginButton.click();

//		WebDriverWait  wait= new WebDriverWait(driver, Duration.ofMillis(3000));
//		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("does-not-exist")));

		Thread.sleep(3000);

		driver.get("https://qa-tekarch.firebaseapp.com/autocomplete.html");

		Thread.sleep(3000);

		WebElement myInput = driver.findElement(By.id("myInput"));
		myInput.sendKeys("un");

//		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMillis(3000));
//		wait2.until(ExpectedConditions.visibilityOf(myInput));

		WebElement listDiv = driver.findElement(By.id("myInputautocomplete-list"));
		myInput.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);

		List<WebElement> countriesDiv = listDiv.findElements(By.xpath("div"));
		for (WebElement countryDiv : countriesDiv) {
			WebElement inputElt = countryDiv.findElement(By.tagName("input"));
			String countryName = inputElt.getAttribute("value");

			System.out.println(countryName + " " + countryName.equals("United States of America"));

			if (countryName.equals("United States of America")) {
				myInput.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				break;
			} else {
				myInput.sendKeys(Keys.ARROW_DOWN);
				Thread.sleep(2000);
			}
		}

		if (myInput.getAttribute("value").equals("United States of America"))
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");

	}

}
