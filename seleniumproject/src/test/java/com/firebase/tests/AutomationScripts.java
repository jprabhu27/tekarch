//package com.firebase.tests;
//
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//import org.openqa.selenium.WebDriver;
//
//public class AutomationScripts extends BaseTest {
//
//	public static void login_to_firebase_testscript() throws InterruptedException {
//		String expectedTitle = "Selenium";
//		launchBrowser("chrome");
//
//		System.out.println("chrome browser opened");
//		driver.get("https://qa-tekarch.firebaseapp.com/");
//		System.out.println("url entered");
//		String actualTitle = driver.getTitle();
//		if (expectedTitle.equals(actualTitle)) {
//			System.out.println("title matched");
//		} else {
//			System.out.println("title is not matched");
//		}
//		Thread.sleep(4000);
//
//	}
//
//	public static void error_login_firebase_testscript() throws InterruptedException {
//
//		String expectedError = "Error : The password is invalid or the user does not have a password.";
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//
//		System.out.println("chrome browser opened");
//		driver.get("https://qa-tekarch.firebaseapp.com/");
//		System.out.println("url entered");
//
//		Thread.sleep(4000);
//	}
//
//	public static void main(String[] args) throws InterruptedException {
//		// TODO Auto-generated method stub
//		login_to_firebase_testscript();
//		error_login_firebase_testscript();
//		// Test Cases
//
//		launchBrowser("Chrome");
//
//		// Username field
//
//		By userName = By.id("email_field");
//		WebElement userNameElement = driver.findElement(userName);
//		enterText(userNameElement, "admin123@gmail.com", "username");
//
//		// password_field
//		By password = By.id(null);
//		WebElement passwordElement = driver.findElement(password);
//		String value = passwordElement.getAttribute("type");
//		System.out.println("type value==" + value);
//		enterPassword(passwordElement, "admin123", "password");
//
//		// Alert
//		Alert alert = driver.switchTo().alert();
//		String errorMsg = alert.getText();
//		alert.accept();
//
//	}
//
//}
