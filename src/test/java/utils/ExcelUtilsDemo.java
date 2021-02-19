package utils;

public class ExcelUtilsDemo {

	public static void main(String[] args) {

		String projectPath = System.getProperty("user.dir");
		ExcelUtils excel = new ExcelUtils(projectPath+"/excel/data.xlsx", "Sheet1");
		
		excel.getRowCount();
		String value = excel.getCellDataString(2, 0);
		System.out.println(value);

	}

}
