package testngDemo;

import org.testng.annotations.Test;

//testng.xml for this : testng4.xml
@Test(groups={"AllClassTests"})
public class TestNGGroupsDemo {

	@Test(groups={"Sanity"})
	public void test1(){
		System.out.println("I am inside Test 1");
	}
	
	@Test(groups={"Sanity","Smoke"})
	public void test2(){
		System.out.println("I am inside Test 2");
	}
	
	@Test(groups={"Regression","Sanity"})
	public void test3(){
		System.out.println("I am inside Test 3");
	}
	
	@Test(groups={"window.regression"})
	public void test4(){
		System.out.println("I am inside Test 4");
	}

}
