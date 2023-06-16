package com.cucumberTests.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirebaseStepDef {
	
	WebDriver driver;
	@Given("application is up and running and in loginpage")
	public void application_is_up_and_running_and_in_loginpage() throws InterruptedException {
		
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://qa-tekarch.firebaseapp.com");
	    Thread.sleep(5000);
	}

	@When("i enter username and password")
	public void i_enter_username_and_password() {
	    By userName = By.id("email_field");
	    WebElement userNameElement = driver.findElement(userName);
	    
	    if(userNameElement.isDisplayed()) {
	    	
	    	userNameElement.clear();
	 	    userNameElement.sendKeys("admin123@gmail.com");
	 	    System.out.println("username is entered to the username field");
	    }
	    else {
	    	
	    	System.out.println("username element is not displayed");
	    }
	    
		By password = By.id("password_field");
		WebElement passwordElement = driver.findElement(password);
		String value = passwordElement.getAttribute("type");
		System.out.println("type value == " +value);
		
		if (passwordElement.isDisplayed()) {
			passwordElement.clear();
			passwordElement.sendKeys("admin123");
			System.out.println("password is entered to the password field");
		}
		else {
			System.out.println("username element is not displayed");
		}
		
	}

	@When("click on the login button")
	public void click_on_the_login_button() {
		By button = By.tagName("button");
		WebElement buttonElement = driver.findElement(button);
		
		if(buttonElement.isDisplayed()) {
			buttonElement.click();
			System.out.println("login button is clicked");
		}
		else {
			System.out.println("button element is not displayed");
		}
	}

	@Then("i should get the home page")
	public void i_should_get_the_home_page() {
		
		String expectedTitle = "Selenium";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	    
	}
	

}
