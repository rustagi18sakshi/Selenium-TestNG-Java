package extentReport;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemo {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args)  {
		
		// start reporters
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
    
        // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // creates a toggle for the given test, adds all log events under it    
        ExtentTest test1 = extent.createTest("Google Search Test One", "This is a test to validate google search functionality");

        // writing our test
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		// logging info
        test1.log(Status.INFO, "Starting test case");
		driver.get("https://www.google.com/");
		test1.pass("Navigated to the google website");
		
		driver.findElement(By.name("q")).sendKeys("Step by step automation");
		test1.pass("Entered text in search box");
		
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		test1.pass("Pressed keyboard enter key");
		
		driver.close();
		test1.pass("Closed the browser");	
		driver.quit();
        test1.log(Status.INFO, "Test Completed");
		      
        // calling flush writes everything to the log file
        extent.flush();
	}

}
