package test;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
Website used : https://www.toolsqa.com/selenium-webdriver/keyboard-events-in-selenium/
*/
public class KeyboardEvents_ActionsClass_Selenium {		


	// This method copy the content of text box 'Current Address' and paste it in text box 'Permanent Address'
    @Test		
    public void CopyPasteUsingActions ()					
    {		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
						
        driver.get("https://demoqa.com/text-box");					  
        driver.manage().window().maximize();
        
        // Initializing Action class object	
        Actions actions = new Actions(driver);
        
        // Enter the Full Name
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Mr.Peter Haynes");
        
        //Enter the Email
        WebElement email=driver.findElement(By.id("userEmail"));
        email.sendKeys("PeterHaynes@toolsqa.com");
        
        // Enter the Current Address
        WebElement currentAddress=driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("43 School Lane London EC71 9GO");
            
        // Select the Current Address i.e CTRL+A
        actions.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).build().perform();
        
        // Copy the Current Address
        actions.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).build().perform();
        
        // Press the TAB Key to Switch Focus to Permanent Address
        actions.sendKeys(Keys.TAB).build().perform();
        
        // Paste the Current Address in the Permanent Address field
        actions.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).build().perform();  
        
        // Compare Text of current Address and Permanent Address
        WebElement permanentAddress=driver.findElement(By.id("permanentAddress"));
        Assert.assertEquals(currentAddress.getAttribute("value"),permanentAddress.getAttribute("value"));
        
        driver.close();
	}
}