package test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SwitchingWindowsOrTabs {
	
    @Test		
    public void OpenTabAndSwitchingToSingleTab() throws AWTException, InterruptedException					
    {		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
						
        driver.get("https://www.airbnb.co.in/");					
         
        driver.manage().window().maximize();
        
        // Storing the address of the parent window
        String parentWindow = driver.getWindowHandle();
        
        // Robot class for entering CTRL+T to open a new tab
		Robot r = new Robot();        
		        r.keyPress(KeyEvent.VK_CONTROL);
		        r.keyPress(KeyEvent.VK_T);
		        r.keyRelease(KeyEvent.VK_CONTROL);
		        r.keyRelease(KeyEvent.VK_T);
		 
        // Other way of typing CTRL+t
        //driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+ "t");
        
		Thread.sleep(5000);
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("Total number of windows/tabs are : "+windowHandles.size());

        // Iterating through the windows
        for(String winHandle : windowHandles){
        	if(!winHandle.equalsIgnoreCase(parentWindow))
        	{
        		driver.switchTo().window(winHandle);
        		driver.get("https://www.google.com");
        		System.out.println("Title of the new tab is : "+driver.switchTo().window(winHandle).getTitle());
        		driver.close();
        	}      
        }

        // Switching back to the parent window
        driver.switchTo().window(parentWindow);
        System.out.println("Title of the parent window is : "+driver.switchTo().window(parentWindow).getTitle());
        
        driver.close();
	}	

}
