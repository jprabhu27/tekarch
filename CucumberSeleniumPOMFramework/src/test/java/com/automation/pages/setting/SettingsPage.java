package com.automation.pages.setting;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class SettingsPage extends BasePage {

	@FindBy(xpath = "//div[@id = 'PersonalInfo']")
	WebElement personalLink;
	@FindBy(id = "LoginHistory_font")
	WebElement loginHistoryLink;
	@FindBy(xpath = "//div[@id='RelatedUserLoginHistoryList_body']/div/a")
	WebElement downloadHistoryLink;
	@FindBy(xpath = "//span[@id='DisplayAndLayout_font']")
	WebElement displayAndLayoutLink;
	@FindBy (xpath = "//span[@id='CustomizeTabs_font']")
	WebElement customizeMyTabsLink;
	@FindBy (xpath = "//a[@id='duel_select_0_right']")
	WebElement addButton;
	@FindBy (xpath = "//*[@id='bottomButtonRow']/input[1]")
	WebElement saveButton;
	@FindBy (xpath = "//div[@id='EmailSetup']")
	WebElement emailNameLink;
	@FindBy (xpath = "//span[@id='EmailSettings_font']")
	WebElement emailSettingsLink;
	@FindBy (xpath = "//input[@id='sender_name']")
	WebElement emailNameTextBox;
	@FindBy (id = "sender_email")
	WebElement emailAddressBox;
	@FindBy (xpath = "//input[@id='auto_bcc1']")
	WebElement bccRadioButton;
	@FindBy (xpath = "//*[@id='bottomButtonRow']/input[1]")
	WebElement saveEmailSettingsPage;
	@FindBy (xpath = "//span[@id='CalendarAndReminders_font']")
	WebElement calendarsAndRemindersLink;
	@FindBy (xpath = "//span[@id='Reminders_font']" )
	WebElement activityRemindersLink;
	@FindBy (xpath = "//input[@id='testbtn']" )
	WebElement openTestReminderButton;
	@FindBy (id = "summary")
	WebElement reminderPopUp;
	
	//softAssert softassert = new SoftAssert();
	
	public SettingsPage(WebDriver driver) {

		super(driver);

	}

	public WebDriver clickPersonalLink() {
		clickElement(personalLink, "Personal link clicked");
		return driver;

	}

	public WebDriver clickloginHistoryLink() {
		clickElement(loginHistoryLink, "Login History link");
		return driver;

	}
	
	public WebDriver clickDownloadloginHistory() {
		clickElement(downloadHistoryLink, "Download Login History link");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		return driver;
	}
	
	public WebDriver clickDisplayAndLayout() {
		clickElement(displayAndLayoutLink, "Display and Layout link");
		return driver;
	
	}
	
	public WebDriver clickCustomizeMyTabs() {
		clickElement(customizeMyTabsLink, "Customize My Tabs link");
		
		return driver;
	}
	
	public WebDriver clickAddButton() {
		
		clickElement(addButton, "Add Button");
		return driver;
	}
	
	public WebDriver clickSaveButton() {
		
		clickElement( saveButton, "Save Button");
		return driver;
	}
	
	public WebDriver clickEmailNameLink() {
		clickElement(emailNameLink , "Email Name link");
		return driver;
	}
	
	public WebDriver clickEmailSettingsLink() {
		clickElement(emailSettingsLink , "Email Setting Link");
		return driver;
	}
	
	public WebDriver clickEmailNameTextBox() {
		
		clickElement(emailNameTextBox , "Email Name textBox");
		emailNameTextBox.clear();
		emailNameTextBox.sendKeys("Jaya P.");
		return driver;
	}
	
	public WebDriver clickEmailAddressBox() {
		
		clickElement(emailAddressBox , "Email address textBox");
		emailAddressBox.clear();
		emailAddressBox.sendKeys("jprabhu.27@gmail.com");
		return driver;
	}
	
	public WebDriver clickBccRadioButton() {
		clickElement(bccRadioButton, "BCC Radio Button");
		return driver;
	}
	
	public WebDriver clickSaveEmailSettingsPage() {
		clickElement(saveEmailSettingsPage, "[My Email Settings] Save button");
		return driver;
	}
	
	public WebDriver clickCalendarsAndRemindersLink() {
		
		clickElement(calendarsAndRemindersLink, "Calendars and Reminders link");
		
		return driver;
	}
	
	public WebDriver clickActivityRemindersLink() {
		
		clickElement(activityRemindersLink, "Activity Reminders link");
		
		return driver;
	}
	
	public String getTestRemindersPopupTitle() {
		
		return openPopup_getTitle_closePopup(openTestReminderButton, "'Open a Test Reminder'");
	}
	
	
}
