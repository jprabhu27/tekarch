package com.automation.pages.base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.NoSuchElementException;
import java.util.Properties;
//import com.automation.base.BaseTest;
import com.automation.utility.Constants;
//import com.automation.utility.ExtentReportsUtility;
import com.automation.utility.Log4JUtility;
import com.automation.utility.PropertiesUtility1;

public class BasePage {
	
	protected static WebDriver driver;
	protected WebDriverWait wait;
	protected Log4JUtility logObject = Log4JUtility.getInstance();
	protected Logger log;
	
	//public static PropertiesUtility1 prop = new PropertiesUtility1();
	public static FileReader fr;
	//public ExtentReportsUtility report = ExtentReportsUtility.getInstance();
	
	public BasePage(WebDriver driver) {
		
		BasePage.driver = driver;

		PageFactory.initElements(driver, this);
		log = logObject.getLogger();
	}
	
	// Username and Password
	
	public static WebDriver getDriver()
	{
		return driver;
	}

	public void enterText(WebElement element, String data, String objectName) {
		
		waitFluentForVisibility(element, objectName);

		if (element.isDisplayed()) {
			clearElement(element, objectName);
			element.sendKeys(data);

			// can go with both the statements
			log.info("Pass: " + objectName + " is entered");// This is for log file
			//report.logTestInfo("Pass: " + objectName + " is entered");// Extent report to generate
																							// customizable report
																							// including logging
																							// information
		} else {
			log.error("Fail: " + objectName + "element is not displayed");
			//report.logTestInfo("Fail: " + objectName + "element is not displayed");
		}

	}

	public void clearElement(WebElement element, String objName) {
		if (element.isDisplayed()) {
			element.clear();
			log.info("Pass: " + objName + " element cleared");
			//report.logTestInfo("Pass: " + objName + " element cleared");
		} else {

			log.error("Fail: " + objName + "element not displayed");
			//report.logTestInfo("Fail: " + objName + "element not displayed");
		}
	}
		public void enterTextById(String id, String data) {
			
			WebElement element = driver.findElement(By.id(id));

			if (element.isDisplayed()) {
				element.clear();
				element.sendKeys(data);
				log.info(data + " is entered to the " + id + " field");
			} else {
				log.error(id + " element is not displayed");
			}

		}

		// Remember Me

		public void checkTheCheckBox(WebElement checkBoxelement, String objName) {

			checkBoxelement.click();

			if (checkBoxelement.isSelected()) {
				log.info(objName + " checkbox checked");
			} else {
				log.info(objName + " checkbox not checked");
			}
		}
		
		public void clickElement(WebElement element, String objName) {

			if (element.isDisplayed()) {
				element.click();
				log.info("Pass: " + objName + " element clicked");
				System.out.println("Pass: " + objName + " element clicked");
			} else {

				log.error("Fail: " + objName + "element not displayed");
				System.out.println();
			}
		}

		public void clickElementByTagName(String tagName) {
			driver.findElement(By.tagName(tagName)).click();
		}

		public void clickElementById(String id) {
			driver.findElement(By.id(id)).click();
		}

		public void clickElementByXpath(String xpath) {
			driver.findElement(By.xpath(xpath)).click();
		}

		public static void logOut() {
			//WebElement logoutButton = driver.findElement(By.linkText(null)).click();

			// wait for the logout process to complete (e.g. redirect to login page)
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.urlContains("login"));// Wait until URL contains "login"
		}

		// Validate

		public void validateTextById(String id, String expectedResult) {
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

		public void getAttribute() {

		}
					
		public WebDriver returnDriverInstance() {
			
			return driver;
		}
			
				
		public String getPageTitle() {
			
			return driver.getTitle();
		}

		
		public void refreshPage() {
			driver.navigate().refresh();
		}


		public String getTextFromWebElement(WebElement element, String name) {
			
			waitFluentForVisibility(element, name);
			if (element.isDisplayed()) {
				return element.getText();
			} else {
				System.out.println(name + "Web Element is not displayed");
				return null;
			}
		}

		public String getValueFromWebElement(WebElement element, String name) {
			
			waitFluentForVisibility(element, name);
			if (element.isDisplayed()) {
				return element.getAttribute("value");
			} else {
				System.out.println(name + "Web Element is not displayed");
				return null;
			}
		}

		public static void alertMessage(String errorMsg, String expectedError) {

			if (errorMsg.equals(expectedError)) {
				System.out.println("Test Case Passed");
			} else {
				System.out.println("Test Case Failed");
			}
		}

		public Alert switchToAlert() {

			Alert alert = driver.switchTo().alert();
			log.info("Switched to alert");
			return alert;

		}

		public void AcceptAlert(Alert alert) {
		
			log.info("Alert accepted"); // updating all the syso with log.info
			alert.accept();	
		}

		public String getAlertText(Alert alert) {
			log.info("extracting text in the alert");
			return alert.getText();
		}


		public void dismisAlert() {
			Alert alert = switchToAlert();
			alert.dismiss();
			System.out.println("Alert Dismissed");
			
		}
		
		public void waitUntilPageLoads() {

			log.info("Waiting until page loads with 30 sec maximum");
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		}

		public void moveToElementAction(WebElement ele, String objName) {
			Actions action = new Actions(driver);
			action.moveToElement(ele).build().perform();
			System.out.println("Cursor moved to web element" + objName);

		}

		public void ContextClickAction(WebElement ele, String objName) {
			Actions action = new Actions(driver);
			action.contextClick(ele).build().perform();
			System.out.println("Right click performed on web element" + objName);

		}

		public void waitUntilElementIsVisible(WebElement ele, String objName) {
			System.out.println("waiting for an web element" +objName +" forits visbility");
			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(ele));
		}

		public void waitUntilPresenceOfElementLocatedBy(By locator, String objName) {
			System.out.println("Waiting for an web element" + objName + "for its visibility");
			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		}
		
		public void waitUntilAlertIsPresent() {
			System.out.println("waiting for alert to be present");
			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.alertIsPresent());
		}
		
		public void waitFluentForVisibility(WebElement ele, String obName) {
			
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(30))
					.ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.visibilityOf(ele));
			}

		public static void dropdownByTagName(WebElement dropdownElement, String objectName) {
			By dropdown = By.tagName("dropdown");
			WebElement dropdownEle = driver.findElement(dropdown);
			dropdownEle.click();
		}
		
		//**
		
		public void validateTitle(String expectedTitle) {
			String actualTitle = driver.getTitle();
			if (expectedTitle.equals(actualTitle)) {
				System.out.println("Title matched");
			} else {
				System.out.println("Title is not matched");
			}
		}

		// UUID
		public String getUniqueString() {
			UUID uuid = UUID.randomUUID();
			return uuid.toString();
		}
		
		public void selectByVisibleText(WebElement element, String text, String objName) {
			Select select = new Select(element);
			select.selectByVisibleText(text);
			log.info("'" + objName + "' dropdown selected by text '" + text + "'");
		}
		
		public void selectByIndex(WebElement element, int index, String objName) {
			Select select = new Select(element);
			select.selectByIndex(index);
			log.info("'" + objName + "' dropdown selected by index " + index);
			
		}
		
		public void selectByValueData(WebElement element, String text, String objName) {
			
			Select selectCity = new Select(element);
			selectCity.selectByValue(text);
			System.out.println(objName + "selected");
			
		}
		
		public void switchToWindowOpened(String mainWindowHandle) {
			
			Set<String> allWindowHandles = driver.getWindowHandles();
			for (String handle: allWindowHandles) {
				if(!mainWindowHandle.equalsIgnoreCase(handle))
					driver.switchTo().window(handle);
				}
			System.out.println("switched to new window");
		}
		
		public WebElement selectFromList(List<WebElement> list, String text) {
			WebElement country =null;
			for (WebElement i: list) {
				if (i.getText().equalsIgnoreCase(text)) {
					System.out.println("selected =" +i.getText());
					country = i;
					break;
				}
			}
			return country;
		}
				
		protected String openPopup_getTitle_closePopup(WebElement popupLink, String popupLinkName)
		{
			String popupTitle = "";
			
			try
			{
				String parentWindowHandle = driver.getWindowHandle();
				log.info("parentWindowHandle " + parentWindowHandle);
				
				log.info("Opening popup: " + popupLinkName);
				//report.logTestInfo("Opening popup: " + popupLinkName);

				clickElement(popupLink, popupLinkName);
				Thread.sleep(3000);
				
				String popupHandle = null;
				Set<String> handles = driver.getWindowHandles(); // get all window handles
				Iterator<String> iterator = handles.iterator();
				while (iterator.hasNext()){
					popupHandle = iterator.next();
				}
				
				log.info("popupHandle " + popupHandle);	
				
				driver.switchTo().window(popupHandle);
				Thread.sleep(8000); // Chrome changes title to "** New **" to get attention
				
				popupTitle = driver.getTitle();
				log.info("Popup title is " + popupTitle);
				//report.logTestInfo("Popup title is: " + popupTitle);
				
				// Close popup
				driver.close();
				log.info("Closed popup");
				//report.logTestInfo("Closed popup");
				
				driver.switchTo().window(parentWindowHandle);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return popupTitle;
		}
		
		
		
	}

	


