package test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwitchingWindowsOrTabs {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();  
        
        driver.get("https://www.airbnb.co.in/");	
	}
	
    @Test		
    public void OpenTabAndSwitchingToSingleTab() throws AWTException, InterruptedException					
    {		
        // Storing the address of the parent window
        String parentWindow = driver.getWindowHandle();
        
        // Robot class for entering CTRL+T to open a new tab/window
		Robot r = new Robot();        
		        r.keyPress(KeyEvent.VK_CONTROL);
		        r.keyPress(KeyEvent.VK_T);
		        r.keyRelease(KeyEvent.VK_CONTROL);
		        r.keyRelease(KeyEvent.VK_T);
		 
        // Other way of typing CTRL+t
        //driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+ "t");
             
		Thread.sleep(5000);
        driver.switchTo().window(parentWindow);
        
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("Total number of windows/tabs are : "+windowHandles.size());

        // Iterating through the windows
        for(String winHandle : windowHandles)
        {
        	if(!winHandle.equalsIgnoreCase(parentWindow))
        	{
        		driver.switchTo().window(winHandle);
        		
        		driver.get("https://www.google.com");
        		System.out.println("Title of the new tab is : "+driver.getTitle());
        		driver.close();
        	}      
        }

        // Switching back to the parent window
        driver.switchTo().window(parentWindow);
        System.out.println("Title of the parent window is : "+driver.getTitle());
    }
    
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
