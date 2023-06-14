package com.automation.tests;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.utility.PropertiesUtility1;
import com.automation.utility.TestEventListernersUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationScripts extends BaseTest {

	@Test
	public void login_to_firebase_testscript() throws InterruptedException {
		log.info("inside the login_to_firebase_testscript test method");

		// applicationDataProperties
		// studentRegistrationProperties
		PropertiesUtility1 pro = new PropertiesUtility1();
		Properties appProp = pro.loadFile("applicationDataProperties");

		String userId = appProp.getProperty("login.valid.userid");
		String password = appProp.getProperty("login.valid.password");

		String expectedTitle = "Selenium";

		String actualTitle = getPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);

		By userName = By.id("email_field");
		WebElement userNameElement = driver.findElement(userName);
		// WaitUntilElementIsVisible(userNameElement, "username field");
		enterText(userNameElement, userId, "username");

		By passwrd = By.id("password_field");
		WebElement passwordElement = driver.findElement(passwrd);
		enterText(passwordElement, password, "password");

		By button = By.tagName("button");
		WebElement buttonElement = driver.findElement(button);
		clickElement(buttonElement, "login button");
		//getScreenshotOfThePage(driver);
		
		String actualText = "Student Registration Form";
		By text = By.xpath("//h1[text()='Student Registration Form']");
		WebElement StuEle = driver.findElement(text);
		String expectedText = getTextFromWebElement(StuEle, "studentText");
		Assert.assertEquals(actualText,expectedText);

		closeBrowser();

	}

	@Test
	public void error_login_firebase_testscript() throws InterruptedException {

		// String expectedError = "Error : The password is invalid or the user does not
		// have a password.";
		String expectedTitle = "Selenium";
		PropertiesUtility1 pro = new PropertiesUtility1();
		Properties appProp = pro.loadFile("applicationDataProperties");

		String username = appProp.getProperty("login.invalid.userid");
		String password = appProp.getProperty("login.invalid.password");

		String actualTitle = getPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);

		String expectedError = "Error: There is no user record corresponding to this identifier. The user may have";

		By idLoc = By.id("email_field");
		WebElement userName = driver.findElement(idLoc);
		//waitUntilElementIsVisisble(userName,"username element");
		enterText(userName, username, "usernameEle");

		WebElement passwrd = driver.findElement(By.id("password_field"));
		enterText(passwrd, password, "passwordEle");

		driver.findElement(By.tagName("button")).click();
		Thread.sleep(5000);

		Alert alert = driver.switchTo().alert();
		String actualError = alert.getText();
		alert.accept();

		Assert.assertEquals(actualError, expectedError);

	}

	@Test
	public void Student_registration_Form() throws InterruptedException {

		PropertiesUtility1 pro = new PropertiesUtility1();
		Properties appProp = pro.loadFile("applicationDataProperties");

		String username = appProp.getProperty("login.valid.userid");
		String password = appProp.getProperty("login.valid.password");

		String expected = "Student Registration Form";

		By idLoc = By.id("email_field");
		WebElement userName = driver.findElement(idLoc);
		// waitUntilElementIsVisible(userName,"username element");
		enterText(userName, username, "usernameEle");

		WebElement passwrd = driver.findElement(By.id("password_field"));
		enterText(passwrd, password, "passwordEle");

		driver.findElement(By.tagName("button")).click();
		Thread.sleep(5000);

		PropertiesUtility1 pro1 = new PropertiesUtility1();
		Properties studentProp = pro1.loadFile("studentRegistrationProperties");

		String name = studentProp.getProperty("name");
		String fatherName = studentProp.getProperty("fathername");
		String city = studentProp.getProperty("city");

		WebElement nameEle = driver.findElement(By.id("name"));
		enterText(nameEle, name, "name field");
		WebElement femaleRadioButton = driver.findElement(By.xpath("//input[@id='radiobut' and @value='female']"));
		femaleRadioButton.click();
		WebElement cityDropdown = driver.findElement(By.id("city"));
		selectByTextData(cityDropdown,city, "city select element");
		//getScreenshotOfThePage(driver);
		
		closeBrowser();

	}

}