package test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalendarHandling_Selenium {

	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();  
        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
        
		driver.findElement(By.id("datepicker")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-datepicker-calendar")));
	}
	
	@Test
	public void pickFutureDate()
	{
		selectFutureDate("23", "July", "2022");
	}
	
	@Test
	public void pickPastDate()
	{
		selectPastDate("23", "July", "2020");
	}
	
	public String[] getMonthYear(String monthYearVal)
	{
		return monthYearVal.split(" ");
	}
	
	public void selectFutureDate(String expDate, String expMonth, String expYear)
	{
		if(expMonth.equals("February") && Integer.parseInt(expDate) > 29)
		{
			System.out.println("Wrong date : "+expMonth+" : "+expDate);
			return;
		}
		
		if(Integer.parseInt(expDate) > 31)
		{
			System.out.println("Wrong date : "+expMonth+" : "+expDate);
			return;
		}
		
		// Fetching month and year currently visible
		String monthYearVal = driver.findElement(By.className("ui-datepicker-title")).getText();
		System.out.println(monthYearVal);
		
		while(!(getMonthYear(monthYearVal)[0].equals(expMonth) && getMonthYear(monthYearVal)[1].equals(expYear)))
		{
			// Clicking on the next button
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			
			// Capturing again the value of month and year after clicking on Next button.
			monthYearVal = driver.findElement(By.className("ui-datepicker-title")).getText();
			
		}
		
		// Once it appears at expected month and date, then click on the expected date
		driver.findElement(By.xpath("//a[text()='"+expDate+"']")).click();	
	}
	
	public void selectPastDate(String expDate, String expMonth, String expYear)
	{
		if(expMonth.equals("February") && Integer.parseInt(expDate) > 29)
		{
			System.out.println("Wrong date : "+expMonth+" : "+expDate);
			return;
		}
		
		if(Integer.parseInt(expDate) > 31)
		{
			System.out.println("Wrong date : "+expMonth+" : "+expDate);
			return;
		}
		
		// Fetching month and year currently visible
		String monthYearVal = driver.findElement(By.className("ui-datepicker-title")).getText();
		System.out.println(monthYearVal);
		
		while(!(getMonthYear(monthYearVal)[0].equals(expMonth) && getMonthYear(monthYearVal)[1].equals(expYear)))
		{
			// Clicking on the Previous button
			driver.findElement(By.xpath("//a[@title='Prev']")).click();
			
			// Capturing again the value of month and year after clicking on Previous button.
			monthYearVal = driver.findElement(By.className("ui-datepicker-title")).getText();
			
		}
		
		// Once it appears at expected month and date, then click on the expected date
		driver.findElement(By.xpath("//a[text()='"+expDate+"']")).click();	
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
