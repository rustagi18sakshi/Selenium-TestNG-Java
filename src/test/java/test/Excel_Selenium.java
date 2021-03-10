package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/*
Link for reference : https://www.toolsqa.com/selenium-webdriver/excel-in-selenium/
*/
public class Excel_Selenium {

	// In workbook row and column starts from index 0
	
	//@Test
	// This is used to fetch data at 2nd row and 1st column
    public void fetchDataAt2Row1Column() throws IOException {
		
		String projectPath = System.getProperty("user.dir");
		XSSFWorkbook workbook = new XSSFWorkbook(projectPath+"/excel/data.xlsx");
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		String data = sheet.getRow(1).getCell(0).getStringCellValue();
		System.out.println("Value at 2nd row and 1st column is : "+data);
	}
	
	//@Test
	// This is used to read all the data of the excel sheet
    public void readEntireExcelSheet() throws IOException {
		
		String projectPath = System.getProperty("user.dir");
		XSSFWorkbook workbook = new XSSFWorkbook(projectPath+"/excel/data.xlsx");
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		int columCount = sheet.getRow(0).getPhysicalNumberOfCells();
		
		for(int i=0;i<rowCount;i++)
		{
			System.out.println("Row "+i+" data is :");
			for(int j=0;j<columCount;j++)
			{
				String data = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.print(data+" ");
			}
			System.out.println();
		}
	}
	
	//@Test
	// This is used to write new cell in an existing row
    public void writeNewCellInExistingRow() throws IOException 
	{	
		String projectPath = System.getProperty("user.dir");

		// Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(projectPath+"/excel/data1.xlsx");
        
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		int columCount = sheet.getRow(1).getPhysicalNumberOfCells();
		
		for(int i=1;i<rowCount;i++)      // Writing in the rows after the header
		{
			XSSFCell cell= sheet.getRow(i).createCell(columCount);    // Creating a new cell
			cell.setCellValue("PASS");								  // Setting the value of the new cell
			
			// Write the data back in the Excel file
			FileOutputStream output = new FileOutputStream(projectPath+"/excel/data1.xlsx");
			workbook.write(output);
			// Close the output Stream
			output.flush();
			output.close();
		}		
		workbook.close();     // Close the workbook
	}	
	
	@Test
	// This is used to create a new row and write in the new cell
    public void writeNewCellInNewRow() throws IOException 
	{		
		String projectPath = System.getProperty("user.dir");

		// Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(projectPath+"/excel/data2.xlsx");
        
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rowCount = sheet.getPhysicalNumberOfRows();     // Getting total number of rows present initially
		
		// Creating a new row(e.g. row4) and setting column values as : Username4, Password4
		XSSFRow row = sheet.createRow(rowCount);          
		row.createCell(0).setCellValue("Username"+rowCount);
		row.createCell(1).setCellValue("Password"+rowCount);
		
		// Write the data back in the Excel file
		FileOutputStream output = new FileOutputStream(projectPath+"/excel/data2.xlsx");
		workbook.write(output);
		// Close the output Stream
		output.flush();
		output.close();
		
		workbook.close();     // Close the workbook
	}	
}
