package com.firebase.tests;

import org.openqa.selenium.NoSuchElementException;

//import com.automation.base.BaseTest;
import com.logging.LoggingTest;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	// All reusable methods
	public static Logger log;
	public static WebDriver driver = null;
	public void setUpForBeforeTest() {
		log = LogManager.getLogger(BaseTest.class.getName());
		}
	
@BeforeMethod
	public static void launchBrowser(String browserName) {

		switch (browserName) {
		
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;

		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		}
		System.out.println(browserName + " opened");

//				
//		if (browserName.equalsIgnoreCase("FireFox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//			driver.manage().window().maximize();
//			
//		}
//		else if (browserName.equalsIgnoreCase("Chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			driver.manage().window().maximize();

	}

	public static void getPage(String url)
	{
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
	}
	
			// Username and Password
	
	public static void enterTextById(String id, String data) {

		WebElement element = driver.findElement(By.id(id));

		if (element.isDisplayed()) {
			element.clear();
			element.sendKeys(data);
			System.out.println(data + " is entered to the " + id + " field");
		} else {
			System.out.println(id + " element is not displayed");
		}

	}

				// Remember Me

	public static void checkRememberMeBoxById(String id) {

		WebElement rememberMeElement = driver.findElement(By.id(id));

		rememberMeElement.click();

		if (rememberMeElement.isSelected()) {
			System.out.println("Remember Me checkbox is checked");
		} else {
			System.out.println("Remember Me checkbox is NOT checked");
		}
	}
					//Click
	public static void clickElementByTagName(String tagName) {
		
		try
		{
			driver.findElement(By.tagName(tagName)).click();
		}
		catch (NoSuchElementException e) {
			System.out.println("Caught NoSuchElementException. Element not found by tagName: " + tagName);
		}
	}
	
	public static void clickElementById(String id) {
		try
		{
			driver.findElement(By.id(id)).click();
		}
		catch (NoSuchElementException e) {
			System.out.println("Caught NoSuchElementException. Element not found by id : " + id);
		}
	}

	public static void clickElementByXpath(String xpath) {
		try
		{
			driver.findElement(By.xpath(xpath)).click();
		}
		catch (NoSuchElementException e) {
			System.out.println("Caught NoSuchElementException. Element not found by xpath: " + xpath);
		}
	}

//	public static void logOut() {
//		WebElement logoutButton = driver.findElement(By.linkText("/secur/logout.jsp")).click();
//		
//		//wait for the logout process to complete (e.g. redirect to login page)
//		WebDriverWait wait=new WebDriverWait(driver,10);
//		wait.until(ExpectedConditions.urlContains("login"));//Wait until URL contains "login"
//	}

				//Validate
	
	public static void validateTextById(String id, String expectedResult) {
		WebElement element = driver.findElement(By.id(id));
		String actualResult = element.getAttribute("value");

		System.out.println("expectedResult=" + expectedResult);
		System.out.println("actualResult=" + actualResult);
		if (actualResult.equals(expectedResult)) {
			System.out.println("Text box with id " + id + " contains expected value " + expectedResult);
		} else {
			System.out.println("Text box with id " + id + " does not contain expected value");
		}

	}
	public static void validateTextByXpath(String actualResult , String Text) {
		WebElement element = driver.findElement(By.xpath(actualResult));
		String expectedResult = element.getAttribute("Text");

		System.out.println("expectedResult=" + expectedResult);
		System.out.println("actualResult=" + actualResult);
		if (actualResult.equals(expectedResult)) {
			System.out.println("Text box with xpath " + expectedResult + " contains expected value " + expectedResult);
		} else {
			System.out.println("Text box with id " + expectedResult+ " does not contain expected value");
		}
	}
	public static void getAttribute() {

	}
	
	public void enterText(WebElement element, String data, String objectName) {
		
		if(element.isDisplayed()) {
			clearElement(element,objectName);
			element.sendKeys(data);
			System.out.println("Pass:" +objectName  +" is entered to the username field");
		}
		else {
			System.out.println("Fail: "+objectName+ "element is not displayed");
		}
		
	}

	public void clearElement(WebElement element, String objName) {
		
		if(element.isDisplayed()) {
			element.clear();
			System.out.println("pass: " +objName + " element cleared");
		}else {
			
			System.out.println("fail: " +objName + "element not displayed");
		}
		
	}
	
	public void clickElement(WebElement element, String objName) {
		
		if(element.isDisplayed()) {
			element.click();
			System.out.println("pass: " +objName + " element clicked");
		}else {
			
			System.out.println("fail: " +objName + "element not displayed");
		}
	}
	
	public void goToUrl(String url) {
		driver.get(url);
		System.out.println(url + "is entered");
	}
	
	public void closeBrowser() {
		driver.close();
		System.out.println("Current browser closed");
		
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
	public String getTextFromWebElement(WebElement element, String name) {
		if (element.isDisplayed()) {
			return element.getText();
		}else {
			System.out.println(name + "Web Element is not displayed");
			return null;
		}
	}
//	public static void alertMessage(String errorMsg) {
//		
//		if (errorMsg.equals(expectedError)) {
//			System.out.println("Test Case Passed");
//		}else {
//			System.out.println("Test Case Failed");
//		}
//	}
	
//	public Alert switchToAlert() {
//		
//		Alert alert = driver.switchTo().alert();
//		System.out.println("Switched to alert");
//		return alert;
//		
//	}
//	public void AcceptAlert(Alert alert) {
//		
//		System.out.println("Alert accepted");
//		alert.accept();
//		
//	}
//	
//	public String getAlertText(Alert alert) {
//		System.out.println("extracting text in the alert");
//		return alert.getText();
//	}
//
//	public void dismisAlert() {
//		Alert alert = switchToAlert();
//		alert.dismiss();
//		System.out.println("Alert Dismissed");
//		
//	}
//	public void waitUntilPageLoads() {
//		
//		System.out.println("Waiting until page loads with 30 sec maximum");
//		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
//
//	}
//
//	public void moveToElementAction(WebElement ele, String objName) {
//		Actions action = new Actions(driver);
//		action.moveToElement(ele).build().perform();
//		System.out.println("Cursor moved to web element" +objName);
//
//	}
//	public void ContextClickAction(WebElement ele, String objName) {
//		Actions action = new Actions(driver);
//		action.contextClick(ele).build().perform();
//		System.out.println("Right click performed on web element" +objName);
//		
//	}

//	public static void waitUntilElementIsVisisble(WebElement ele, String objName) {
//		System.out.println("Waiting for an web element" +objName + "For its visbility");
//		wait = new WebDriverWait(driver,30);
//		wait.until(ExpectedConditions.visibilityOf(ele));

//	}
	
//	public void WaitUntilPresenceOfElementLocatedBy(By locator, String objName) {
//		System.out.println("Waiting for an web element"+objName + "for its visibility");
//		wait = new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.presenceOfElementLocated(locator);
//		
//	}

//	public static void dropdown(WebElement dropdownElement, String objectName) {
//		By dropdown = By.tagName("dropdown");
//		WebElement dropdownElement = driver.findElement(dropdown);
//		dropdownElement.click();
//	}
		//Validate
	public static void validateTitle(String expectedTitle) {
		String actualTitle = driver.getTitle();
		if (expectedTitle.equals(actualTitle)) {
			System.out.println("Title matched");
		} else {
			System.out.println("Title is not matched");
		}
	}

	public static void validatePageTitle(String expectedTitle, String pageName) {
		String actualTitle = driver.getTitle();
		if (expectedTitle.equals(actualTitle)) {
			System.out.println("Pass: " + pageName + " is displayed");
		} else {
			System.out.println("Fail: " + pageName + " is not displayed");
		}
	}
		//UUID 
	public static String getUniqueString() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	
//@Test
	public static void login() {
		
		Logger log = LogManager.getLogger(LoggingTest.class);
		log.info("browser has been launched");
		log.warn("printing warning messages");
		log.debug("printing debug messages");
		log.error("printing error");
		log.fatal("printing fatal messages");
		log.info("completed");
		
	}

//@AfterMethod
	public static void browserClose() {
		driver.close();
	}
	
	
}
