package test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownHandling_Selenium {


	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();  
        
        driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");   
	}

	@Test
	public void dropDownHandle() throws InterruptedException 
	{
		By industry = By.id("Form_submitForm_Industry");
		By country = By.id("Form_submitForm_Country");	
		
		
		// --- Instead of using above hardcoded values for "type" of select, we are using enum here --
		selectDropdownValue(industry, DropdownEnum.VALUE.toString(), "health");
		selectDropdownValue(country, DropdownEnum.INDEX.toString(), "5");
		selectDropdownValue(industry, DropdownEnum.VISIBLETEXT.toString(), "Education");
		
		// --- Select By Visible Text --
		//doSelectDropdownByVisibleText(industry, "Education");
		//doSelectDropdownByVisibleText(country, "India");	
		
		// --- Select By Index --
		//doSelectDropdownByIndex(industry, 2);
		//doSelectDropdownByIndex(country, 5);	
		
		// --- Select By Value --
		//doSelectDropdownByValue(industry, "health");
		//doSelectDropdownByValue(country, "India");	
		
		// --- A Single Switch case function to handle all above cases --
		//selectDropdownValue(country, "visibleText", "India");
		//selectDropdownValue(country, "index", "5");
		//selectDropdownValue(industry, "value", "Education");


		Thread.sleep(3000);
	}
	
	public void doSelectDropdownByVisibleText(By locator, String text) 
	{
		Select select = new Select(driver.findElement(locator));
		select.selectByVisibleText(text);
	}
	
	public void doSelectDropdownByIndex(By locator, int index) 
	{
		Select select = new Select(driver.findElement(locator));
		select.selectByIndex(index);
	}
	
	public void doSelectDropdownByValue(By locator, String value) 
	{
		Select select = new Select(driver.findElement(locator));
		select.selectByValue(value);
	}
	
	public void selectDropdownValue(By locator, String type, String value) 
	{
		Select select = new Select(driver.findElement(locator));

		switch(type)
		{
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
		case "value":
			select.selectByValue(value);
			break;
		case "visibleText":
			select.selectByVisibleText(value);
			break;
		default:
			System.out.println("Please pass the correct type..");
			break;
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
