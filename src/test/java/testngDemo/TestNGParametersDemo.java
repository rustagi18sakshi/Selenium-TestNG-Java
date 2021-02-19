package testngDemo;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//testng.xml for this : testng5.xml
public class TestNGParametersDemo {

	@Test
	@Parameters("MyName")
	//public void test1(@Optional("Sakshi") String name){
	public void test1(String name){
		System.out.println("Value of string is : "+name);
	}
	
}
