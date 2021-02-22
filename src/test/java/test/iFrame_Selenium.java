package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/*
For reference : https://www.guru99.com/handling-iframes-selenium.html
*/
public class iFrame_Selenium {

    WebDriver driver;			

    // How to switch over the frame using ID/Name/Web Element
    @Test(enabled=false)		
    public void SwitchToFrame_ID()					
    {		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
						
		driver.get("http://demo.guru99.com/test/guru99home/"); 				
        driver.manage().window().maximize();
        
        driver.switchTo().frame("a077aa5e"); //switching the frame by ID  
        
		System.out.println("********We are switch to the iframe*******");
 		driver.findElement(By.xpath("html/body/a/img")).click();
 		
 		driver.switchTo().defaultContent(); // To come out of iframe or to Switch back to main frame
 		
        driver.close();
	}	
	
    // How to switch over the frame, if we CANNOT switch using ID/Name/Web Element
    @Test		
    public void SwitchToFrame_WithoutId()					
    {		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
						
		driver.get("http://demo.guru99.com/test/guru99home/"); 				
        driver.manage().window().maximize();
        
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Total number of frames are : "+size);
        
        for(int i=0;i<size-1;i++)
        {
        	driver.switchTo().frame(i);    // Switching to the desired iframe using index
        	int total= driver.findElements(By.xpath("html/body/a/img")).size();
        	System.out.println("Total element with the above mentioned xpath in frame"+i+" are "+total);
        	driver.switchTo().defaultContent();  // Switching to the default frame
        }
        	
        driver.close();
	}	
    
    // Concept of Nested Frames(Frames inside Frames)
    @Test(enabled=false)		
    public void nestedFrame()					
    {	
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
						
		driver.get("URL"); 				
        driver.manage().window().maximize();
        
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Total number of frames are : "+size);      // Prints the total number of frames 
       
		driver.switchTo().frame(0);     // Switching to the Outer Frame    	
	    System.out.println (driver.findElement(By.xpath("xpath of the outer element ")).getText());   // Printing the text in outer frame
		
		size = driver.findElements(By.tagName("iframe")).size();                                                                                                  
	    System.out.println("Total Frames inside the outer frame are : " + size);   // Prints the total number of frames inside outer frame 
	    
	    driver.switchTo().frame(0); 	// Switching to inner frame
	    System.out.println(driver.findElement(By.xpath("xpath of the inner element ")).getText());    //Printing the text in inner frame

		driver.switchTo().defaultContent();  // To move back to the parent frame
	    driver.close();
    }	

}
