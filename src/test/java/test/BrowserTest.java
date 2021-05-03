package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserTest {

	public static void main(String[] args) throws InterruptedException {

		// Getting path of current project
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is :"+projectPath);
		
		// For running on Firefox browser
		System.setProperty("webdriver.gecko.driver", projectPath+"/drivers/geckodriver/geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.selenium.dev/");
		
		// For running on Chrome browser
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		
		WebDriver driver1 = new ChromeDriver();
		driver1.get("https://www.selenium.dev/");
		
		// For running on Internet Explorer browser
		System.setProperty("webdriver.ie.driver", projectPath+"/drivers/iedriver/IEDriverServer.exe");
		
		WebDriver driver2 = new InternetExplorerDriver();
		driver2.manage().window().maximize();
		driver2.get("https://www.selenium.dev/");
		Thread.sleep(3000);
	}

}
