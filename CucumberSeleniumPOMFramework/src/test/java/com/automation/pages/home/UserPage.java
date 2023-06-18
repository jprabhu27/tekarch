package com.automation.pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

import org.openqa.selenium.WebDriver;

public class UserPage extends BasePage {

	@FindBy(xpath = "//img[@title='Edit Profile']")
	WebElement editProfile;
	@FindBy(xpath = "//li[@id='aboutTab']/a")
	WebElement aboutTab;
	@FindBy(xpath = "//li[@id='contactTab']/a")
	WebElement contactTab;
	@FindBy(xpath = "//input[@id='lastName']")
	WebElement lastNameElement;
	@FindBy(xpath = "//input[@value='Save All']")
	WebElement saveAllButton;
	@FindBy(xpath = "//*[@id='tailBreadcrumbNode']")
	WebElement userProfileNameElement;
	@FindBy(xpath = "//*[@id='publisherAttachTextPost']")
	WebElement postLink;
	@FindBy(xpath="//*[@id='cke_43_contents']/iframe")
	WebElement postContent;
	@FindBy(id="publishersharebutton")
	WebElement shareButton;
	@FindBy(xpath = "//a[@id= 'publisherAttachContentPost']")
	WebElement fileAttachContent;
	@FindBy(xpath = "//a[@id= 'chatterUploadFileAction']")
	WebElement uploadFileLink;
	@FindBy(xpath = "//input[@id= 'chatterFile']")
	WebElement chooseChatterFileElement;
	@FindBy(xpath = "//*[@id='photoSection']")
	WebElement photoSection;
	@FindBy(xpath = "//*[@id='uploadLink']")
	WebElement uploadPhotoLink;
	@FindBy(xpath = "//*[@id='j_id0:uploadFileForm:uploadInputFile']")
	WebElement choosePhotoFileElement;
	@FindBy(xpath = "//*[@id='j_id0:uploadFileForm:uploadBtn']")
	WebElement saveProfilePhotoButton;
	@FindBy(xpath = "//*[@id='j_id0:j_id7:save']")
	WebElement saveCroppedProfilePhotoButton;
	
	public UserPage(WebDriver driver) {

		super(driver);

	}

	public String getTitleOfThePage() {
		waitUntilPageLoads();
		return getPageTitle();

	}

	public WebDriver clickEditProfile() {

		clickElement(editProfile, "Edit Profile");

		try
		{
			driver.switchTo().frame("contactInfoContentId");
			log.info("Edit profile popup window is displayed");
		}
		catch(NoSuchFrameException e)
		{
			log.info("Edit profile popup window is not displayed");
			throw e;
		}
		
		return driver;
	}

	public void clickAboutTab()
	{
		//aboutTab.click();
		clickElement(aboutTab, "About tab");
	}
	
	public void clickContactTab()
	{
		//contactTab.click();
		clickElement(contactTab, "Contact tab");
	}
	
	public void enterLastName(String lastName) {
		//clearElement(lastNameElement, "Last Name field");
		enterText(lastNameElement, lastName, "Last Name field");
	}
	
	public void clickSaveAllButton()
	{
		//saveAllButton.click();
		clickElement(saveAllButton, "Save All button");
		driver.navigate().refresh();
	}
	
	public String getUserProfileName()
	{
		return userProfileNameElement.getText();
	}
	
	public void postMessage(String message) {
		clickElement(postLink, "Post link");
		clickElement(postContent, "Post content");
		
		Actions actions = new Actions(driver);
		actions.sendKeys(message).build().perform();
		
		clickElement(shareButton, "Share button");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Posted message: " + message);
	}
	
	public void uploadFile(String filePath) {

		clickElement(fileAttachContent, "File link");
		clickElement(uploadFileLink, "'Upload a file from your computer' link");
		
		chooseChatterFileElement.sendKeys(filePath);
		clickElement(shareButton, "Share button");
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		log.info("Uploaded file: " + filePath);
	}
	
	
	public void uploadProfilePhoto(String filePath) {
		//Hover mouse on add photo
		Actions action = new Actions(driver);
		action.moveToElement(photoSection).perform();

		clickElement(uploadPhotoLink, "Upload photo");
		
		driver.switchTo().frame("uploadPhotoContentId");
		choosePhotoFileElement.sendKeys(filePath);
		clickElement(saveProfilePhotoButton, "Save (profile photo) button");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		clickElement(saveCroppedProfilePhotoButton, "Save (cropped profiled photo) button");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		log.info("Uploaded profile photo: " + filePath);
	}
}
