package com.automation.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.automation.base.BaseTest;
import com.automation.pages.home.*;

public class UserMenuTests extends BaseTest {

	HomePage homePage;

	UserMenuTests(HomePage homePage) {
		this.homePage = homePage;
	}

	public WebDriver check_usermenu_options() {

		// Build list of expected options
		ArrayList<String> expectedList = new ArrayList<>();
		expectedList.add("My Profile");
		expectedList.add("My Settings");
		expectedList.add("Developer Console");
		expectedList.add("Switch to Lightning Experience");
		expectedList.add("Logout");

		homePage.userNameDropDown();

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
			log.info("Dropdown options match the expected list.");
			report.logTestInfo("Pass: Dropdown options match the expected list.");
		} else {
			log.info("Dropdown options do not match the expected list.");
			report.logTestInfo("Fail: Dropdown options do not match the expected list.");
		}

		return driver;

	}

	public WebDriver check_my_profile_option() {
	
		check_usermenu_options();
		driver = homePage.clickMyProfile();

		UserPage userPage = new UserPage(driver);

		String expectedMyProfileTitle = "User: Jaya Prab ~ Salesforce - Developer Edition";
		String actualMyProfileTitle = userPage.getTitleOfThePage();
		assertEqualsWithReportLog(actualMyProfileTitle, expectedMyProfileTitle, "User profile page is displayed");

		driver = userPage.clickEditProfile();
		userPage.clickAboutTab();
		userPage.enterLastName("Prab");
		userPage.clickSaveAllButton();
		
		String userProfileName = userPage.getUserProfileName();
		
		if (userProfileName.contains("Prab")) {
			report.logTestInfo("UserProfilePage with changed last name 'Prab' is displayed");
		}
		Assert.assertTrue(userProfileName.contains("Prab"));
		
		userPage.postMessage("Hi everyone.");
		
		try
		{
			driver.findElement(By.xpath("//*[text()='Hi everyone.']"));
			report.logTestInfo("'Hi everyone.' message is displayed on the page");
		}
		catch(NoSuchElementException e) {
			report.logTestInfo("Fail: 'Hi everyone.' message not found on the page");
		}
		
		userPage.uploadFile("C:\\Users\\Ketogal\\Downloads\\SalesforceLogo.png");
		
		try
		{
			driver.findElement(By.xpath("//span[text()='SalesforceLogo']"));
			report.logTestInfo("'SalesforceLogo.png' file posted");
		}
		catch(NoSuchElementException e) {
			report.logTestInfo("Fail: 'SalesforceLogo.png' file posting not found");
		}
		
		userPage.uploadProfilePhoto("C:\\Users\\Ketogal\\Downloads\\jaya_salesforce_profile.jfif");
		
		return driver;

	}

}
