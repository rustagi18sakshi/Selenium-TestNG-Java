package test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
Headless Chrome is a non-GUI version of the Chrome browser.
*/
public class HeadlessChromeDemo {

	public static void main(String[] args) {
		
		headlessTest();
	}
	
	public static void headlessTest()
	{
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		
		//Setting for headless chrome browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1280,800");
		//We have to pass the option set to driver
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.google.com/");	
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Step by step automation");	
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);	
		
		driver.close();
		driver.quit();
		System.out.println("Completed");	
	}
}
