package testngDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestNGInvocationCountDemo {

	@Test
	public void one(){
		System.out.println("I am inside Test 1");
	}
	
	@Test(priority=1, invocationCount = 3)
	public void two(){
		System.out.println("I am inside Test 2");
	}
	
	@Test(priority=2)
	public void three(){
		System.out.println("I am inside Test 3");
	}
}
