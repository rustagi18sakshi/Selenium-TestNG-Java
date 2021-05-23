package listeners;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//We need to use annotation @Listener over the class and provide the name of the Listener class
//Other way of execution : Remove @Listeners and call listener directly from testng2.xml
//testng.xml for this : testng1.xml and testng2.xml
//@Listeners(listeners.TestNGListeners.class)
public class TestNGListenerDemo {

	//For verifying success
	@Test
	public void test1()
	{
		System.out.println("I am inside Test 1");
	}

	//For verifying failure
	@Test
	public void test2()
	{
		System.out.println("I am inside Test 2");
		Assert.assertTrue(false);
	}
	
	//For verifying skipping
	@Test
	public void test3()
	{
		System.out.println("I am inside Test 3");
		throw new SkipException("This test is skipped.");
	}
}
