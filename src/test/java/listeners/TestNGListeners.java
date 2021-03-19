package listeners;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

// The class implements ITestListener interface and implements all its methods.
public class TestNGListeners implements ITestListener{
	
		String projectPath = System.getProperty("user.dir");
		String filePath = projectPath+"/screenshot/";
		
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
		
	    public void takeScreenShot(String methodName, WebDriver driver) throws IOException {
	    	
	    	 Screenshot screenshot = new AShot().takeScreenshot(driver);
	    	 ImageIO.write(screenshot.getImage(), "png", new File(filePath+methodName+".png"));
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
