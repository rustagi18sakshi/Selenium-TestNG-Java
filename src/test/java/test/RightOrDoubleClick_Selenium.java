package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/*
Website used : https://www.toolsqa.com/selenium-webdriver/right-click-and-double-click-in-selenium/
*/
public class RightOrDoubleClick_Selenium {		

    // Script to right-click the button using Actions class contextClick() method
    //@Test
    public void RightClick()					
    {		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
						
        driver.get("https://demoqa.com/buttons");					 
        driver.manage().window().maximize();
        
		// Element which needs to be right clicked    		
        WebElement btnElement =driver.findElement(By.id("rightClickBtn"));						
         		
        // Using Action class
        Actions actions = new Actions(driver);					

        // Right click the button	
        actions.contextClick(btnElement).build().perform();
        
        String message = driver.findElement(By.id("rightClickMessage")).getText();   // Getting post click text  
         
        if(message.equals("You have done a right click"))     
        {
        	System.out.println("PASS: Right click is performed");
        }
        else 
        {
        	System.out.println("FAIL: Right click is not performed");
        }  
        
        driver.close();
	}	
    
    // Script to double click the button using Actions class doubleClick() method
    @Test
    public void DoubleClick()					
    {		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
						
        driver.get("https://demoqa.com/buttons");					 
        driver.manage().window().maximize();
        
		// Element which needs to be double clicked    		
        WebElement btnElement =driver.findElement(By.id("doubleClickBtn"));						
         		
        // Using Action class
        Actions actions = new Actions(driver);					

        // Double click the button	
        actions.doubleClick(btnElement).build().perform();
        
        String message = driver.findElement(By.id("doubleClickMessage")).getText();   // Getting post click text  
         
        if(message.equals("You have done a double click"))     
        {
        	System.out.println("PASS: Double click is performed");
        }
        else 
        {
        	System.out.println("FAIL: Double click is not performed");
        }  
        
        driver.close();
	}
}