package demo;

public class ExceptionHandling_Throw_Demo {
	
	public static void main(String[] args) {
		
		try
		{
			System.out.println("Hello World");
			//Throw keyword is used to deliberately throw an ArithmeticException exception here
			throw new ArithmeticException("Not a valid operation");
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
}
