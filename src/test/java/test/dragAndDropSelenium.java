package test;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/*
Website used : http://demo.guru99.com/test/drag_drop.html
*/
public class dragAndDropSelenium {		

    //@Test		
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
    //@Test		
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
    
    @Test		
    public void DragAndDropByPixelGeneric() throws InterruptedException					
    {		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
						
        driver.get("https://demoqa.com/droppable/");					
         
        driver.manage().window().maximize();

        WebElement from = driver.findElement(By.id("draggable"));      
        WebElement to = driver.findElement(By.id("droppable")); 
        
        //First, get x and y offset for from object
        int xOffset1 = from.getLocation().getX();
        int yOffset1 = from.getLocation().getY();
        
        System.out.println("xOffset1--->"+xOffset1+" yOffset1--->"+yOffset1);
        
        //Secondly, get x and y offset for to object
        int xOffset2 = to.getLocation().getX();
        int yOffset2 = to.getLocation().getY();
        
        System.out.println("xOffset2--->"+xOffset2+" yOffset2--->"+yOffset2);
        
        //Find the xOffset and yOffset difference to find x and y offset needed in which from object required to dragged and dropped
        int xOffset =(xOffset2-xOffset1);
        int yOffset=(yOffset2-yOffset1);
        
        Actions actions=new Actions(driver);					
      
        //Drag and Drop by Pixel.		
        actions.dragAndDropBy(from,xOffset,yOffset).perform();
        
        //Verify text changed in to 'Drop here' box 
        //Get text value of 'to' element
        String textTo = to.getText(); 
        
        if(textTo.equals("Dropped!"))
        {
        System.out.println("PASS: Source is dropped at location as expected");
        }
        else 
        {
        System.out.println("FAIL: Source couldn't be dropped at location as expected");
        }
        
        driver.close();
    }
    
}
