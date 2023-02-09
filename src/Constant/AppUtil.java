package Constant;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AppUtil {
	public static WebDriver driver;
	public static Properties config;
	
	@BeforeTest
	public static void setup()throws Throwable
	{
	//create an object for properties file
	config=new Properties();
	config.load(new FileInputStream("C:\\Users\\user\\eclipse-workspace\\DDT_Framework\\src\\properttyFile\\Environment.properties"));
	driver=new ChromeDriver();
	}
	@AfterTest
	public static void teardown() {
	driver.close();
	}
}
