package testngDemo;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGIgnoreDemo {
		
		@Test(enabled=false)
		public void test1(){
			System.out.println("I am inside Test 1");
		}
		
		@Ignore
		@Test
		public void test2(){
			System.out.println("I am inside Test 2");
		}
		
		@Test
		public void test3(){
			System.out.println("I am inside Test 3");
		}
		
}
