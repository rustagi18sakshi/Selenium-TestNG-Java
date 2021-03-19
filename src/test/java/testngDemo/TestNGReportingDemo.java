package testngDemo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestNGReportingDemo {
	
	//For verifying success
	@Test
	public void test1()
	{
		Reporter.log("Inside scenario to be passed");    // For TestNG reporting
		System.out.println("I am inside Test 1"); 
		Reporter.log("Inside scenario to be passed");    // For TestNG reporting
	}

	//For verifying failure
	@Test
	public void test2()
	{
		Reporter.log("Inside scenario to be failed");    // For TestNG reporting
		System.out.println("I am inside Test 2");
		Assert.assertTrue(false);
	}
	
	//For verifying skipping
	@Test
	public void test3()
	{
		Reporter.log("Inside scenario to be skipped");    // For TestNG reporting
		System.out.println("I am inside Test 3");
		throw new SkipException("This test is skipped.");
	}
}