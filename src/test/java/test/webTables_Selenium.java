package test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
Link for reference : https://www.guru99.com/handling-dynamic-selenium-webdriver.html
*/
public class webTables_Selenium {

	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();  
        
        driver.get("http://demo.guru99.com/test/web-table-element.php");	
	}

	// This is used to fetch total number of rows and columns in a table
	@Test(priority=0)
    public void fetchNumberOfRowsAndColumns() 
	{
        WebElement baseTable = driver.findElement(By.tagName("table"));
        
        // Total number of rows 
        List<WebElement> rows = baseTable.findElements(By.xpath(".//tbody/tr")); 
        System.out.println("No of rows are : " + rows.size());
        
        // Total number of columns
        List<WebElement> cols = baseTable.findElements(By.xpath(".//thead/tr/th"));
        System.out.println("No of cols are : " +cols.size());
    }

	// This is used to fetch data at 3rd row and 2nd column
	@Test(priority=1)
    public void fetchDataAt3Row2Column() 
	{
        WebElement baseTable = driver.findElement(By.tagName("table")); 
        
        // To find third row of table
		WebElement tableRow = baseTable.findElement(By.xpath(".//tbody/tr[3]"));
        String rowtext = tableRow.getText();
		System.out.println("Third row of table : "+rowtext);
		    
		// To get 3rd row's 2nd column data
		WebElement cellIneed = tableRow.findElement(By.xpath(".//td[2]"));
		String valueIneed = cellIneed.getText();
		System.out.println("Cell value is : " + valueIneed); 
    }
	

	// This method is used to fetch the maximum of all the values in a column(here column is : Current Price (Rs)) of Dynamic Table
	@Test(priority=2)
	public void maxValueInAColumn() 
	{
        WebElement baseTable = driver.findElement(By.tagName("table"));
        
        // Total number of rows 
        List<WebElement> rows = baseTable.findElements(By.xpath(".//tbody/tr")); 
        System.out.println("No of rows are : " + rows.size());
        
        double maximum = 0;
        
        for(int i=1; i<=rows.size(); i++)
        {    
        	// Fetch 'Current Price' value from all rows and 4th column in the table
            String max = baseTable.findElement(By.xpath(".//tbody/tr["+i+"]/td[4]")).getText();
            double value = Double.parseDouble(max);
            
            if(value > maximum)
            {    
                maximum = value;
            }
        }
        System.out.println("Maximum value of current price is : "+maximum);
    }
	
	// This method is used to display all the data of the dynamic table
	@Test(priority=3)
    public void displayAllValuesOfDynamicTable()
    {
        WebElement baseTable = driver.findElement(By.tagName("table")); 
        
        // Total number of rows 
        List<WebElement> rows = baseTable.findElements(By.xpath(".//tbody/tr")); 
        System.out.println("No of rows are : " + rows.size());
        
        // Total number of columns
        List<WebElement> cols = baseTable.findElements(By.xpath("//thead/tr/th"));
        System.out.println("No of cols are : " +cols.size());
        
       	for (int i=1; i<=rows.size(); i++)
       	{
    	    for (int j=1; j<=cols.size(); j++) 
    	    {
    	        // To retrieve text from that specific cell.
    	        String celltext = baseTable.findElement(By.xpath(".//tbody/tr["+i+"]/td["+j+"]")).getText();
    	        System.out.println("Cell Value of row number " + i + " and column number " + j + " is " + celltext);
    	    }
    	    System.out.println();
       	}
    }
    
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
