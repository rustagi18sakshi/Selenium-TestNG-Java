package test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StaleElementExceptionConcept {

		public WebDriver driver; 
		
		@BeforeMethod
		public void setUp() throws InterruptedException
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	        driver.manage().window().maximize();  
	        
			driver.get("https://classic.crmpro.com");
		}
		
		@Test
		public void instantiateDriver() 
		{
			// Storing the reference ID for the username.
			WebElement username = driver.findElement(By.name("username"));
			username.sendKeys("groupautomation");   // This will work
			
			// Refreshing the page
			driver.navigate().refresh();
			
			// This will throw 'Stale Element Reference Exception'.
			// Since reference ID for WebElement username has been updated due to page refresh.
			username.sendKeys("groupautomation");
		
			WebElement password = driver.findElement(By.name("password"));
			password.sendKeys("Test@12345");		
			
		}
			
		@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}
}

