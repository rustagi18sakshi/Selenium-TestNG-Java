package testngDemo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
/*
How to use @DataProvider data partially in TestNG test method
*/
public class TestNGDataProviderDemo {
	
	  /*@DataProvider(name = "testData")
	  public static String[][] testDataProvider() {

		  String[][] data = new String[][] {
				  					{"a","b","c"},
				  					{"d","e","f"}
		  						};
		  return data;
	  }*/

	  @DataProvider(name = "testData")
	  public static Object[][] testDataProvider() {

		  Object[][] data = new Object[][] {
				  					new String[]{"a","b","c"},
				  					new String[]{"d","e","f"}
		  						};
		  return data;
	  }
	  
	 @Test(priority=1,dataProvider = "testData")
	  public void test1(String... str1) {
	      System.out.println("first string"+" "+str1[0]);

	  }

	  @Test(priority=2,dataProvider = "testData")
	  public  void test2(String... str2) {
	      System.out.println("second string"+" " + str2[1]);

	  }
}
