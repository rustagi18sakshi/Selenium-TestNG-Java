package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/*
Link for reference : https://www.guru99.com/handling-dynamic-selenium-webdriver.html
*/
public class webTables_Selenium {

	WebDriver driver = null;
	
	@Test(enabled=false)
	// This is used to fetch total number of rows and columns in a table
    public void fetchNumberOfRowsAndColumns() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
						
        driver.get("http://demo.guru99.com/test/web-table-element.php");					  
        driver.manage().window().maximize();  
        
        // Total number of rows 
        List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]")); 
        System.out.println("No of rows are : " + rows.size());
        
        // Total number of columns
        List<WebElement> cols = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th"));
        System.out.println("No of cols are : " +cols.size());
          
        driver.close();
    }
	
	@Test(enabled=false)
	// This is used to fetch data at 3rd row and 2nd column
    public void fetchDataAt3Row2Column() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
						
        driver.get("http://demo.guru99.com/test/web-table-element.php");					  
        driver.manage().window().maximize();  

        WebElement baseTable = driver.findElement(By.tagName("table")); 
        
        // To find third row of table
		WebElement tableRow = baseTable.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[3]"));
        String rowtext = tableRow.getText();
		System.out.println("Third row of table : "+rowtext);
		    
		// To get 3rd row's 2nd column data
		WebElement cellIneed = tableRow.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[3]/td[2]"));
		String valueIneed = cellIneed.getText();
		System.out.println("Cell value is : " + valueIneed); 
        		
        driver.close();
    }
	
	@Test(enabled=false)
	// This method is used to fetch the maximum of all the values in a column(here column is : Current Price (Rs)) of Dynamic Table
    public void maxValueInAColumn() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
						
        driver.get("http://demo.guru99.com/test/web-table-element.php");					  
        driver.manage().window().maximize();  

        // Total number of rows 
        List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]")); 
        System.out.println("No of rows are : " + rows.size());
        
        double maximum = 0;
        for (int i=1;i<=rows.size();i++)
        {    
            String max= driver.findElement(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr["+(i+1)+"]/td[4]")).getText();
            double value = Double.parseDouble(max);
            if(value>maximum)
             {    
                maximum=value;
             }
        }
        System.out.println("Maximum value of current price is :"+maximum);
        		
        driver.close();
    }
	
	@Test
	// This method is used to display all the data of the dynamic table
    public void displayAllValuesOfDynamicTable() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
						
        driver.get("http://demo.guru99.com/test/web-table-element.php");					  
        driver.manage().window().maximize();  

        // Total number of rows 
        List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]")); 
        System.out.println("No of rows are : " + rows.size());
        
        // Total number of columns
        List<WebElement> cols = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th"));
        System.out.println("No of cols are : " +cols.size());
        
       	for (int i=1;i<=rows.size();i++) {
  
    	    for (int j=1;j<= cols.size();j++) {
    	        // To retrieve text from that specific cell.
    	        String celltext = driver.findElement(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr["+i+"]/td["+j+"]")).getText() ;
    	        System.out.println("Cell Value of row number " + i + " and column number " + j + " Is " + celltext);
    	 }
    	    System.out.println();
       	}
        driver.close();
    }
}
