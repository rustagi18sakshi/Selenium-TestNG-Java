package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.GoogleSearchPage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemoWithTestNG {

	WebDriver driver = null;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	
	@BeforeSuite
	public void setUp()
	{
        htmlReporter = new ExtentHtmlReporter("extent1.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
	}
	
	@BeforeTest
	public void testSetUp()
	{
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void testOne() {
		   
        ExtentTest test1 = extent.createTest("Google Search Test One", "This is a test to validate google search functionality");
		
        test1.log(Status.INFO, "Starting test case");
		driver.get("https://www.google.com/");
		test1.pass("Navigated to the google website");
		
		GoogleSearchPage.textbox_search(driver).sendKeys("Step by step automation");
		test1.pass("Entered text in search box");
		
		GoogleSearchPage.textbox_search(driver).sendKeys(Keys.RETURN);
		test1.pass("Pressed keyboard enter key");
	}
	
	@Test
	public void testTwo() {
		   
        ExtentTest test2 = extent.createTest("Google Search Test Two", "This is a test to validate google search functionality");

        test2.log(Status.INFO, "Starting test case");
		driver.get("https://www.google.com/");
		test2.pass("Navigated to the google website");
		
		GoogleSearchPage.textbox_search(driver).sendKeys("Step by step automation");
		test2.pass("Entered text in search box");
		
		GoogleSearchPage.textbox_search(driver).sendKeys(Keys.RETURN);
		test2.pass("Pressed keyboard enter key");
	}
	
	@AfterTest
	public void testTearDown()
	{
		driver.close();	
		driver.quit();
		System.out.println("Test completed successfully");
	}

	@AfterSuite
	public void tearDown() {
		
		extent.flush();
	}
}
