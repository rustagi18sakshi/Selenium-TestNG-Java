package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import test.GoogleSearch_TestNG_Demo;

public class PropertiesFile_demo {

	static String projectPath = System.getProperty("user.dir");
	static Properties prop = new Properties();       // Initialization
	
	public static String browser;                    
	
	// To get properties from the .properties file
	public static void getProperties()
	{
		try 
		{
			InputStream input = new FileInputStream(projectPath+"/src/test/java/config/config.properties");
			
			prop.load(input);       //To load properties
			browser = prop.getProperty("browser");     
			System.out.println(browser);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// To set properties and store it in the .properties file
	public static void setProperties()
	{
		try 
		{
			OutputStream output = new FileOutputStream(projectPath+"/src/test/java/config/config.properties");
			
			prop.setProperty("result", "pass");    //To set property
			prop.store(output, null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	// Just for demonstrating the keyword usage otherwise not needed
	public static void main(String[] args) {

		getProperties();
		setProperties();
	}
}
