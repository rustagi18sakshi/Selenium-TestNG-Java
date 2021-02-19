package listeners;

import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//We need to use annotation @Listener over the class and provide the name of the Listener class

@Listeners(listeners.TestNGListeners.class)
public class TestNGListenerDemo2 {

	//For verifying success
	@Test
	public void test4()
	{
		System.out.println("I am inside Test 4");
	}

	@Test
	public void test5()
	{
		System.out.println("I am inside Test 5");
	}
	
	//For verifying skipping
	@Test
	public void test6()
	{
		System.out.println("I am inside Test 6");
		throw new SkipException("This test is skipped.");
	}
}
