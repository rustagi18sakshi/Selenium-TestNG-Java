package testngDemo;

import org.testng.annotations.Test;

public class TestNGExceptionsDemo {
	
	@Test(expectedExceptions = ArithmeticException.class)
	public void test1(){
		System.out.println("I am inside Test 1");
		int i=1/0;
	}
	
	@Test
	public void test2(){
		System.out.println("I am inside Test 2");
		int i=1/0;
	}
}
