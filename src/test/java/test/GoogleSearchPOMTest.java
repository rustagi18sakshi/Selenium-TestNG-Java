package test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObject.GoogleSearchPage;

public class GoogleSearchPOMTest {

	private static WebDriver driver = null;
	
	public static void main(String[] args) {

		googleSearch();
	}
	
	public static void googleSearch() {
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is :"+projectPath);
		
		// For running on Chrome browser
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		GoogleSearchPage.textbox_search(driver).sendKeys("Step by step automation");
		
		GoogleSearchPage.textbox_search(driver).sendKeys(Keys.RETURN);
		
		driver.close();
		
		System.out.println("Test completed successfully");
	}

}
