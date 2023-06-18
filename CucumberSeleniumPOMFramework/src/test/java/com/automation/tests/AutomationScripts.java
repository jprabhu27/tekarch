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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.home.HomePage;
import com.automation.pages.login.LoginPage;
import com.automation.utility.PropertiesUtility1;
import com.automation.utility.TestEventListernersUtility;
import com.automation.pages.setting.*;
import com.automation.pages.accounts.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationScripts extends BaseTest {

	@Test(enabled = false)
	public void testcase01_login_error_message() {
		addInsideMethodLog();

		LoginTests loginTests = new LoginTests();
		driver = loginTests.login_without_password();
	}

	@Test(enabled = false)
	public void testcase02_login_to_sales_force() {

		addInsideMethodLog();

		LoginTests loginTests = new LoginTests();
		driver = loginTests.login_with_password();
	}

	@Test(enabled = false)
	public void testcase03_check_remember_me() {
		addInsideMethodLog();

		LoginTests loginTests = new LoginTests();
		driver = loginTests.login_with_remember_me();

	}

	@Test(enabled = false)
	public void testcase04a_forgot_password() {

		addInsideMethodLog();

		LoginTests loginTests = new LoginTests();
		driver = loginTests.forgot_Password();

	}

	@Test(enabled = false)
	public void testcase04b_forgot_password() {

		addInsideMethodLog();

		LoginTests loginTests = new LoginTests();
		loginTests.validate_login_error_message();

	}

	private static HomePage loginToSalesforce() {
		LoginTests loginTests = new LoginTests();
		driver = loginTests.login_with_password();
		return new HomePage(driver);
	}

	@Test(enabled = false)
	public void testcase05_username_dropdown() {
		
		addInsideMethodLog();
		HomePage homePage = loginToSalesforce();

		UserMenuTests userMenuTests = new UserMenuTests(homePage);
		userMenuTests.check_usermenu_options();

	}

	@Test(enabled = false)
	public void testcase06_myProfile_option() {

		addInsideMethodLog();
		HomePage homePage = loginToSalesforce();

		UserMenuTests userMenuTests = new UserMenuTests(homePage);
		userMenuTests.check_my_profile_option();

	}
	
	@Test(enabled = false)
	public void testcase07_mySettings() {
		
		addInsideMethodLog();
		HomePage homePage = loginToSalesforce();
		
		UserMenuTests userMenuTests = new UserMenuTests(homePage);
		userMenuTests.check_usermenu_options();	
		
		SettingsTests settingsTests= new SettingsTests(homePage);
		settingsTests.mySettings(); 
	
		
	}
	
	@Test(enabled = false)
	public void testcase08_developersConsole() {
		
		addInsideMethodLog();
		HomePage homePage = loginToSalesforce();
		
		UserMenuTests userMenuTests = new UserMenuTests(homePage);
		userMenuTests.check_usermenu_options();
		
		String expectedPopupTitle = "Developer Console";
		String actualPopupTitle = homePage.getDeveloperConsolePopupTitle();
		assertEqualsWithReportLog(actualPopupTitle, expectedPopupTitle, "'Developer Console' popup is displayed");
	}
	
	@Test(enabled = false)
	public void testcase09_logout_option() {
		
		addInsideMethodLog();
		HomePage homePage = loginToSalesforce();
		
		UserMenuTests userMenuTests = new UserMenuTests(homePage);
		userMenuTests.check_usermenu_options();
		
		driver = homePage.logoutButton();
		String expectedTitle = getProperty("expectedTitle");
		String actualTitle = driver.getTitle();

		assertEqualsWithReportLog(actualTitle, expectedTitle, "Login page is displayed");
	}

	@Test(enabled = true)
	public void testcase10_create_account() {
		
		addInsideMethodLog();
		HomePage homePage = loginToSalesforce();
		
		driver = homePage.clickAccountsTab();
		AccountsPage accountsPage = new AccountsPage(driver);
		
		String expectedTitle = "Accounts: Home ~ Salesforce - Developer Edition";
		String actualTitle = accountsPage.getPageTitle();
		assertEqualsWithReportLog(actualTitle, expectedTitle, "Accounts page is displayed");
		
		driver = accountsPage.clickNewButton(); 
		AccountEditPage accountEditPage = new AccountEditPage(driver);
		
		String expectedAccountName = "Org Oil";
		driver = accountEditPage.createAccount(expectedAccountName, "Technology Partner", "High");
		String actualAccountName = driver.findElement(By.xpath("//*[@id='contactHeaderRow']/div[2]/h2")).getText().trim();
		assertEqualsWithReportLog(actualAccountName, expectedAccountName, "New account page for '" + expectedAccountName + "' is displayed");
		
		
	}

}