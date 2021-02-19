package demo;

public class ExceptionHandlingDemo {
	
	public static void main(String[] args) {
		
		//Try block has be followed by one or multiple catch blocks or finally block
		//Even if there is no catch block but just finally block, then also try will execute.
		try
		{
			System.out.println("Hello World");
			//We are expecting java.lang.ArithmeticException exception here
			int i = 1/0;
			System.out.println("Completed");
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
