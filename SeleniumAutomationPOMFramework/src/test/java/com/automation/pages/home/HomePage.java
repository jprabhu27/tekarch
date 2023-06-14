package com.automation.pages.home;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.pages.base.BasePage;
import com.aventstack.extentreports.util.Assert;

public class HomePage extends BasePage {
	
	@FindBy(id = "userNavLabel")
	WebElement userDropdown;
	@FindBy(linkText = "Logout")
	WebElement logoutButton;
	@FindBy(id = "forgot_password_link")
	WebElement forgotPasswordElement;
	@FindBy(id = "un")
	WebElement usernameElement;
	@FindBy(linkText = "My Profile")
	WebElement myProfile;
	@FindBy(xpath = "//*[@id='userNav-menuItems']/a[2]")
	WebElement mySettings;
	@FindBy(linkText= "Developer Console")
	WebElement developerConsoleLink;
	@FindBy(xpath = "//li[@id = 'Account_Tab']")
	WebElement accountsTab;
	
	public HomePage(WebDriver driver) {

		super(driver);

	}

	public String getTitleOfThePage() {

		return getPageTitle();

	}

	
	public void userNameDropDown() 
	{
		clickElement(userDropdown, "Username dropdown");
		
	}
	
	
	public WebDriver logoutButton() {
		clickElement(logoutButton, "Logout Button");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	public WebDriver forgotPasswordPage() {
		
		clickElement(forgotPasswordElement, "Forgot Password Page");
		return driver;
	}
	
	public WebDriver provideUserName() {
		
		clickElement(usernameElement, "Providing user name");
		usernameElement.sendKeys("jprabhu.27@gmail.com");
		return driver;
	}
	
	public WebDriver clickMyProfile() {
		clickElement(myProfile, "My Profile link");
		//myProfile.sendKeys(Keys.ARROW_DOWN);
		return driver;
		
	}
	
	public WebDriver clickMySettings() {

		clickElement(mySettings, "My Setting option");
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		return driver;

	}
	
	public String getDeveloperConsolePopupTitle() {
		return openPopup_getTitle_closePopup(developerConsoleLink, "'Developer Console'");
	}
	
	private WebDriver clickTab(WebElement tabElement, String tabName) {
		try
		{
			clickElement(tabElement, tabName);
		
			//Clicking any tab from home page opens up "Try Lightning Experience" dialog
			//Close that dialog
			Thread.sleep(2000);
			clickElementByXpath("//a[@id='tryLexDialogX']");
			
			report.logTestInfo("Closed 'Try Lightning Experience' dialog");
		}
		catch(Exception e) {
			log.info(e.getStackTrace());
		}
		return driver;
	}
	
	public WebDriver clickAccountsTab() {
		return clickTab(accountsTab, "Accounts tab");
	}
	
}

