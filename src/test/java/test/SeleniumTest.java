package test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 A very simple Selenium program to search for text on Google and click enter.
 */

public class SeleniumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Getting path of current project
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is :"+projectPath);
		
		//Setting system property
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		
		//Initializing WebDriver
		WebDriver driver = new ChromeDriver();
		
		//Go to google.com
		driver.get("https://www.google.com");
		
		//Input text in search box
		WebElement textBox = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
		textBox.sendKeys("Hello World");
		
		//Usage of findElements
		List<WebElement> listOfInputElements = driver.findElements(By.xpath("//input"));
		System.out.println("Size of list : "+listOfInputElements.size());
		
		//Click on Search button 
		//driver.findElement(By.name("btnK")).click();
		
		//This one doesn't work so we will use another approach to click ENTER button through keyboard
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys(Keys.RETURN);
		
		//Close Browser
		driver.close();
		
		System.out.println("Test completed successfully");
	}

}
