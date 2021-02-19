package test;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FluentWaitDemo {

	public static void main(String[] args) throws InterruptedException {

		test();
	}

	public static void test() throws InterruptedException
	{
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");	
		System.out.println("Opening browser");
		driver.findElement(By.name("q")).sendKeys("Abcd");	
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);	
		
		//Fluent wait. Waiting for 30 seconds for the element 
		//with checking/polling for the element after every 5 seconds
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(30, TimeUnit.SECONDS)
			       .pollingEvery(5, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       WebElement linkElement = driver.findElement(By.linkText("ABCD - NIHM Data Archive - NIH"));
		       if(linkElement.isEnabled())
		       {
		    	   System.out.println("Element found");
		       }
		       return linkElement;
		     }
		});
		
		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}

}
