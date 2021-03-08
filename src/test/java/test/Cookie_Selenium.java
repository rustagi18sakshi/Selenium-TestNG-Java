package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Cookie_Selenium {

    WebDriver driver;			

    //@Test		
    public void cookieRead() throws IOException					
    {		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
						
		driver.get("https://www.facebook.com"); 				
        driver.manage().window().maximize();
        
        //Enter Email id and Password if you are already Registered user 
        driver.findElement(By.name("email")).sendKeys("rustagi_sakshi@yahoo.in"); 
        driver.findElement(By.name("pass")).sendKeys("intelligentbaby.."); 
        driver.findElement(By.name("login")).click();
        
        // Create a file to store Login Information 
        File file = new File(projectPath+"/src/test/java/test/Cookiefile.data"); 

        file.delete();          // Delete old file if already exists
        file.createNewFile();   // Create a new file
        
        FileWriter fileWrite = new FileWriter(file);
        BufferedWriter Bwritecookie = new BufferedWriter(fileWrite);
        for(Cookie c : driver.manage().getCookies())  // Getting all the cookies
        {
        	Bwritecookie.write((c.getName()+";"+c.getValue()+";"+c.getDomain()+";"+c.getPath()+";"+c.getExpiry()+";"+c.isSecure())); 
        	Bwritecookie.newLine(); 
        } 
        Bwritecookie.close(); 
        fileWrite.close();
        
        driver.close();
	}	
    
    // To clear browser cache using Selenium. Clearing browser cache before starting your test is important. 
    @Test		
    public void clearBrowserCache() throws InterruptedException					
    {		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
						
		driver.manage().deleteAllCookies();
		Thread.sleep(7000);      //wait 7 seconds to clear cookies.
        
        driver.close();
	}	
}


