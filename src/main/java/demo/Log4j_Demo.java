package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j_Demo {
	
	//Create logger 0bject and pass class name as variable
	private static Logger logger = LogManager.getLogger(Log4j_Demo.class);
			
	public static void main(String[] args) {
		
		System.out.println("\n Hello World \n");
		
		//Property file is defined at src/main/resources/log4j2.properties
		logger.debug("This is a debug message");
		logger.info("This is an information message");
		logger.error("This is an error message");
		logger.warn("This is a warning message");
		logger.fatal("This is a fatal message");
		
		//This will not be logged since rootLevel for log is set as 'Debug'
		logger.trace("This is a trace message");
		
		System.out.println("Completed");	
	}
}
