package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import test.GoogleSearch_TestNG_Demo;

public class PropertiesFile_demo {

	//Initialization
	static Properties prop = new Properties();
	static String projectPath = System.getProperty("user.dir");
	
	public static void main(String[] args) {

		getProperties();
		setProperties();
	}
	
	//To get properties from the .properties file
	public static void getProperties()
	{
		try {
			
			InputStream input = new FileInputStream(projectPath+"/src/test/java/config/config.properties");
			
			//To load property
			prop.load(input);
			String browser = prop.getProperty("browser");
			System.out.println(browser);
			//Here we are setting the value of variable : browserName in class : GoogleSearch_TestNG_Demo
			GoogleSearch_TestNG_Demo.browserName=browser;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//To set properties and store it in the .properties file
	public static void setProperties()
	{
		try {
			
			OutputStream output = new FileOutputStream(projectPath+"/src/test/java/config/config.properties");
			//To set property
			prop.setProperty("result", "pass");
			prop.store(output, null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
