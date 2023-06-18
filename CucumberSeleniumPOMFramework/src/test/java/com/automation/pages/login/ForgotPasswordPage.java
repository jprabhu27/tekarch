package com.automation.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class ForgotPasswordPage extends BasePage {

	@FindBy(id = "un")
	WebElement userNameElement;
	@FindBy(id = "continue")
	WebElement continueButton;
	
	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
	}

	public String getTitleOfThePage() {
		waitUntilPageLoads();
		return getPageTitle();
	}
	
	public void enterUsername(String usernamedata) {
		enterText(userNameElement, usernamedata, "username field");
	}

	public WebDriver clickContinueButton() {
		clickElement(continueButton, "Continue Button");
		return driver;
	}
}
