package com.automation.pages.accounts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class AccountsPage extends BasePage{
	
	@FindBy(xpath = "//*[@id='hotlist']/table/tbody/tr/td[2]/input")
	WebElement newButton;

	public AccountsPage(WebDriver driver) {

		super(driver);

	}
	
	public WebDriver clickNewButton() {
		
		clickElement(newButton, "New Button");
		return driver;
	}
	
	////*[@id="acc2"]
	
	

}
