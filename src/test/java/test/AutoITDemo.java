package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*
AutoIT is a software designed for automating Windows GUI.
*/
public class AutoITDemo {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		autoITTest();
	}
	
	public static void autoITTest() throws IOException, InterruptedException
	{
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Using this URL since here we have to upload a file from our Windows machine
		driver.get("http://tinyupload.com/");	
		System.out.println(driver.getTitle());
		driver.findElement(By.name("uploaded_file")).click();
		
		//To run our AutoIT executable file
		Runtime.getRuntime().exec(projectPath+"/src/test/java/test/FileUploadScript.exe");
		Thread.sleep(3000);
		
		//driver.close();
		//driver.quit();
		System.out.println("Completed");	
	}

}
