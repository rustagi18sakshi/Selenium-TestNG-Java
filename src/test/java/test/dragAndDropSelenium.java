package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/*
 Website used : http://demo.guru99.com/test/drag_drop.html
 */
public class dragAndDropSelenium {

    WebDriver driver;			

    @Test		
    public void DragAndDrop()					
    {		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
						
        driver.get("http://demo.guru99.com/test/drag_drop.html");					
         
        driver.manage().window().maximize();
        
		//Element which needs to drag.    		
        WebElement From=driver.findElement(By.xpath("//*[@id='credit2']/a"));	
         
        //Element on which need to drop.		
        WebElement To=driver.findElement(By.xpath("//*[@id='bank']/li"));					
         		
        //Using Action class for drag and drop.		
        Actions actions = new Actions(driver);					

        //Dragged and dropped.		
        actions.dragAndDrop(From, To).build().perform();    
        driver.close();
	}	
    
    // The pixels values change with screen resolution and browser size. This method is hence not reliable and not widely used.
    @Test		
    public void DragAndDropByPixel() throws InterruptedException					
    {		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
						
        driver.get("http://demo.guru99.com/test/drag_drop.html");					
         
        driver.manage().window().maximize();
        
        //Element(BANK) which need to drag.		
        WebElement From=driver.findElement(By.xpath("//*[@id='credit2']/a"));					
      
        //Using Action class for drag and drop.		
        Actions actions=new Actions(driver);					
      
        //Drag and Drop by Pixel.		
        actions.dragAndDropBy(From,135, 40).build().perform();
        
        Thread.sleep(3000);
        driver.close();
    }
    
}
