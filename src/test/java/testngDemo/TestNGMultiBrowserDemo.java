package testngDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//testng.xml for this : testng3.xml
public class TestNGMultiBrowserDemo {

	WebDriver driver = null;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeTest
	@Parameters("browserName")
	public void setUp(String browserName){
		System.out.println("Browser name is : "+browserName);
		System.out.println("Current thread is : "+Thread.currentThread().getId());
		
		// For running on Chrome browser
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		// For running on Firefox browser
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", projectPath+"/drivers/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		// For running on Internet Explorer browser
		else if(browserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", projectPath+"/drivers/iedriver/IEDriverServer.exe");
			driver = new FirefoxDriver();
		}
	}
	
	@Test
	public void test1() throws InterruptedException{
		driver.get("https://www.google.com/");		
		Thread.sleep(4000);
	}
	
	@AfterTest
	public void tearDownTest() {
		driver.close();
		System.out.println("Test completed successfully");
	}

}
