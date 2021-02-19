package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	//Constructor to define excel path and sheetname
	public ExcelUtils(String excelPath, String sheetName)
	{
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//For getting the count of total number of rows
	public int getRowCount() {
		
			int rowCount = 0;
			rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("Total number of rows are : "+rowCount);
			return rowCount;
	}
	
	//For getting the count of total number of columns
	public int getColumnCount() {
		
			int colCount = 0;
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("Total number of columns are : "+colCount);
			return colCount;
	}
	
	//For getting the string value at the cell
	public String getCellDataString(int rowNum, int colNum) {
		
			String data = null;
			data = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			return data;
	}
	
	//For getting the numeric value at the cell
	public double getCellDataNumber(int rowNum, int colNum) {
		
			double data = 0;
			data = (int) sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			return data;
	}
	
}
