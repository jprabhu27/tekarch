package com.automation.base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.automation.utility.*;
//import com.automation.utility.ExtentReportsUtility;
//import com.automation.utility.PropertiesUtility1;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	// All reusable methods
	protected static WebDriver driver;
	protected WebDriverWait wait;
	protected Log4JUtility logObject = Log4JUtility.getInstance();
	
	//protected Logger log;
	public static Logger log;
	public static Properties props = null;
	
	public static FileReader fr;
	public ExtentReportsUtility report = ExtentReportsUtility.getInstance();

	public Properties getProperties()
	{
		if (props == null)
		{
			PropertiesUtility1 propUtility = new PropertiesUtility1();
			props = propUtility.loadFile("applicationDataProperties");
		}
		
		return props;
	}
	
	public String getProperty(String key)
	{
		Properties props = getProperties();
		
		return props.getProperty(key);
	}
	
	@BeforeTest
	public void setUpForBeforeTest() {
		log = logObject.getLogger();
	}

	@BeforeMethod
	@Parameters("browserName")
	public void setUpBeforeTestMethod(@Optional("Chrome") String browName) {

		String url = getProperty("url");
		launchBrowser(browName);
		goToUrl(url);
		log.info("url entered in the url box");

	}

	@AfterMethod
	public void tearDownAfterTestMethod() {
		driver.close();
	}

	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public void launchBrowser(String browserName) {

		switch (browserName.toLowerCase()) {

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		}
		log.info(browserName + " browser opened");

	}
	
		public void goToUrl(String url) {
		driver.get(url);
		log.info(url + "is entered");
	}
	
		public void closeBrowser() {
		driver.close();
		log.info("Current browser closed");

	}
			
		public void refreshPage() {
			driver.navigate().refresh();
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

		public void checkRememberMeBoxById(String id) {

			WebElement rememberMeElement = driver.findElement(By.id(id));

			rememberMeElement.click();

			if (rememberMeElement.isSelected()) {
				log.info("Remember Me checkbox is checked");
			} else {
				log.info("Remember Me checkbox is NOT checked");
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

			log.info("expectedResult=" + expectedResult);
			log.info("actualResult=" + actualResult);
			if (actualResult.equals(expectedResult)) {
				log.info("Text box with id " + id + " contains expected value " + expectedResult);
			} else {
				System.out.println("Text box with id " + id + " does not contain expected value");
			}

		}

		public String getElementValueById(String id)
		{
			try
			{
				WebElement element = driver.findElement(By.id(id));
				
				log.info("Pass: Element with id " + id + " found");
				report.logTestInfo("Pass: Element with id " + id + " found");
				
				return element.getAttribute("value");
				
			}
			catch (NoSuchElementException e) {
				log.error("Fail: NoSuchElementException for element with id " + id);
				report.logTestInfo("Fail: NoSuchElementException for element with id " + id);

				return null;
			}
			

		}
		
		public void clickElement(WebElement element, String objName) {

			if (element.isDisplayed()) {
				element.click();
				log.info("Pass: " + objName + " element clicked");
				report.logTestInfo("Pass: " + objName + " element clicked");
			} else {

				log.error("Fail: " + objName + "element not displayed");
				report.logTestInfo("Fail: " + objName + "element not displayed");
			}
		}
		
		public WebDriver returnDriverInstance() {
			
			return driver;
		}
			
				
		public String getPageTitle() {
			return driver.getTitle();
		}

		
		public String getTextFromWebElement(WebElement element, String name) {
			
			waitFluentForVisibility(element, name);
			if (element.isDisplayed()) {
				return element.getText();
			} else {
				log.info(name + "Web Element is not displayed");
				return null;
			}
		}

		public void alertMessage(String errorMsg, String expectedError) {

			if (errorMsg.equals(expectedError)) {
				log.info("Test Case Passed");
			} else {
				log.info("Test Case Failed");
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
			log.info("Alert Dismissed");
			
		}
		
		public void waitUntilPageLoads() {

			log.info("Waiting until page loads with 30 sec maximum");
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		}

		public void moveToElementAction(WebElement ele, String objName) {
			Actions action = new Actions(driver);
			action.moveToElement(ele).build().perform();
			log.info("Cursor moved to web element" + objName);

		}

		public void ContextClickAction(WebElement ele, String objName) {
			Actions action = new Actions(driver);
			action.contextClick(ele).build().perform();
			log.info("Right click performed on web element" + objName);

		}

		public void waitUntilElementIsVisible(WebElement ele, String objName) {
			log.info("waiting for an web element" +objName +" forits visbility");
			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(ele));
		}

		public void waitUntilPresenceOfElementLocatedBy(By locator, String objName) {
			log.info("Waiting for an web element" + objName + "for its visibility");
			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		}
		
		public void waitUntilAlertIsPresent() {
			log.info("waiting for alert to be present");
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

		public static void dropdown(WebElement dropdownElement, String objectName) {
			By dropdown = By.tagName("dropdown");
			WebElement dropdownEle = driver.findElement(dropdown);
			dropdownEle.click();
		}

		public void validateTitle(String expectedTitle) {
			String actualTitle = driver.getTitle();
			if (expectedTitle.equals(actualTitle)) {
				log.info("Title matched");
			} else {
				log.info("Title is not matched");
			}
		}
		
		// UUID
		public String getUniqueString() {
			UUID uuid = UUID.randomUUID();
			return uuid.toString();
		}
		
		public void selectByTextData(WebElement element, String text, String objName) {
			Select selectCity = new Select(element);
			selectCity.selectByVisibleText(text);
			log.info(objName + "selected" + text);
			
		}
		
		public void selectByIndexData(WebElement element, int index, String objName) {
			Select selectCity = new Select(element);
			selectCity.selectByIndex(index);
			log.info(objName + "selected");
			
		}
		
		public void selectByValueData(WebElement element, String text, String objName) {
			
			Select selectCity = new Select(element);
			selectCity.selectByValue(text);
			log.info(objName + "selected");
			report.logTestInfo("Fail: " + objName + "element selected");
			
		}
		
		public void switchToWindowOpened(String mainWindowHandle) {
			
			Set<String> allWindowHandles = driver.getWindowHandles();
			for (String handle: allWindowHandles) {
				if(!mainWindowHandle.equalsIgnoreCase(handle))
					driver.switchTo().window(handle);
				}
			log.info("switched to new window");
			report.logTestInfo("Pass: " + "switched to new window");
		}
		
		public WebElement selectFromList(List<WebElement> list, String text) {
			WebElement country =null;
			for (WebElement i: list) {
				if (i.getText().equalsIgnoreCase(text)) {
					log.info("selected =" +i.getText());
					country = i;
					break;
				}
			}
			return country;
		}
				
		
		public File getScreenshotOfThePage(WebDriver driver) {
		//random value + data() + testcase name---> filename
		
		String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date(0));
		//String curDir = System.getProperty("user.dir");
		//String curDir = System.getProperty("user.dir");
		TakesScreenshot screenShot=(TakesScreenshot)driver;//driver will convert into screenShot object
		File imgFile = screenShot.getScreenshotAs(OutputType.FILE); //Capture the image
		File destFile = new File(Constants.SCREENSHOTS_DIRECTORY_PATH + date +".png");
		
		try {
			FileUtils.copyFile(imgFile, destFile); //store in destination file
			}
		catch (IOException e) {
				e.printStackTrace();
			}
		//log.info("screenshot captured at =" +destFile.getAbsolutePath());
		return destFile; //destination file will be returned
	}

	public void addInsideMethodLog()
	{
		// Method 0: getStackTrace
		// Method 1: addInsideMethodLog
		// Method 2: The method that is calling addInsideMethodLog
		String callingMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		log.info("Inside the " + callingMethodName + " test method");
	}
	
	public void assertEqualsWithReportLog(String actual, String expected)
	{
		if (actual.equals(expected)) {
			report.logTestInfo("Pass: expected [" + expected + "] equals actual [" + actual + "]");
		}
		else {
			report.logTestInfo("Fail: expected [" + expected + "] but found [" + actual + "]");
		}
		
		Assert.assertEquals(actual, expected);
	}
	
	public void assertEqualsWithReportLog(String actual, String expected, String logMessage)
	{
		if (logMessage != null && logMessage != "")
		{
			if (actual.equals(expected)) {
				report.logTestInfo(logMessage);
			}
			Assert.assertEquals(actual, expected);
		}
		else
		{
			assertEqualsWithReportLog(actual, expected);
		
		}
	}
}
