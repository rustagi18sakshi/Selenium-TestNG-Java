package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

// The class implements ITestListener interface and implements all its methods.
public class TestNGListeners implements ITestListener{

		public void onTestStart(ITestResult result)
		{
			System.out.println("******** Test started : "+result.getName());
		}
		
		public void onTestSuccess(ITestResult result)
		{
			System.out.println("******** Test is successful : "+result.getName());
		}
		
		public void onTestFailure(ITestResult result)
		{
			System.out.println("******** Test failed : "+result.getName());
		}
		
		public void onTestSkipped(ITestResult result)
		{
			System.out.println("******** Test skipped : "+result.getName());
		}
		
		public void onTestFailedButWithinSuccessPercentage(ITestResult result)
		{
			
		}
		
		// On the start of all the tests(one time)
		public void onStart(ITestContext context)
		{
			System.out.println("******** Tests started : "+context.getName());
		}
		
		// On the completion of all the tests(one time)
		public void onFinish(ITestContext context)
		{
			System.out.println("******** Tests completed : "+context.getName());
		}

}
