package com.automation.tests;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Properties;
import com.automation.pages.setting.*;

import com.automation.base.BaseTest;
import com.automation.pages.home.HomePage;

public class SettingsTests extends BaseTest{
	
	HomePage homePage;

	SettingsTests(HomePage homePage) {
		this.homePage = homePage;
	}
	
	public WebDriver mySettings() {
		
		driver = homePage.clickMySettings();
		
		SettingsPage settingsPage = new SettingsPage(driver);
		String expectedMySettingPageTitle = "Hello, Jaya Prab! ~ Salesforce - Developer Edition";
		String actualMySettingsPageTitle = settingsPage.getPageTitle();
		assertEqualsWithReportLog(actualMySettingsPageTitle, expectedMySettingPageTitle, "User My Settings page is displayed");
		
		
		 settingsPage.clickPersonalLink();
		 settingsPage.clickloginHistoryLink();
		 		 		 
		 String expectedLoginHistoryPage= "Login History";
		 String actualLoginHistoryPage= driver.findElement(By.linkText("Login History")).getText();
		 assertEqualsWithReportLog(actualLoginHistoryPage, expectedLoginHistoryPage, "'Login History' page is displayed");
		
		 settingsPage.clickDownloadloginHistory(); 
		 
		 settingsPage.clickDisplayAndLayout();
		 settingsPage.clickCustomizeMyTabs();
		 
		 String expectedCustomizeTabTitle= "Customize My Tabs";
		 String actualCustomizeTabTitle= driver.findElement(By.linkText("Customize My Tabs")).getText();
		 assertEqualsWithReportLog(actualCustomizeTabTitle, expectedCustomizeTabTitle, "'Customize My Tabs' page is displayed");
				
		 Select salesforceChatter = new Select(driver.findElement(By.xpath("//*[@id = 'p4']")));
		 //selectByIndexData(salesforceChatter, 8,"Sales Force Chatter");
		 salesforceChatter.selectByIndex(8);
		 
		 Select reports= new Select(driver.findElement(By.xpath("//*[@id = 'duel_select_0']")));
		 //selectByIndexData(reports, 77,"Reports");
		 reports.selectByIndex(77);
			
		 settingsPage.clickAddButton();
		 settingsPage.clickSaveButton();
		 
		 settingsPage.clickEmailNameLink();
		 
		 settingsPage.clickEmailSettingsLink();
		 String expectedEmailSettingsTitle= "My Email Settings";
		 String actualEmailSettingsTitle= driver.findElement(By.linkText("My Email Settings")).getText();
		 assertEqualsWithReportLog(actualEmailSettingsTitle, expectedEmailSettingsTitle, "My Email Settings page is displayed");
		 
		 settingsPage.clickEmailNameTextBox();
		 settingsPage.clickEmailAddressBox();
		 
		 settingsPage.clickBccRadioButton();
		 settingsPage.clickSaveEmailSettingsPage();
		 
		 //My setting page is displayed
		 
		 
		 settingsPage.clickCalendarsAndRemindersLink();
		 settingsPage.clickActivityRemindersLink();
		 
		 String expectedActivityReminderTitle= "Activity Reminders";
		 String actualActivityReminderTitle= driver.findElement(By.linkText("Activity Reminders")).getText();
		 assertEqualsWithReportLog(actualActivityReminderTitle, expectedActivityReminderTitle, "Activity Reminder page is displayed");
		 
		 String actualPopupTitle = settingsPage.getTestRemindersPopupTitle();
		 Assert.assertTrue(actualPopupTitle.contains("Reminder"));
		 
		return driver;
	}
	
	
	
	

}
