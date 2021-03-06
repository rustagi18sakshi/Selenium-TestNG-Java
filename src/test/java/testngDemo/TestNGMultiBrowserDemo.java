package testngDemo;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//testng.xml for this : testng3.xml
public class TestNGMultiBrowserDemo {

	WebDriver driver = null;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeMethod
	@Parameters("browserName")
	public void setUp(String browserName){
		System.out.println("Browser name is : "+browserName);
		System.out.println("Current thread is : "+Thread.currentThread().getId());
		
		// For running on Chrome browser
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
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
			driver = new InternetExplorerDriver();
		}
	}
	
	@Test
	public void test1() throws InterruptedException{
		driver.get("https://www.google.com/");		
		Thread.sleep(4000);
	}
	
	@AfterMethod
	public void tearDownTest() {
		driver.close();
		System.out.println("Test completed successfully");
	}

}
