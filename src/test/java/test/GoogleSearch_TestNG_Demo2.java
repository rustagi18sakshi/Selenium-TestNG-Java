package test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleSearch_TestNG_Demo2 {

	WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest()
	{
		String projectPath = System.getProperty("user.dir");
		// For running on Chrome browser
		System.out.println("Project path is :"+projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void googleSearch2() throws InterruptedException {
		
		driver.get("https://www.google.com/");	
		//enter text in google search textbox
		System.out.println("Opening browser");
		driver.findElement(By.name("q")).sendKeys("Step by step automation");	
		//click on enter button to complete search
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);	
		Thread.sleep(3000);
	}
	
	@Test
	public void googleSearch3() throws InterruptedException {
		
		driver.get("https://www.google.com/");	
		//enter text in google search textbox
		System.out.println("Opening browser");
		driver.findElement(By.name("q")).sendKeys("Step by step automation");	
		//click on enter button to complete search
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);	
		Thread.sleep(3000);
	}

	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test completed successfully");
	}
	
}

