package test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
/*
Desired Capabilites in Selenium : It is a class in Selenium library : org.openqa.selenium.remote.DesiredCapabilities
It describes the series of key/value pairs. Used to set properties for browser like : BrowserName, Platform, Version etc.
Link to refer for setting key/value : 
https://github.com/SeleniumHQ/selenium/wiki/DesiredCapabilities
*/

public class DesiredCapabilitiesDemo {
	
	public static void main(String[] args) {
		
		//Setting properties for IE driver
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is : "+projectPath);
		System.setProperty("webdriver.ie.driver", projectPath+"/drivers/iedriver/IEDriverServer.exe");
		
		//Creating the desired capability object and setting capabilities
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("ignoreProtectedModeSettings", true);
		cap.setCapability("ignoreZoomSetting", true);
		
		//This desired capability object has to be passed as a variable to WebDriver
		WebDriver driver = new InternetExplorerDriver(cap);
		
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("ABCD");	
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		driver.close();
		driver.quit();

	}

}
