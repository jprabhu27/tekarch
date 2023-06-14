package com.firebase.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {
	
	static WebDriver driver;
	static Actions action;

	public static void main(String[] args) throws InterruptedException {
		// Drag and Drop
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/drag_and_drop");
		driver.manage().window().maximize();
		action = new Actions(driver);
		
		WebElement from = driver.findElement(By.xpath("//*[@id=\"column-a\"]"));
		WebElement to = driver.findElement(By.xpath("//*[@id=\"column-b\"]"));
		
		//Thread.sleep(2000);
		
		action.clickAndHold(from).moveToElement(to).release().build().perform();
		action.dragAndDrop(from, to).perform();
	}

}
