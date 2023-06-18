package com.automation.tests;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.home.HomePage;
import com.automation.pages.login.LoginPage;
import com.automation.pages.login.ForgotPasswordPage;

public class LoginTests extends BaseTest {
	
	
	public WebDriver login_without_password()
	{
		LoginPage loginPage = new LoginPage(driver);

		String expectedTitle = getProperty("expectedTitle");
		String actualTitle = loginPage.getTitleOfThePage();
		Assert.assertEquals(actualTitle, expectedTitle);
		
		String username = getProperty("username");
		loginPage.enterUsername(username);
		loginPage.clearPassword();
		loginPage.clickLoginButton();

		String expectedError = getProperty("expectedError");
		String actualError = loginPage.getErrorMessage();
		Assert.assertEquals(actualError, expectedError);
		
		return driver;
	}
	
	public WebDriver login_with_password()
	{
		LoginPage loginPage = new LoginPage(driver);
		String expectedTitle = getProperty("expectedTitle");
		String actualTitle = loginPage.getTitleOfThePage();
		assertEqualsWithReportLog(actualTitle, expectedTitle);

		String username = getProperty("username");
		String password = getProperty("password");
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		driver=loginPage.clickLoginButton();
		
		expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		HomePage homepage = new HomePage(driver);
		actualTitle = homepage.getTitleOfThePage();
		assertEqualsWithReportLog(actualTitle, expectedTitle, "Home page is displayed");
		
		return driver;
	}
	
	public WebDriver login_with_remember_me()
	{
		LoginPage loginPage = new LoginPage(driver);
		String expectedTitle = getProperty("expectedTitle");
		String actualTitle = loginPage.getTitleOfThePage();
		Assert.assertEquals(actualTitle, expectedTitle);

		String username = getProperty("username");
		String password = getProperty("password");
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.checkRememerMe();
		
		loginPage.clickLoginButton();
		
		expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		HomePage homePage = new HomePage(driver);
		actualTitle = homePage.getTitleOfThePage();
		Assert.assertEquals(actualTitle, expectedTitle);
		
		homePage.userNameDropDown();
		driver = homePage.logoutButton();
		
		String actualUsername = getElementValueById("username");
		//System.out.println("actualUsername: " + actualUsername);
		Assert.assertEquals(actualUsername, username);
		
		return driver;
	}
	
	public  WebDriver forgot_Password() {
		
		LoginPage loginPage = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		String expectedTitle = getProperty("expectedTitle");
		String actualTitle = loginPage.getTitleOfThePage();
		assertEqualsWithReportLog(actualTitle, expectedTitle);
		
		driver = loginPage.clickForgotPasswordLink();
		
		expectedTitle = "Forgot Your Password | Salesforce";
		ForgotPasswordPage forgotPassPage = new ForgotPasswordPage(driver);
		actualTitle = forgotPassPage.getTitleOfThePage();
		assertEqualsWithReportLog(actualTitle, expectedTitle);
		
		String username = getProperty("username");
		forgotPassPage.enterUsername(username);
		driver = forgotPassPage.clickContinueButton();
		
		String expectedCheckEmailTitle = "Check Your Email";
		String actualCheckEmailTitle = driver.findElement(By.id("header")).getText();
		assertEqualsWithReportLog(actualCheckEmailTitle, expectedCheckEmailTitle);
		return driver;
		
	}
	
	public WebDriver validate_login_error_message() {
		
		LoginPage loginPage = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		
		String expectedTitle = getProperty("expectedTitle");
		String actualTitle = loginPage.getTitleOfThePage();
		assertEqualsWithReportLog(actualTitle, expectedTitle);
		
		loginPage.enterUsername("123");
		loginPage.enterPassword("22131");
		driver = loginPage.clickLoginButton();
		
		String expectedError = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		String actualError = driver.findElement(By.id("error")).getText();
		assertEqualsWithReportLog(actualError, expectedError);
		
		return driver;
		
	}
	
}
