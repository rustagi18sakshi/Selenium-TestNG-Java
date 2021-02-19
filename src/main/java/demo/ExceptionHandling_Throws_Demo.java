package demo;

public class ExceptionHandling_Throws_Demo {
	
	public static void main(String[] args) {
		
		try
		{
			demo();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("I am inside finally block");
		}
	}
	//If we use throws, then the exception will be handled by the calling method i.e. Main method here
	public static void demo() throws Exception
	{
		System.out.println("Hello World");
		//We are expecting java.lang.ArithmeticException exception here
		int i = 1/0;
		System.out.println("Completed");
	}
}
