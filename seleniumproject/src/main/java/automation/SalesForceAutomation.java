package automation;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;


public class SalesForceAutomation {

	public static void main(String[] args) throws InterruptedException {
		// Automating salesforce
		
		
		
		//setting up the driver
		WebDriverManager.chromedriver().setup();	//2
		
		//WebDriverManager.firefoxdriver().setup();	// for fire fox set up
		
		//create an object for the interface web driver
		WebDriver driver = new ChromeDriver();		//3 object of the class that is implementing the interface WebDriver
		
		//WebDriver driver = new FirefoxDriver();  //for fire fox
		
		driver.manage().window().maximize();		//4
		driver.get("https://login.salesforce.com/");
		
		Thread.sleep(4000);
		
		By userName = By.id("username");
		WebElement userNameElement = driver.findElement(userName);
		userNameElement.clear();
		userNameElement.sendKeys("admin123@gmail.com");
		
		By password = By.id("password");
		WebElement passwordElement = driver.findElement(password);
		passwordElement.clear();
		passwordElement.sendKeys("admin123");
		
		By button = By.tagName("Login");
		WebElement buttonElement = driver.findElement(button);
		buttonElement.click();
	
//		By button1 = By.className("fa fa-cret-down");
//		WebElement button1Element = driver.findElement(button1);
//		Select dropdown = new Select(button1Element);
//		dropdown.selectByVisibleText("Table");
		
//		
//		
		
		
		

		
		//Pausing the execution
		driver.close();
		
		
		
		
		
		
		
		

	}

}
