package com.automation.pages.login;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automation.pages.base.BasePage;
import com.automation.utility.PropertiesUtility1;

public class LoginPage extends BasePage {

	// By userName = By.id("email_field");
	// WebElement userNameElement = driver.findElement(userName);

//	PropertiesUtility1 pro = new PropertiesUtility1();
//	Properties appProp = pro.loadFile("applicationDataProperties");

	@FindBy(id = "username")
	WebElement userNameElement;
	@FindBy(id = "password")
	WebElement passwordElement;
	@FindBy(id = "Login")
	WebElement loginButton;
	@FindBy(id = "error")
	WebElement errorDiv;
	@FindBy(id = "rememberUn")
	WebElement rememberMeElement;
	@FindBy(id = "forgot_password_link")
	WebElement forgotPasswordElement;
	
	
	public LoginPage(WebDriver driver) {

		super(driver);
	}
	
	public String getUsername()
	{
		return getValueFromWebElement(userNameElement, "username field");	
	}
	
	public void enterUsername(String usernamedata) {

		enterText(userNameElement, usernamedata, "username field");

	}

	public void enterPassword(String passworddata) 
	{
		enterText(passwordElement, passworddata, "password field");
	}

	public void clearPassword()
	{
		clearElement(passwordElement, "password field");
	}
	
	public WebDriver clickLoginButton() 
	{
		clickElement(loginButton, "login button");
		return driver;
	}

	public void checkRememerMe() 
	{
		checkTheCheckBox(rememberMeElement, "Remember me");
	}
	
	public String getTitleOfThePage() {

		waitUntilPageLoads();
		return getPageTitle();

	}

	public String getErrorMessage()
	{
		waitFluentForVisibility(errorDiv, "error message");
		return errorDiv.getText();
	}
	
	public WebDriver clickForgotPasswordLink() {
		clickElement(forgotPasswordElement, "Forgot Your Password link");
		return driver;		
	}
		
	
	
	}
	
	

