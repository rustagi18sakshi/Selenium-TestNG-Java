package aeonbitsMultipleEnvExecution;

import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Test;

public class BaseWeb  {

	@Test
	public void test()
	{
		Environment testEnvironment = ConfigFactory.create(Environment.class);
		
		System.out.println(testEnvironment.url());
		System.out.println(testEnvironment.getDBHostname());	 
	}
}
