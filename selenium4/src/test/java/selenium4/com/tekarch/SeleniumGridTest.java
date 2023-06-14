package selenium4.com.tekarch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGridTest {
	
	@Test
	public void simpleTest() throws InterruptedException, MalformedURLException {
		
		String nodeUrl = "http://localhost:4444/wd/hub";
		URL url= new URL(nodeUrl);
		
		ChromeOptions options = new ChromeOptions();	//Chrome Browser
		options.setCapability("platformName", "windows");
		WebDriver driver = new RemoteWebDriver(url, options);
		
		driver.get("https://www.google.com/");
		Thread.sleep(4000);
		
		By ob1 = By.name("q");
		WebElement searchBox = driver.findElement(ob1);
		searchBox.sendKeys("selenium");
		driver.close();
		
	}
	
	

}
