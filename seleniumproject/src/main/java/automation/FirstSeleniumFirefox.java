package automation;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;


public class FirstSeleniumFirefox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Setting the path in the variable under System.setProperty
		System.setProperty("webdriver.chrome.driver", "C:\\Jaya\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		//Create an instance of the FirefoxDriver class, which implements the WebDriver interface
		//System.setProperty("webdriver.gecko.driver", "C:\\Jaya\\Selenium\\geckodriver-v0.33.0-win32\\geckodriver.exe");
		
		
		//Create an instance of the ChromeDriver class, which implements the WebDriver interface
				
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		
		//Use the driver to open URL, click elements, filling forms etc
		
		driver.get("https://login.salesforce.com/");
		
		
		//driver.quit();		//Quit the browser to release system resources

	}

}
