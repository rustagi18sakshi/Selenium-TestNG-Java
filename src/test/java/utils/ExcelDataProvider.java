package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.PropertiesFile_demo;

/*
Selenium TestNG How to get data from Excel using DataProvider.
DataProvider feature is one of the important features provided by TestNG. 
It is the second way of passing parameters to test methods. 
It allows the users to write data-driven tests in which we can run multiple times the same test method with different sets of test data. 
The sets of test data can be any format
*/

public class ExcelDataProvider {

	WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest()
	{
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is :"+projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	//Using the dataProvider set in the below keyword to make our test data driven
	@Test(dataProvider="testdata")
	public void test1(String username, String password) throws InterruptedException
	{
		System.out.println(username+"  |  "+password);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		Thread.sleep(2000);
	}

	//Setting the value for the dataProvider
	@DataProvider(name="testdata")
	public Object[][] getData()
	{	
		String projectPath = System.getProperty("user.dir");
		Object[][] data= testData(projectPath+"/excel/data.xlsx", "Sheet1");
		return data;
	}
		
	//Getting the value for the dataProvider from the excel sheet having multiple userName and password
	public  Object[][] testData(String excelPath, String sheetName)
	{	
		ExcelUtils excel = new ExcelUtils(excelPath,sheetName);
		
		int rowCount = excel.getRowCount();
		int colCount = excel.getColumnCount();
		
		//Creating an array object. (rowCount-1) because we do not want header
		Object arr[][] = new Object[rowCount-1][colCount];
		
		//We are using i=1 since we want to skip header row. In case of column we will start from 0.
		for(int i=1;i<rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				String cellData = excel.getCellDataString(i,j);
				arr[i-1][j]= cellData;
			}
		}
		return arr;
	}
}
