package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaitDemo {

	public static void main(String[] args) {
		
		seleniumWaits();
	}
	
	public static void seleniumWaits()
	{
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Applying Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");	
		//enter text in google search textbox
		System.out.println("Opening browser");
		driver.findElement(By.name("q")).sendKeys("Step by step automation");	
		//click on enter button to complete search
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);	
		
		//Applying explicit wait for an element for 20sec
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("abcdef")));
		
		
		driver.findElement(By.name("abcd"));
		
		driver.close();
		driver.quit();
	}

}
