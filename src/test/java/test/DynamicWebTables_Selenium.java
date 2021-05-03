package test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/*
Link for reference : https://www.youtube.com/watch?v=Ue2DmBICOkE
*/
public class DynamicWebTables_Selenium {

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
	        
	        // Login
			driver.findElement(By.name("username")).sendKeys("groupautomation");
			driver.findElement(By.name("password")).sendKeys("Test@12345");
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			
			// Switch to frame
			driver.switchTo().frame("mainpanel");
			Thread.sleep(2000);
			
			// Click on Contacts link
			driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();	
			
		}
		
		@Test
		public void handlingDynamicContactsTableThroughLoop() throws InterruptedException
		{
	        WebElement baseTable = driver.findElement(By.xpath("//form[@id='vContactsForm']/table[@class='datacard']")); 
	        
	        // To find number of total row of table
			List<WebElement> totalNumOfRows = baseTable.findElements(By.xpath(".//tbody/tr"));
			System.out.println("Total number of rows are : "+totalNumOfRows.size());
			
			for(int i=4; i<totalNumOfRows.size()-1; i++)
			{
				String text = baseTable.findElement(By.xpath(".//tbody/tr["+i+"]/td[2]/a")).getText();
				System.out.println(text);
				
				// Checking the checkbox if text contains the below mentioned value
				if(text.contains("chaitanya ram"))
				{
					baseTable.findElement(By.xpath(".//tbody/tr["+i+"]/td[1]/input")).click();
					Thread.sleep(3000);
				}
			}
		}
		
		@Test
		public void handlingDynamicContactsTableThroughCustomisedXpath() throws InterruptedException
		{
			// To check the checkbox which contains text : chaitanya ram
			driver.findElement(By.xpath("//a[contains(text(),'chaitanya ram')]/parent::td/preceding-sibling::td/input")).click();
			Thread.sleep(3000);
		}
	
		@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}
}