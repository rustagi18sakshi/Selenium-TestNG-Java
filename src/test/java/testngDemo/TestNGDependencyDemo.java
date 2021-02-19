package testngDemo;

import org.testng.annotations.Test;

public class TestNGDependencyDemo {
	
		@Test(dependsOnGroups={"sanity1","sanity2"})
		public void testOne(){
			System.out.println("I am inside Test 1");
		}
		
		@Test(groups={"sanity1"})
		public void testTwo(){
			System.out.println("I am inside Test 2");
		}
		
		@Test(groups={"sanity2"})
		public void testThree(){
			System.out.println("I am inside Test 3");
		}
}
