package test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonInSelenium {

	private static SingletonInSelenium instanceDriver = null;
	public WebDriver driver;
	
	private SingletonInSelenium()
	{
		
	}
	
	public WebDriver openBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}
	
	public static SingletonInSelenium getInstance()
	{
		if(instanceDriver == null)
		{
			instanceDriver = new SingletonInSelenium();
		}
		return instanceDriver;
	}
	
	public static void main(String[] args) {

		

	}

}
