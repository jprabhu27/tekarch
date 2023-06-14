package com.automation.base;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
	protected Logger log;
	public ExtentReportsUtility report = ExtentReportsUtility.getInstance();

	@BeforeTest
	public void setUpForBeforeTest() {
		log = LogManager.getLogger(BaseTest.class.getName());

	}

	@BeforeMethod
	@Parameters("browserName")
	public void setUpBeforeTestMethod(@Optional("chrome") String browName) {
		PropertiesUtility1 pro = new PropertiesUtility1();
		Properties appProp = pro.loadFile("applicationDataProperties");
		String url = appProp.getProperty("url");
		launchBrowser("browName");
		goToUrl(url);
		log.info("url entered in the url box");

	}

	@AfterMethod
	public void tearDownAfterTestMethod() {
		driver.close();
	}

	public void launchBrowser(String browserName) {

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
		System.out.println(browserName + " browser opened");

	}
	// Username and Password

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
			System.out.println("Remember Me checkbox is checked");
		} else {
			System.out.println("Remember Me checkbox is NOT checked");
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

	public void enterText(WebElement element, String data, String objectName) {

		if (element.isDisplayed()) {
			clearElement(element, objectName);
			element.sendKeys(data);

			// can go with both the statements
			log.info("Pass:" + objectName + " is entered to the username field");// This is for log file
			report.logTestInfo("Pass:" + objectName + " is entered to the username field");// Extent report to generate
																							// customizable report
																							// including logging
																							// information
		} else {
			log.error("Fail: " + objectName + "element is not displayed");
			report.logTestInfo("Fail: " + objectName + "element is not displayed");
		}

	}

	public void clearElement(WebElement element, String objName) {

		if (element.isDisplayed()) {
			element.clear();
			log.info("pass: " + objName + " element cleared");
		} else {

			log.error("fail: " + objName + "element not displayed");
		}

	}

	public void clickElement(WebElement element, String objName) {

		if (element.isDisplayed()) {
			element.click();
			log.info("pass: " + objName + " element clicked");
		} else {

			log.error("fail: " + objName + "element not displayed");
		}
	}

	public void goToUrl(String url) {
		driver.get(url);
		log.info(url + "is entered");
	}
	
	public WebDriver returnDriverInstance() {
		
		return driver;
	}

	public void closeBrowser() {
		driver.close();
		log.info("Current browser closed");

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

	public void waitUntilElementIsVisible(WebElement element) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
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
		
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//				.withTimeout(Duration.ofSeconds(30))
//				.pollingEvery(Duration.ofSeconds(30))
//				//.ignoring(NoSuchElementException.class);
//		wait.until(ExpectedConditions.visibilityOf(ele));
		}

	public static void dropdown(WebElement dropdownElement, String objectName) {
		By dropdown = By.tagName("dropdown");
		WebElement dropdownEle = driver.findElement(dropdown);
		dropdownEle.click();
	}

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
	
	public void selectByTextData(WebElement element, String text, String objName) {
		Select selectCity = new Select(element);
		selectCity.selectByVisibleText(text);
		System.out.println(objName + "selected" + text);
		
	}
	
	public void selectByIndexData(WebElement element, int index, String objName) {
		Select selectCity = new Select(element);
		selectCity.selectByIndex(index);
		System.out.println(objName + "selected");
		
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
			
	public File getScreenshotOfThePage(WebDriver driver) {
		//random value + data() + testcase name---> filename
		
		String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date(0));
		
		TakesScreenshot screenShot=(TakesScreenshot)driver;//driver will convert into screenShot object
		File imgFile = screenShot.getScreenshotAs(OutputType.FILE); //Capture the image
		File destFile = new File(Constants.SCREENSHOTS_DIRECTORY_PATH + date +".png");
		
		try {
			FileUtils.copyFile(imgFile, destFile); //store in destination file
			}catch (IOException e) {
				e.printStackTrace();
			}
		
		return destFile; //destination file will be returned
	}

}
