package com.automation.pages.accounts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.pages.base.BasePage;

public class AccountEditPage extends BasePage {

	@FindBy(xpath = "//input[@id='acc2']")
	WebElement accountNameElement;
	@FindBy(xpath = "//select[@id='acc6']")
	WebElement accountTypeElement;
	@FindBy(xpath = "//select[@id='00NHs00000Djja4']")
	WebElement customerPriorityElement;
	@FindBy(xpath = "//*[@id='bottomButtonRow']/input[1]")
	WebElement saveButton;
	
	public AccountEditPage(WebDriver driver) {
		super(driver);
	}
	
	public WebDriver createAccount(String accountName, String accountType, String customerPriority) {
		
		//report.logTestInfo("Creating new account for '" + accountName + "'");
		enterText(accountNameElement, accountName, "Account Name");
		selectByVisibleText(accountTypeElement, accountType, "Account Type");
		selectByVisibleText(customerPriorityElement, customerPriority, "Customer Priority");
		
		clickElement(saveButton, "Save button");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		return driver;
	}

}
