package testngDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryListener implements IAnnotationTransformer {

	public void transform(ITestAnnotation testannotation, Class testClass, Constructor testConstructor, Method testMethod)	
	{
		RetryAnalyzer retry = (RetryAnalyzer) testannotation.getRetryAnalyzer();

		if (retry == null)	
		{
			testannotation.setRetryAnalyzer(RetryAnalyzer.class);
		}

	}
}
