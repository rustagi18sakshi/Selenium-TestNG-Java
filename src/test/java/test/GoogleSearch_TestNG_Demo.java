package test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile_demo;

/*
A very simple Selenium program using TestNG framework.
To create TestNG.xml file : 
Select the class -> Right Click -> TestNG -> Convert to TestNG 
*/

public class GoogleSearch_TestNG_Demo {

	WebDriver driver = null;
	//Making use of property set in config.properties file
	public static String browserName = null;
	
	@BeforeTest
	public void setUpTest()
	{
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is :"+projectPath);
		
		//To get the value of browserName through Properties file
		PropertiesFile_demo.getProperties();
		
		// For running on Chrome browser
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		// For running on Firefox browser
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", projectPath+"/drivers/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}
	
	@Test
	public void googleSearch() throws InterruptedException {
		
		driver.get("https://www.google.com/");	
		//enter text in google search textbox
		System.out.println("Opening browser");
		driver.findElement(By.name("q")).sendKeys("Step by step automation");	
		//click on enter button to complete search
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);	
		Thread.sleep(3000);
	}

	@AfterTest
	public void tearDownTest() {
		driver.close();
		//driver.quit();
		PropertiesFile_demo.setProperties();
		System.out.println("Test completed successfully");
	}
	
}

