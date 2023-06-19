package com.automation.steps;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
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
import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Optional;
//import org.testng.annotations.Parameters;

import com.automation.pages.base.BasePage;
import com.automation.pages.home.HomePage;
import com.automation.pages.home.UserPage;
import com.automation.pages.login.LoginPage;
import com.automation.utility.Constants;
//import com.automation.utility.ExtentReportsUtility;
import com.automation.utility.Log4JUtility;
import com.automation.utility.PropertiesUtility1;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceStepDef {
	// All reusable methods

	protected static WebDriver driver;
	protected WebDriverWait wait;
	protected static Log4JUtility logObject = Log4JUtility.getInstance();

	// protected Logger log;
	public static Logger log;
	public static Properties props = null;

	public static FileReader fr;
	LoginPage loginPage;
	HomePage homePage;
	UserPage userPage;
	
	@AfterStep
	public void after_each_step(Scenario sc) throws IOException {
		//sc.log("After step executed");
		//System.out.println("After each step executed");
		
		//To take screenshot
		if((sc.isFailed())) {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		byte[]fileContent = FileUtils.readFileToByteArray(screenshot);
		sc.attach(fileContent, "image/png", "screenshot");
		}
		
	}

	@Given("user opens salesforce application")
	public void user_opens_salesforce_application() {
		String url = getProperty("url");
		log.info("Going to url " + url);
		goToUrl(url);
	}
	
	@Given("user launches and logs into salesforce") 
	public void user_launches_and_logs_into_salesforce() {
		user_opens_salesforce_application();
		user_on("LoginPage");
		loginPage.enterUsername(getProperty("username"));
		loginPage.enterPassword(getProperty("password"));
		driver = loginPage.clickLoginButton();
	}
	
	public Properties getProperties() {
		if (props == null) {
			PropertiesUtility1 propUtility = new PropertiesUtility1();
			props = propUtility.loadFile("applicationDataProperties");
		}

		return props;
	}

	public String getProperty(String key) {
		Properties props = getProperties();

		return props.getProperty(key);
	}

	@BeforeAll
	public static void setUpForBeforeAllScenarios() {
		log = logObject.getLogger();
	}

	@Before
	public void setUpBeforeEachScenarios() {
		launchBrowser("Chrome");
	}

	@After
	public void tearDown() {
		closeBrowser();
	}

	public static WebDriver getDriver() {
		return driver;
	}

	@When("user on {string}")
	public void user_on(String page) {
		if (page.equalsIgnoreCase("loginpage"))
			loginPage = new LoginPage(driver);
		else if (page.equalsIgnoreCase("homepage"))
			homePage = new HomePage(driver);
		else if (page.equalsIgnoreCase("userpage"))
			userPage = new UserPage(driver);
	}

	@When("user enters username")
	public void user_enters_username() {
		loginPage.enterUsername(getProperty("username"));
	}
	
	@When("user clears password")
	public void user_clears_password() {
		loginPage.clearPassword();
	}
	
	@Then("password field is empty")
	public void password_field_empty() {
		String expectedValue = "";
		String actualValue = loginPage.getPassword();
		
		if (actualValue.equals(actualValue))
			log.info("Password field is empty");
		
		Assert.assertEquals(actualValue, expectedValue);
	}
	
	@Then("error message {string} is displayed")
	public void error_message_is_displayed(String expectedMessage) {
		String actualMessage = loginPage.getErrorMessage();
		
		if (actualMessage.equals(expectedMessage))
			log.info("Expected error message is displayed: " + expectedMessage);
		else
			log.info("Expected error message is '" + expectedMessage + "' is not displayed, instead it displays: " + actualMessage);
		
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	@When("user enters password")
	public void user_enters_password() {
		loginPage.enterPassword(getProperty("password"));
	}
	
	@When("user clicks Login button")
	public void user_clicks_login_buttton() {
		driver = loginPage.clickLoginButton();
	}

	@When("user clicks username dropdown")
	public void user_clicks_username_dropdown()
	{
		homePage.userNameDropDown();
	}
	
	@Then("username dropdown contains {string} {string} {string} {string} {string}")
	public void username_dropdown_contains_menus(String menu1, String menu2, String menu3,
			String menu4, String menu5)
	{
		ArrayList<String> expectedList = new ArrayList<>();
		expectedList.add(menu1);
		expectedList.add(menu2);
		expectedList.add(menu3);
		expectedList.add(menu4);
		expectedList.add(menu5);

		List<WebElement> menus = driver.findElements(By.xpath("//div[@id='userNav-menuItems']/a"));

		// Iterate over all options to build list of actual options
		List<String> actualList = new ArrayList<>();
		for (WebElement menu : menus) {
			//System.out.println("Reading a tag href=" + menu.getAttribute("href") + " text= " + menu.getText());
			actualList.add(menu.getText());
		}

		// Sort the actual and expected lists
		Collections.sort(actualList);
		Collections.sort(expectedList);

		// Compare the actual and expected lists

		if (actualList.equals(expectedList)) {
			log.info("Username dropdown options match the expected list.");
		} else {
			log.info("Username dropdown options do not match the expected list.");
		}

		Assert.assertTrue(actualList.equals(expectedList));
	}
	
	@When ("user checks the remember me checkbox")
	public void user_checks_the_remeber_me_checkbox(){
	
		checkRememberMeBoxById("rememberUn");
		
	}
		
	@When("user clicks {string} menu")
	public void user_clicks_menu(String menuText) {
		if (menuText.equalsIgnoreCase("My Profile"))
			driver = homePage.clickMyProfile();
		else if (menuText.equalsIgnoreCase("My Settings"))
			driver = homePage.clickMySettings();
		else if (menuText.equalsIgnoreCase("Logout"))
			driver = homePage.logoutButton();
	}
	
	@Then("username is displayed")
	public void username_is_displayed() {
		String expectedUsername = getProperty("username");
		String actualUsername = loginPage.getUsername();
		
		log.info("expectedUsername: " + expectedUsername);
		log.info("actualUsername: " + actualUsername);
		Assert.assertEquals(actualUsername, expectedUsername);
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

		// WebElement logoutButton = driver.findElement(By.linkText(null)).click();

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

	public String getElementValueById(String id) {
		try {
			WebElement element = driver.findElement(By.id(id));

			log.info("Pass: Element with id " + id + " found");
			//report.logTestInfo("Pass: Element with id " + id + " found");

			return element.getAttribute("value");

		} catch (NoSuchElementException e) {
			log.error("Fail: NoSuchElementException for element with id " + id);
			//report.logTestInfo("Fail: NoSuchElementException for element with id " + id);

			return null;
		}

	}

	public void clickElement(WebElement element, String objName) {

		if (element.isDisplayed()) {
			element.click();
			log.info("Pass: " + objName + " element clicked");
			//report.logTestInfo("Pass: " + objName + " element clicked");
		} else {

			log.error("Fail: " + objName + "element not displayed");
			//report.logTestInfo("Fail: " + objName + "element not displayed");
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
		log.info("waiting for an web element" + objName + " forits visbility");
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

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public static void dropdown(WebElement dropdownElement, String objectName) {
		By dropdown = By.tagName("dropdown");
		WebElement dropdownEle = driver.findElement(dropdown);
		dropdownEle.click();
	}

	@Then("expecting page title to be {string}")
	public void validateTitle(String expectedTitle) {
		String actualTitle = driver.getTitle();
		if (expectedTitle.equals(actualTitle)) {
			log.info("Pass: expected title '" + expectedTitle + "' is displayed");
		} else {
			log.info("Fail: expected title '" + expectedTitle + "' is not displayed");
		}
		
		Assert.assertEquals(actualTitle, expectedTitle);
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
		//report.logTestInfo("Fail: " + objName + "element selected");

	}

	public void switchToWindowOpened(String mainWindowHandle) {

		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!mainWindowHandle.equalsIgnoreCase(handle))
				driver.switchTo().window(handle);
		}
		log.info("switched to new window");
		//report.logTestInfo("Pass: " + "switched to new window");
	}

	public WebElement selectFromList(List<WebElement> list, String text) {
		WebElement country = null;
		for (WebElement i : list) {
			if (i.getText().equalsIgnoreCase(text)) {
				log.info("selected =" + i.getText());
				country = i;
				break;
			}
		}
		return country;
	}

	public File getScreenshotOfThePage(WebDriver driver) {
		// random value + data() + testcase name---> filename

		String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date(0));
		// String curDir = System.getProperty("user.dir");
		// String curDir = System.getProperty("user.dir");
		TakesScreenshot screenShot = (TakesScreenshot) driver;// driver will convert into screenShot object
		File imgFile = screenShot.getScreenshotAs(OutputType.FILE); // Capture the image
		File destFile = new File(Constants.SCREENSHOTS_DIRECTORY_PATH + date + ".png");

		try {
			FileUtils.copyFile(imgFile, destFile); // store in destination file
		} catch (IOException e) {
			e.printStackTrace();
		}
		// log.info("screenshot captured at =" +destFile.getAbsolutePath());
		return destFile; // destination file will be returned
	}

	public void addInsideMethodLog() {
		// Method 0: getStackTrace
		// Method 1: addInsideMethodLog
		// Method 2: The method that is calling addInsideMethodLog
		String callingMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		log.info("Inside the " + callingMethodName + " test method");
	}

	public void assertEqualsWithReportLog(String actual, String expected) {
		if (actual.equals(expected)) {
			log.info("Pass: expected [" + expected + "] equals actual [" + actual + "]");
		} else {
			log.info("Fail: expected [" + expected + "] but found [" + actual + "]");
		}

		Assert.assertEquals(actual, expected);
	}

	public void assertEqualsWithReportLog(String actual, String expected, String logMessage) {
		if (logMessage != null && logMessage != "") {
			if (actual.equals(expected)) {
				log.info(logMessage);
			}
			Assert.assertEquals(actual, expected);
		} else {
			assertEqualsWithReportLog(actual, expected);

		}
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
