package com.firebase.tests;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.commons.logging.Log;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import io.netty.util.internal.ThreadLocalRandom;

import java.util.concurrent.TimeUnit;

public class SalesForceAutomation2 extends BaseTest {

	public static void main(String[] args) throws InterruptedException {

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));

		// System.out.println(System.getProperty("user.dir"));

		// String appPropertiesFilePath = ".\\resources\\applicationData.properties";
		String appPropertiesFilePath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\\\applicationData.properties";
		// String appPropertiesFilePath = "C:/Jaya/JAVA
		// BASICS/seleniumproject/src/test/resources";
		PropertiesUtility util = new PropertiesUtility();
		Properties props = util.loadFile(appPropertiesFilePath);

		// login_error_message_1_testcase(props);

		// login_to_salesforce_2_testcase(props);

		// check_remember_me_3_testcase(props);

		// forgot_password_4A_testcase(props);

		// forgot_password_4B_testcase(props);

		// username_dropdown_5_testcase(props);

		// myProfile_option_6_testcase (props);

		// mySettings_7_testcase(props);

		// developersConsole_option_8_testcase(props);

		// logout_option_9_testcase(props);

		// createAnAccount_option_10_testcase(props);

		// createANewView_11_testcase(props);

		// editView_12_testcase(props);

		// mergeAccounts_13_testcase(props);

		// createAccountReport_14_testcase(props);

		// opportunities_15_testcase(props);

		// createNewOpty_16_testcase(props);

		// pipelineReport_17_testcase(props);

		// stuckOpportunities_18_testcase(props);

		// quarterlySummartReport_19_testcase(props);

		// quarterlySummartReport_20_testcase(props);

		// validateViewDropDown_21_testcase(props);

		// functionalityOfGoBtn_22_testcase(props);

		// todaysLeads_23_testcase(props);

		// newLeads_24_testcase(props);

		// createNewContact_25_testcase(props);

		// viewUniqueName_26_testcase(props);

		// recentCreatedContact_27_testcase(props);

		// myContacts_28_testcase(props);

		// contactName_29_testcase(props);

		// contactName_30_testcase(props);

		// cancelButton_31_testcase(props);

		// saveNewButton_32_testcase(props);

		// verifyFirstLastName_33_testcase(props);

		// updatedLastNameVerify_34_testcase(props) ;

		// Initial setup required before running test case 35
		// Login to Salesforce and ensure Assets tab is seen

		verifyTabCustomization_35_testcase(props, "Assets", "//*[@id='Asset_Tab']/a");

	}

	private static void login_error_message_1_testcase(Properties props) throws InterruptedException {
		// Test case 1 Login Error message
		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);
		Thread.sleep(2000);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);

		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);
		clickElementById("Login");

		driver.close();
	}

	private static void login_to_salesforce_2_testcase(Properties props) throws InterruptedException {
		// Test Case 2 Login to SalesForce 2
		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);
		Thread.sleep(2000);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);

		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		String password = props.getProperty("password");
		enterTextById("password", password);
		clickElementById("Login");

		driver.close();
	}

	public static void check_remember_me_3_testcase(Properties props) throws InterruptedException {
		// Test Case 3 Check RememberMe

		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);
		Thread.sleep(2000);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);

		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		String password = props.getProperty("password");
		enterTextById("password", password);

		checkRememberMeBoxById("rememberUn");

		Thread.sleep(2000);

		clickElementById("Login");
		Thread.sleep(2000);

		// Log out of SFDC

		String logoutUrl = props.getProperty("logoutUrl");
		driver.get(logoutUrl);
		Thread.sleep(2000);

		validateTextById("username", loginName);

		driver.close();
	}

	public static void forgot_password_4A_testcase(Properties props) throws InterruptedException {

		// Test case 4a Forgot Password

		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);
		Thread.sleep(2000);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);

		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		// Forgot password page is displayed
		WebElement forgotPassword = driver.findElement(By.id("forgot_password_link"));
		forgotPassword.click();

		// Provide userName and click continue
		WebElement username = driver.findElement(By.id("un"));
		username.sendKeys("jprabhu.27@gmail.com");

		Thread.sleep(2000);
		clickElementById("continue");

		driver.close();

	}

	public static void forgot_password_4B_testcase(Properties props) throws InterruptedException {

		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);
		Thread.sleep(2000);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);

		String loginName = props.getProperty("wrongUserName");
		enterTextById("username", loginName);

		String password = props.getProperty("wrongPassword");
		enterTextById("password", password);

		Thread.sleep(2000);
		clickElementById("Login");
		driver.close();
	}

	public static void username_dropdown_5_testcase(Properties props) throws InterruptedException {

		// Select user menu for <user name> drop down

		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);

		// Call once per each test case
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);
		Thread.sleep(2000);

		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		Thread.sleep(2000);
		String password = props.getProperty("password");
		enterTextById("password", password);

		clickElementById("Login");

		// Build list of expected options
		ArrayList<String> expectedList = new ArrayList<>();
		expectedList.add("My Profile");
		expectedList.add("My Settings");
		expectedList.add("Developer Console");
		expectedList.add("Switch to Lightning Experience");
		expectedList.add("Logout");

		// Find the select element and get it's options
//				Select view = new Select(driver.findElement(By.xpath("//*[@id='userNavLabel']")));
//				List<WebElement> optionElements= view.getOptions();

		WebElement dropDown = driver.findElement(By.id("userNavLabel"));
		dropDown.isDisplayed();
		dropDown.click();

		List<WebElement> menus = driver.findElements(By.xpath("//div[@id='userNav-menuItems']/a"));

		// Iterate over all options to build list of actual options
		List<String> actualList = new ArrayList<>();
		for (WebElement menu : menus) {
			System.out.println("Reading a tag href=" + menu.getAttribute("href") + " text= " + menu.getText());
			actualList.add(menu.getText());
		}

		// Sort the actual and expected lists
		Collections.sort(actualList);
		Collections.sort(expectedList);

		// Compare the actual and expected lists

		if (actualList.equals(expectedList)) {
			System.out.println("Dropdown options match the expected list.");
		} else {
			System.out.println("Dropdown options do not match the expected list.");
		}

		driver.close();

	}

	public static void myProfile_option_6_testcase(Properties props) {

		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);

		// Call once per each test case
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		String password = props.getProperty("password");
		enterTextById("password", password);

		clickElementById("Login");

		WebElement dropDown = driver.findElement(By.id("userNavLabel"));
		dropDown.isDisplayed();
		dropDown.click();

		// Click "My Profile" option

		WebElement myProfile = driver.findElement(By.linkText("My Profile"));
		myProfile.sendKeys(Keys.ARROW_DOWN);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		myProfile.isSelected();
		myProfile.click();

		// Click on Edit Profile image

		WebElement edit = driver.findElement(By.xpath("//img[@title='Edit Profile']"));
		edit.isSelected();
		edit.click();

		// Click on About tab
		driver.switchTo().frame("contactInfoContentId");

		WebElement about = driver.findElement(By.xpath("//li[@id='aboutTab']/a"));
		about.click();

		// Last Name
		WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
		lastName.click();
		lastName.clear();
		lastName.sendKeys("Prab");
		clickElementByXpath("//input[@value='Save All']");

		driver.navigate().refresh();

		// Post Link

		WebElement postLink = driver.findElement(By.xpath("//*[@id=\"publisherAttachTextPost\"]"));
		postLink.click();

		Actions actions = new Actions(driver);
		driver.findElement(By.xpath("//*[@id='cke_43_contents']/iframe")).click();
		actions.sendKeys("Hi everyone!").build().perform();

		WebElement shareButton = driver.findElement(By.id("publishersharebutton"));
		shareButton.click();

		// File link
		clickElementByXpath("//a[@id= 'publisherAttachContentPost']");

		// Upload file
		clickElementByXpath("//a[@id= 'chatterUploadFileAction']");

		// Choose File
		WebElement fileUpload = driver.findElement(By.xpath("//input[@id= 'chatterFile']"));
		fileUpload.sendKeys("C:\\Users\\Ketogal\\Downloads\\SalesforceLogo.png");
		clickElementById("publishersharebutton");

		if (driver.getPageSource().contains("File Uploaded!")) {
			System.out.println("file uploaded");
		} else {
			System.out.println("file not uploaded");
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Hover mouse on add photo
		WebElement photoSection = driver.findElement(By.xpath("//*[@id='photoSection']"));
		Actions action = new Actions(driver);
		action.moveToElement(photoSection).perform();

		clickElementByXpath("//*[@id='uploadLink']");

		// Photo upload
		driver.switchTo().frame("uploadPhotoContentId");
		WebElement photoUpload = driver.findElement(By.xpath("//*[@id='j_id0:uploadFileForm:uploadInputFile']"));
		photoUpload.sendKeys("C:\\Users\\Ketogal\\Downloads\\SalesforceLogo.png");
		clickElementByXpath("//*[@id='j_id0:uploadFileForm:uploadBtn']");

		// driver.findElement(By.xpath("//*[@id='j_id0:uploadFileForm:uploadBtn']")).submit();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Save
		clickElementByXpath("//*[@id='j_id0:j_id7:save']");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// driver.close();
	}

	public static void mySettings_7_testcase(Properties props) {

		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);

		// Call once per each test case
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		String password = props.getProperty("password");
		enterTextById("password", password);

		clickElementById("Login");

		WebElement dropDown = driver.findElement(By.id("userNavLabel"));
		dropDown.isDisplayed();
		dropDown.click();

		// My Setting
		WebElement mySettings = driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[2]"));
		mySettings.click();

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		// Personal
		WebElement personal = driver.findElement(By.xpath("//div[@id = 'PersonalInfo']"));
		personal.isDisplayed();
		personal.click();

		// Login History
		clickElementById("LoginHistory_font");

		// Download login History
		clickElementByXpath("//div[@id='RelatedUserLoginHistoryList_body']/div/a");

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

		// Display & Layout
		clickElementByXpath("//span[@id='DisplayAndLayout_font']");

		// Customize my tabs
		clickElementByXpath("//span[@id='CustomizeTabs_font']");

		// Salesforce chatter
		Select salesforce = new Select(driver.findElement(By.xpath("//*[@id = 'p4']")));
		salesforce.selectByIndex(8);

		// Select Reports tab 77

		Select reports = new Select(driver.findElement(By.xpath("//*[@id = 'duel_select_0']")));
		reports.selectByIndex(77);

		// click add button
		clickElementByXpath("//a[@id='duel_select_0_right']");

		// Save
		clickElementByXpath("//*[@id='bottomButtonRow']/input[1]");

		// Email
		clickElementByXpath("//div[@id='EmailSetup']");

		// My Email Settings
		clickElementByXpath("//span[@id='EmailSettings_font']");

		// Email Name
		WebElement emailName = driver.findElement(By.xpath("//input[@id='sender_name']"));
		emailName.sendKeys("Jaya P.");

		// Email Address
		String login = props.getProperty(loginName);
		enterTextById("sender_email", loginName);

		// Automatic Bcc radio button
		clickElementByXpath("//input[@id='auto_bcc1']");

		// Save
		clickElementByXpath("//*[@id='bottomButtonRow']/input[1]");

		// Calendars & Reminders
		clickElementByXpath("//span[@id='CalendarAndReminders_font']");

		// Activity Reminders
		clickElementByXpath("//span[@id='Reminders_font']");

		// Open a Test Reminder Button
		clickElementByXpath("//input[@id='testbtn']");

//		String alertText = driver.switchTo().alert().getText();
//		System.out.println(alertText);
//		alertText
		// validate //*[@id="summary"]

		driver.close();

	}

	public static void developersConsole_option_8_testcase(Properties props) throws InterruptedException {

		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);

		// Call once per each test case
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		String password = props.getProperty("password");
		enterTextById("password", password);

		clickElementById("Login");

		WebElement dropDown = driver.findElement(By.id("userNavLabel"));
		dropDown.isDisplayed();
		dropDown.click();

		// Select the Developer Console option

		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("parentWindowHandle " + parentWindowHandle);

		WebElement developerConsole = driver.findElement(By.linkText("Developer Console"));

		developerConsole.isSelected();
		developerConsole.click();

		Thread.sleep(3000);

		String devConsolePopupHandle = null;

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			devConsolePopupHandle = iterator.next();
			System.out.println("Inside While " + devConsolePopupHandle);
		}

		System.out.println("devConsolePopupHandle " + devConsolePopupHandle);

		driver.switchTo().window(devConsolePopupHandle);
		driver.close();

		driver.switchTo().window(parentWindowHandle);

		driver.close();

	}

	public static void logout_option_9_testcase(Properties props) {

		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);

		// Call once per each test case
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		String password = props.getProperty("password");
		enterTextById("password", password);

		clickElementById("Login");

		// Usermenu for username dropdown

		WebElement dropDown = driver.findElement(By.id("userNavLabel"));
		dropDown.isDisplayed();
		dropDown.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement logout = driver.findElement(By.linkText("Logout"));

		logout.isSelected();
		logout.click();
		driver.close();

	}

	public static void createAnAccount_option_10_testcase(Properties props) {

		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);

		// Call once per each test case
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		String password = props.getProperty("password");
		enterTextById("password", password);

		clickElementById("Login");

		WebElement accountTab = driver.findElement(By.xpath("//li[@id = 'Account_Tab']"));
		accountTab.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement noThanks = driver.findElement(By.xpath("//input[@value = 'No Thanks']"));
		noThanks.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement send = driver.findElement(By.xpath("//input[@value = 'Send to Salesforce']"));
		send.click();
		WebElement createNew = driver.findElement(By.id("createNewButton"));
		createNew.isDisplayed();
		createNew.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		WebElement account = driver.findElement(By.linkText("Account"));
		account.click();

		WebElement account2 = driver.findElement(By.xpath("//input[@id='acc2']"));
		account2.sendKeys("Org Oil");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement type = driver.findElement(By.xpath("//select[@id='acc6']"));
		Select select = new Select(type);
		select.selectByIndex(6);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement priority = driver.findElement(By.xpath("//select[@id='00NHs00000Djja4']"));
		Select s = new Select(priority);
		s.selectByIndex(1);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement save = driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
				.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		save.click();

		driver.close();

	}

	public static void createANewView_11_testcase(Properties props) {

		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		String password = props.getProperty("password");
		enterTextById("password", password);

		clickElementById("Login");

		WebElement accountTab = driver.findElement(By.xpath("//li[@id = 'Account_Tab']"));
		accountTab.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement noThanks = driver.findElement(By.xpath("//input[@value = 'No Thanks']"));
		noThanks.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement send = driver.findElement(By.xpath("//input[@value = 'Send to Salesforce']"));
		send.click();

		WebElement newView = driver.findElement(By.linkText("Create New View"));
		newView.isDisplayed();
		newView.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement viewName = driver.findElement(By.xpath("//input[@id='fname']"));
		String uniqueString = getUniqueString();
		viewName.sendKeys("Quality " + uniqueString);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement save = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]"));
		System.out.println(save.getAttribute("name"));

		save.click();

		driver.close();
	}

	public static void editView_12_testcase(Properties props) {

		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		String password = props.getProperty("password");
		enterTextById("password", password);

		clickElementById("Login");

		WebElement accountTab = driver.findElement(By.xpath("//li[@id = 'Account_Tab']"));
		accountTab.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement noThanks = driver.findElement(By.xpath("//input[@value = 'No Thanks']"));
		noThanks.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement send = driver.findElement(By.xpath("//input[@value = 'Send to Salesforce']"));
		send.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Select view = new Select(driver.findElement(By.xpath("//select[@id='fcf']")));
		view.selectByIndex(5);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement edit = driver.findElement(By.linkText("Edit"));
		edit.click();

		WebElement viewName = driver.findElement(By.xpath("//input[@id='fname']"));
		viewName.clear();
		String uniqueString = getUniqueString();
		viewName.sendKeys("Quality " + uniqueString);
		viewName.click();

		Select field = new Select(driver.findElement(By.xpath("//*[@id='fcol1']")));
		field.selectByIndex(1);

		Select operator = new Select(driver.findElement(By.xpath("//*[@id='fop1']")));
		operator.selectByIndex(3);

		WebElement value = driver.findElement(By.xpath("//*[@id='fval1']"));
		value.click();
		value.sendKeys("a");

		WebElement save = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1]"));
		save.click();

		driver.close();

	}

	public static void mergeAccounts_13_testcase(Properties props) {

		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);

		// Call once per each test case
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		String password = props.getProperty("password");
		enterTextById("password", password);

		clickElementById("Login");

		WebElement accountTab = driver.findElement(By.xpath("//li[@id = 'Account_Tab']"));
		accountTab.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement noThanks = driver.findElement(By.xpath("//input[@value = 'No Thanks']"));
		noThanks.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement send = driver.findElement(By.xpath("//input[@value = 'Send to Salesforce']"));
		send.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Select account to merge
		WebElement merge = driver
				.findElement(By.xpath("//*[@id='toolsContent']/tbody/tr/td[2]/div/div/div/ul/li[4]/span/a"));
		merge.click();

		WebElement text = driver.findElement(By.xpath("//input[@id = 'srch']"));
		text.sendKeys("Org Oil");
		text.click();

		WebElement find = driver.findElement(By.xpath("//input[@value='Find Accounts']"));
		find.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement next = driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[5]/div/input[1]"));
		next.click();
		// Merge accounts
		WebElement mergeClick = driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[1]/div/input[2]"));
		mergeClick.click();

		// Alert pop up click ok
		Alert ok = driver.switchTo().alert();
		ok.accept();

		driver.close();

	}

	public static void createAccountReport_14_testcase(Properties props) {

		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);

		// Call once per each test case
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		String password = props.getProperty("password");
		enterTextById("password", password);

		clickElementById("Login");

		WebElement accountTab = driver.findElement(By.xpath("//li[@id = 'Account_Tab']"));
		accountTab.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement noThanks = driver.findElement(By.xpath("//input[@value = 'No Thanks']"));
		noThanks.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement send = driver.findElement(By.xpath("//input[@value = 'Send to Salesforce']"));
		send.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement activity = driver
				.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div/div[1]/ul/li[2]/a"));
		activity.click();

		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = today.format(formatter);

		WebElement fromDate = driver.findElement(By.xpath("//*[@id='ext-comp-1042']"));
		fromDate.click();
		fromDate.sendKeys(formattedDate);

		WebElement toDate = driver.findElement(By.xpath("//*[@id='ext-comp-1045']"));
		toDate.click();
		toDate.clear();

		toDate.sendKeys(formattedDate);

		toDate.sendKeys(Keys.TAB);

		driver.findElement(By.xpath("//*[@id='ext-gen63']")).click();
		driver.close();
	}

	public static void opportunities_15_testcase(Properties props) {

		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);

		// Call once per each test case
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		String password = props.getProperty("password");
		enterTextById("password", password);

		// Login to Salesforce
		clickElementById("Login");

		// Click Opportunities tab and then dismiss the popup
		clickElementByXpath("//*[@id='Opportunity_Tab']/a");
		clickElementByXpath("//*[@id='tryLexDialogX']");

		// Build list of expected options
		ArrayList<String> expectedList = new ArrayList<>();
		expectedList.add("All Opportunities");
		expectedList.add("Closing Next Month");
		expectedList.add("Closing This Month");
		expectedList.add("My Opportunities");
		expectedList.add("New Last Week");
		expectedList.add("New This Week");
		expectedList.add("Opportunity Pipeline");
		expectedList.add("Private");
		expectedList.add("Recently Viewed Opportunities");
		expectedList.add("Won");

		// Find the select element and get it's options
		Select view = new Select(driver.findElement(By.xpath("//*[@id='fcf']")));
		List<WebElement> optionElements = view.getOptions();

		// Iterate over all options to build list of actual options
		List<String> actualList = new ArrayList<>();
		for (WebElement option : optionElements) {
			System.out.println("Reading option value=" + option.getAttribute("value") + " text=" + option.getText());
			actualList.add(option.getText());
		}

		// Sort the actual and expected lists
		Collections.sort(actualList);
		Collections.sort(expectedList);

		// Compare the actual and expected lists

		if (actualList.equals(expectedList)) {
			System.out.println("Dropdown options match the expected list.");
		} else {
			System.out.println("Dropdown options do not match the expected list.");
		}

		driver.close();
	}

	public static void createNewOpty_16_testcase(Properties props) {

		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		String password = props.getProperty("password");
		enterTextById("password", password);

		clickElementById("Login");

		WebElement opportunities = driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a"));
		opportunities.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement help = driver.findElement(By.xpath("//*[@id=\"helpLink\"]"));
		help.sendKeys(Keys.TAB);
		help.sendKeys(Keys.TAB);
		help.sendKeys(Keys.TAB);

		WebElement noThanks = driver.findElement(By.xpath("//*[@id=\"lexNoThanks\"]"));
		noThanks.click();
		// help.sendKeys(Keys.ENTER);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement send = driver.findElement(By.xpath("//*[@id=\"lexSubmit\"]"));
		send.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement opt = driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
		opt.click();

		WebElement optName = driver.findElement(By.xpath("//input[@id = 'opp3']"));
		optName.sendKeys("Run");
		optName.click();
		optName.sendKeys(Keys.TAB);

		WebElement accName = driver.findElement(By.xpath("//*[@id=\"opp4\"]"));
		accName.clear();
		accName.sendKeys("Dickenson plc");
		accName.click();

		WebElement lead = driver.findElement(By.xpath("//select[@id='opp6']"));
		Select select = new Select(lead);
		select.selectByIndex(3);

		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = today.format(formatter);

		WebElement closeDate = driver.findElement(By.xpath("//input[@id = 'opp9']"));
		closeDate.click();
		closeDate.sendKeys(formattedDate);

		WebElement stage = driver.findElement(By.xpath("//select[@id='opp11']"));
		Select select1 = new Select(stage);
		select1.selectByIndex(2);

		WebElement source = driver.findElement(By.xpath("//input[@id = 'opp17']"));
		source.sendKeys("DM Campaign to Top Customers");
		source.click();

		WebElement save = driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
		save.click();

		driver.close();

	}

	public static void pipelineReport_17_testcase(Properties props) {

		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		String password = props.getProperty("password");
		enterTextById("password", password);

		clickElementById("Login");

		WebElement opportunities = driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a"));
		opportunities.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement help = driver.findElement(By.xpath("//*[@id=\"helpLink\"]"));
		help.sendKeys(Keys.TAB);
		help.sendKeys(Keys.TAB);
		help.sendKeys(Keys.TAB);

		WebElement noThanks = driver.findElement(By.xpath("//*[@id=\"lexNoThanks\"]"));
		noThanks.click();
		// help.sendKeys(Keys.ENTER);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement send = driver.findElement(By.xpath("//*[@id=\"lexSubmit\"]"));
		send.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement oppPipeline = driver
				.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[1]/a"));
		oppPipeline.click();

		driver.close();

	}

	public static void stuckOpportunities_18_testcase(Properties props) {

		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		String password = props.getProperty("password");
		enterTextById("password", password);

		clickElementById("Login");

		WebElement opportunities = driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a"));
		opportunities.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement help = driver.findElement(By.xpath("//*[@id=\"helpLink\"]"));
		help.sendKeys(Keys.TAB);
		help.sendKeys(Keys.TAB);
		help.sendKeys(Keys.TAB);

		WebElement noThanks = driver.findElement(By.xpath("//*[@id=\"lexNoThanks\"]"));
		noThanks.click();
		// help.sendKeys(Keys.ENTER);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement send = driver.findElement(By.xpath("//*[@id=\"lexSubmit\"]"));
		send.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement stuckOpp = driver
				.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[2]/a"));
		stuckOpp.click();

		driver.close();

	}

	public static void quarterlySummartReport_19_testcase(Properties props) {

		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);

		// Call once per each test case
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		String password = props.getProperty("password");
		enterTextById("password", password);

		clickElementById("Login");

		// Click the opportunity tab
		driver.findElement(By.xpath("//*[@id='Opportunity_Tab']/a")).click();
		driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();

		WebElement interval = driver.findElement(By.xpath("//select[@id='quarter_q']"));
		Select select = new Select(interval);
		select.selectByIndex(3);

		WebElement include = driver.findElement(By.xpath("//select[@id='open']"));
		Select select1 = new Select(include);
		select1.selectByIndex(0);

		clickElementByXpath("//input[@value = 'Run Report']");

		driver.close();

	}

	public static void quarterlySummartReport_20_testcase(Properties props) {

		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);

		// Call once per each test case
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		String password = props.getProperty("password");
		enterTextById("password", password);

		clickElementById("Login");

		// Click leads tab link
		clickElementByXpath("//a[@href='/00Q/o']");

		// Close popup
		driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();

		driver.close();

	}

	public static void validateViewDropDown_21_testcase(Properties props) {

		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);

		// Call once per each test case
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		String password = props.getProperty("password");
		enterTextById("password", password);

		clickElementById("Login");

		// Click leads tab link
		clickElementByXpath("//a[@href='/00Q/o']");

		// Close popup
		driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();

		// Expected results

		ArrayList<String> expectedList = new ArrayList<>();
		expectedList.add("All Open Leads");
		expectedList.add("My Unread Leads");
		expectedList.add("Recently Viewed Leads");
		expectedList.add("Today's Leads");
		expectedList.add("View - Custom 1");
		expectedList.add("View - Custom 2");

		Select dropdown = new Select(driver.findElement(By.xpath("//select[@id= 'fcf']")));

		List<WebElement> options = dropdown.getOptions();

		List<String> actualList = new ArrayList<>();
		// Iterate over all options to build list of actual options

		for (WebElement opt : options) {

			System.out.println("Reading option value=" + opt.getAttribute("value") + " text=" + opt.getText());
			actualList.add(opt.getText());
		}

		// Sort the actual and expected list

		Collections.sort(expectedList);
		Collections.sort(actualList);

		// Compare the actualList and expectedList

		if (actualList.equals(expectedList)) {
			System.out.println("Dropdown options match the expected list.");
		} else {
			System.out.println("Dropdown options do not match the expected list.");
		}

		WebElement dropDown = driver.findElement(By.id("userNavLabel"));
		dropDown.isDisplayed();
		dropDown.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Logout

		WebElement logout = driver.findElement(By.linkText("Logout"));

		logout.isSelected();
		logout.click();

		driver.close();

	}

	public static void functionalityOfGoBtn_22_testcase(Properties props) {

		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		getPage(loginUrl);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		String password = props.getProperty("password");
		enterTextById("password", password);

		clickElementById("Login");

		// Click leads tab link
		clickElementByXpath("//a[@href='/00Q/o']");

		// Close popup
		clickElementByXpath("//*[@id='tryLexDialogX']");

		Select dropdown = new Select(driver.findElement(By.xpath("//select[@id= 'fcf']")));
		dropdown.selectByIndex(1);

		// Logout

		// Logout
		WebElement dropDown = driver.findElement(By.id("userNavLabel"));
		dropDown.isDisplayed();
		dropDown.click();

		WebElement logout = driver.findElement(By.linkText("Logout"));
		logout.isSelected();
		logout.click();

		getPage(loginUrl);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		enterTextById("username", loginName);
		enterTextById("password", password);

		clickElementById("Login");

		// Click leads tab link
		clickElementByXpath("//a[@href='/00Q/o']");

		// Close popup
		clickElementByXpath("//*[@id='tryLexDialogX']");

		// Click go button
		driver.findElement(By.xpath("//form[@id='filter_element']/div/span/span[1]/input")).click();

		// Logout
		dropDown = driver.findElement(By.id("userNavLabel"));
		dropDown.isDisplayed();
		dropDown.click();

		logout = driver.findElement(By.linkText("Logout"));
		logout.isSelected();
		logout.click();

		// driver.close();

	}

	public static void todaysLeads_23_testcase(Properties props) {

		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);

		// Call once per each test case
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		String password = props.getProperty("password");
		enterTextById("password", password);

		clickElementById("Login");

		// Click leads tab link
		clickElementByXpath("//a[@href='/00Q/o']");

		// Close popup
		driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();

		// Select Today's lead from drop down
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@id= 'fcf']")));

		dropdown.selectByIndex(3);

		// Click on Go button

		driver.findElement(By.xpath("//form[@id='filter_element']/div/span/span[1]/input")).click();

		// Logout
		WebElement dropDown = driver.findElement(By.id("userNavLabel"));
		dropDown.isDisplayed();
		dropDown.click();

		WebElement logout = driver.findElement(By.linkText("Logout"));
		logout.isSelected();
		logout.click();

		driver.close();

	}

	public static void newLeads_24_testcase(Properties props) {

		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);

		// Call once per each test case
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		String password = props.getProperty("password");
		enterTextById("password", password);

		clickElementById("Login");

		// Click leads tab link
		clickElementByXpath("//a[@href='/00Q/o']");

		// Close popup
		driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();

		// New button
		driver.findElement(By.xpath("//form[@id='hotlist']/table/tbody/tr/td[2]/input")).click();

		// Last Name enter text
		WebElement lastName = driver.findElement(By.xpath("//input[@id = 'name_lastlea2']"));
		lastName.sendKeys("ABCD");

		// Company enter text
		WebElement company = driver.findElement(By.xpath("//input[@id = 'lea3']"));
		company.sendKeys("ABCD");

		// Save
		clickElementByXpath("//*[@id='topButtonRow']/input[1]");

		// Logout
		WebElement dropDown = driver.findElement(By.id("userNavLabel"));
		dropDown.isDisplayed();
		dropDown.click();

		WebElement logout = driver.findElement(By.linkText("Logout"));
		logout.isSelected();
		logout.click();

		driver.close();

	}

	// @Test
	public static void createNewContact_25_testcase(Properties props) {

		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);

		// Call once per each test case
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		String password = props.getProperty("password");
		enterTextById("password", password);

		clickElementById("Login");

		// Click leads Contact link
		clickElementByXpath("//a[@href='/003/o']");

		// Close popup
		driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();

		// Click New button
		clickElementByXpath("//input[@value = ' New ']");

		// Last Name
		WebElement lastName = driver.findElement(By.xpath("//input[@id = 'name_lastcon2']"));
		lastName.sendKeys("Johnson");

		// Account Name
		WebElement accountName = driver.findElement(By.xpath("//input[@id = 'con4']"));
		accountName.sendKeys("Dickenson plc");

		// Save
		clickElementByXpath("//*[@id='topButtonRow']/input[1]");

		// Logout
		WebElement dropDown = driver.findElement(By.id("userNavLabel"));
		dropDown.isDisplayed();
		dropDown.click();

		WebElement logout = driver.findElement(By.linkText("Logout"));
		logout.isSelected();
		logout.click();

		driver.close();
	}

	public static void viewUniqueName_26_testcase(Properties props) {

		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);

		// Call once per each test case
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		String password = props.getProperty("password");
		enterTextById("password", password);

		clickElementById("Login");

		// Click leads Contact link
		clickElementByXpath("//a[@href='/003/o']");

		// Close popup
		driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();

		// Click Create New View
		driver.findElement(By.linkText("Create New View")).click();

		// click View name
		WebElement viewName = driver.findElement(By.xpath("//input[@id = 'fname']"));
		viewName.sendKeys("Grey");

		// click View Unique name
		clickElementByXpath("//input[@id = 'devname']");

		// Save
		clickElementByXpath("//input[@value = ' Save ']");

		// Logout
		WebElement dropDown = driver.findElement(By.id("userNavLabel"));
		dropDown.isDisplayed();
		dropDown.click();

		WebElement logout = driver.findElement(By.linkText("Logout"));
		logout.isSelected();
		logout.click();

		driver.close();

	}

	public static void recentCreatedContact_27_testcase(Properties props) {

		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);

		// Call once per each test case
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		String password = props.getProperty("password");
		enterTextById("password", password);

		clickElementById("Login");

		// Click leads Contact link
		clickElementByXpath("//a[@href='/003/o']");

		// Close popup
		driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();

		Select created = new Select(driver.findElement(By.xpath("//select[@id = 'hotlist_mode']")));
		created.selectByIndex(0);

		driver.close();

	}

	public static void myContacts_28_testcase(Properties props) {

		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);

		// Call once per each test case
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		String password = props.getProperty("password");
		enterTextById("password", password);

		clickElementById("Login");

		// Click leads Contact link
		clickElementByXpath("//a[@href='/003/o']");

		// Close popup
		driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();

		Select view = new Select(driver.findElement(By.xpath("//select[@id = 'fcf']")));
		view.selectByIndex(5);

		driver.close();

	}

	public static void contactName_29_testcase(Properties props) {

		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);

		// Call once per each test case
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		String password = props.getProperty("password");
		enterTextById("password", password);

		clickElementById("Login");

		// Click leads Contact link
		clickElementByXpath("//a[@href='/003/o']");

		// Close popup
		driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();

		// Click on name under Recent Contacts

		clickElementByXpath("//a[@href='/003Hs00004WOQ6L']");

		// driver.close();

	}

	public static void contactName_30_testcase(Properties props) {

		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);

		// Call once per each test case
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		String password = props.getProperty("password");
		enterTextById("password", password);

		clickElementById("Login");

		// Click leads Contact link
		clickElementByXpath("//a[@href='/003/o']");

		// Close popup
		driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();

		// Click leads Create New View link
		clickElementByXpath("//*[@id= 'filter_element']/div/span/span[2]/a[2]");

		// Unique name enter text EFGH and get error message
		WebElement uniqueName = driver.findElement(By.xpath("//input[@id = 'devname']"));
		uniqueName.sendKeys("EFGH");

		// Save
		clickElementByXpath("//input[@value = ' Save ']");

		driver.close();

	}

	public static void cancelButton_31_testcase(Properties props) {

		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);

		// Call once per each test case
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		String password = props.getProperty("password");
		enterTextById("password", password);

		clickElementById("Login");

		// Click leads Contact link
		clickElementByXpath("//a[@href='/003/o']");

		// Close popup
		driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();

		// Click Create New View
		driver.findElement(By.linkText("Create New View")).click();

		// click View name
		WebElement viewName = driver.findElement(By.xpath("//input[@id = 'fname']"));
		viewName.sendKeys("ABCD");

		// click View Unique name
		WebElement viewUniqueName = driver.findElement(By.xpath("//input[@id = 'devname']"));
		viewUniqueName.click();
		viewUniqueName.clear();
		viewUniqueName.sendKeys("EFGH");

		// cancel
		clickElementByXpath("//input[@value = 'Cancel']");

		driver.close();

	}

	public static void saveNewButton_32_testcase(Properties props) {

		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);

		// Call once per each test case
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		String password = props.getProperty("password");
		enterTextById("password", password);

		clickElementById("Login");

		// Click leads Contact link
		clickElementByXpath("//a[@href='/003/o']");

		// Close popup
		driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();

		// New
		clickElementByXpath("//input[@value=' New ']");

		// click last name and enter text Indian
		WebElement lastName = driver.findElement(By.xpath("//input[@id = 'name_lastcon2']"));
		lastName.isSelected();
		lastName.sendKeys("Gonzalez");

		// click account name and enter text Global media
		WebElement accountName = driver.findElement(By.xpath("//input[@id = 'con4']"));
		accountName.isSelected();
		accountName.sendKeys("Edge Communications");

		// Save and new button
		clickElementByXpath("//input[@value = 'Save & New']");

		driver.close();

	}

	public static void verifyFirstLastName_33_testcase(Properties props) {

		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);

		// Call once per each test case
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Login
		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		// Password
		String password = props.getProperty("password");
		enterTextById("password", password);

		clickElementById("Login");

		// Click Profile tab to compare the profile page and User page are same

		WebElement dropDown = driver.findElement(By.id("userNavLabel"));
		dropDown.isDisplayed();
		dropDown.click();

		// Click "My Profile" option

		WebElement myProfile = driver.findElement(By.linkText("My Profile"));
		myProfile.sendKeys(Keys.ARROW_DOWN);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		myProfile.isSelected();
		myProfile.click();

		// Get Url of the profile page

		String profilePageUrl = driver.getCurrentUrl();

		// Click Home tab
		clickElementByXpath("//li[@id ='home_Tab']");

		// Close popup
		driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();

		// Verify if the first and last name link is displayed and click

		WebElement verify = driver.findElement(By.xpath("//div[@id='ptBody']/div/div[2]/span[1]/h1/a"));
		Boolean result = verify.isDisplayed();
		System.out.println("First and last name link display result =" + result);
		verify.click();

		// Verify the first and last name page is same as My Profile page

		String homePageUrl = driver.getCurrentUrl();

		if (profilePageUrl.equals(homePageUrl)) {
			System.out.println("The profile page and first and last name User page are same");
		} else {
			System.out.println("The profile page and first and last name User page are not same");
		}

		driver.close();
	}

	public static void updatedLastNameVerify_34_testcase(Properties props) {

		String browser = props.getProperty("browser");
		launchBrowser(browser);

		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);

		// Call once per each test case
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String expectedTitle = "Login | Salesforce";
		validateTitle(expectedTitle);

		// Login
		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		// Password
		String password = props.getProperty("password");
		enterTextById("password", password);

		clickElementById("Login");

		WebElement dropDown = driver.findElement(By.id("userNavLabel"));
		dropDown.isDisplayed();
		dropDown.click();

		// Click "My Profile" option

		WebElement myProfile = driver.findElement(By.linkText("My Profile"));
		myProfile.sendKeys(Keys.ARROW_DOWN);

		myProfile.isSelected();
		myProfile.click();
		// String myProfileUrl =

		clickElementByXpath("//li[@id ='home_Tab']");

		// Close popup
		driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();

		// Verify if the first and last name link is displayed and click

		WebElement verify = driver.findElement(By.xpath("//div[@id='ptBody']/div/div[2]/span[1]/h1/a"));
		Boolean result = verify.isDisplayed();
		System.out.println("First and last name link display result= " + result);
		verify.click();

		// Edit Profile icon

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Click on Edit Profile

		WebElement edit = driver.findElement(By.xpath("//img[@title='Edit Profile']"));
		edit.isSelected();
		edit.click();

		Boolean clicked = edit.isSelected();
		System.out.println("The Edit button is clicked= " + clicked);

		// Verify if the Edit Profile page is displayed

		WebElement contactInfoTitleElement = driver.findElement(By.xpath("//*[@id= 'contactInfoTitle']"));

		Boolean isdisplayed = contactInfoTitleElement.isDisplayed();
		System.out.println("The Edit page is displayed= " + isdisplayed);
		driver.switchTo().frame("contactInfoContentId");

		// About Tab
		WebElement about = driver.findElement(By.xpath("//li[@id='aboutTab']/a"));
		about.click();

		// Last Name
		String newLastName = "Abcd";
		WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
		lastName.click();
		lastName.clear();
		lastName.sendKeys(newLastName);
		clickElementByXpath("//input[@value='Save All']");

		driver.navigate().refresh();

		// Verify Last Name is displayed
		String expectedFullName = "Jaya " + newLastName;
		String actualBreadCrumbFullName = driver.findElement(By.xpath("//*[@id= 'tailBreadcrumbNode']")).getText()
				.trim();

		System.out.println("actualBreadCrumbFullName = " + actualBreadCrumbFullName);
		if (expectedFullName.equals(actualBreadCrumbFullName)) {

			System.out.println("The updated name '" + actualBreadCrumbFullName + "' is displayed in breadcrumb");

		} else {
			System.out.println("The updated name '" + actualBreadCrumbFullName + "' doesn't match expected name '"
					+ expectedFullName + "' in breadcrumb");
		}

		// Verify UserMenu First and Last Name is updated
		dropDown = driver.findElement(By.id("userNavLabel"));
		String actualUserMenuName = dropDown.getText().trim();

		if (expectedFullName.equals(actualUserMenuName)) {

			System.out.println("The updated name '" + actualUserMenuName + "' is displayed in user menu");

		} else {
			System.out.println("The updated name '" + actualUserMenuName + " doesn't match " + expectedFullName
					+ "' in user menu");
		}

		// Verify the User:First and Last Name has the updated last name

		// driver.close;

	}

	public static void verifyTabCustomization_35_testcase(Properties props, String tabName, String tabXpath) {
		String browser = props.getProperty("browser");
		launchBrowser(browser);

		loginToSalesforce(props);

		// Make sure Assets tab is shown

		try {
			// Let's see if drive can find the tab
			driver.findElement(By.xpath(tabXpath));
			System.out.println("The '" + tabName + "' is visible, we're ready to proceed with our test");
		} catch (NoSuchElementException e) {
			System.out.println("The '" + tabName + "' tab is not visible, please add it and then re-run this test");
			return;
		}

		// Click on the All Tab

		WebElement allTab = driver.findElement(By.id("AllTab_Tab"));
		allTab.isSelected();
		allTab.click();

		// verify if the All Tabs page is displayed
		WebElement allTabsPage = driver.findElement(By.xpath("//*[@id= 'bodyCell']/div[1]/div[1]/div[1]/h1"));
		Boolean result = allTabsPage.isDisplayed();
		System.out.println("The All Tabs page displayed is= " + result);

		// Click Customize My Tabs
		clickElementByXpath("//*[@id=\"bodyCell\"]/div[3]/div[1]/table/tbody/tr/td[2]/input");

		// Verify if the Customize My Tabs page is displayed
		WebElement customizeMyTabs = driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[1]/div[1]/div[1]/h1"));
		Boolean result2 = customizeMyTabs.isDisplayed();
		System.out.println("The Customize My Tabs page displayed is= " + result2);

		WebElement selectedTabs = driver.findElement(By.id("duel_select_1"));
		Select selectedDropdown = new Select(selectedTabs);
		selectedDropdown.selectByVisibleText(tabName);

		WebElement removeButton = driver.findElement(By.id("duel_select_0_left"));
		removeButton.isSelected();
		removeButton.click();

		// Verify Selected tabs should be moved to Available Tabs
		WebElement availTabs = driver.findElement(By.id("duel_select_0"));
		Select availDropdown = new Select(availTabs);

		boolean isMoved = false;
		List<WebElement> options = availDropdown.getOptions();
		for (WebElement option : options) {
			if (option.getText().equals(tabName)) {
				isMoved = true;
				break;
			}
		}

		if (isMoved)
			System.out.println("Pass: " + tabName + " tab found in Available Tabs");
		else
			System.out.println("Fail: " + tabName + " tab not found in Available Tabs");

		// Click Save
		driver.findElement(By.name("save")).click();

		// Verify All Tabs displayed
		WebElement allTabsDisplayed = driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[1]/div[1]/div[1]/h1"));
		System.out.println("All Tabs page displayed is = " + allTabsDisplayed.isDisplayed());

		// Verify tab removed not displayed in the tab bar
		try {
			driver.findElement(By.xpath(tabXpath));
			System.out.println("Fail: The " + tabName + " tab is visible");
		} catch (NoSuchElementException e) {
			System.out.println("Pass: The " + tabName + " tab is not visible");
		}

		// Logout
		logoutOfSalesforce(props);

		// verify Salesforce Login Page displayed
		validatePageTitle("Login | Salesforce", "Login page after clicking Logout link");

		// Launch and Login SalesForce Application
		System.out.println("Attempting to Launch and Login again to Salesforce");
		loginToSalesforce(props);
		validatePageTitle("Home Page ~ Salesforce - Developer Edition", "Home page");

		// Verify removed tab is still not shown
		try {
			driver.findElement(By.xpath(tabXpath));
			System.out.println("Fail: The " + tabName + " tab is visible after logging again");
		} catch (NoSuchElementException e) {
			System.out.println("Pass: The " + tabName + " tab is not visible  after logging again");
		}

		driver.close();
	}

	private static void loginToSalesforce(Properties props) {
		String loginUrl = props.getProperty("loginUrl");
		driver.get(loginUrl);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		validatePageTitle("Login | Salesforce", "Login page");

		// Login
		String loginName = props.getProperty("loginName");
		enterTextById("username", loginName);

		// Password
		String password = props.getProperty("password");
		enterTextById("password", password);

		clickElementById("Login");

	}

	private static void logoutOfSalesforce(Properties props) {

		System.out.println("Attempting to logout");
		driver.findElement(By.id("userNavLabel")).click();

		driver.findElement(By.linkText("Logout")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Logout successful");
	}
	
	
}
