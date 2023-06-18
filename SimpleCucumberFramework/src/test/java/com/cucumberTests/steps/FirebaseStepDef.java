package com.cucumberTests.steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirebaseStepDef {
	
	WebDriver driver;
	
	@BeforeStep
	public void before_each_step() {
		
		System.out.println("Before each step executed");
	}
	
	@AfterStep
	public void after_each_step(Scenario sc) throws IOException {
		sc.log("After step executed");
		System.out.println("After each step executed");
		//To take screenshot
		if((sc.isFailed())) {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		byte[]fileContent = FileUtils.readFileToByteArray(screenshot);
		sc.attach(fileContent, "image/png", "screenshot");
		}
	
	}
	
	@Before
	public void before_each_scenario() {
		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	}
	
	@After
	public void after_each_scenario() {
		
		driver.close();
	}
	
	@BeforeAll
	public static void Before_Test() {
		System.out.println("Before all the Scenarios gets executed");
	}
	
	@AfterAll
	public static void After_All() {
		
		System.out.println("Ater all the Scenarios gets executed");
	}
	
	@Given("application is up and running and in loginpage")
	public void application_is_up_and_running_and_in_loginpage() throws InterruptedException {
		
    
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
