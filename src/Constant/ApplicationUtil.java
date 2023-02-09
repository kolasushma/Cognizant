package Constant;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class ApplicationUtil {
	public static WebDriver driver;
	public static Properties config;
	@BeforeTest
	public void setup() throws Throwable, Throwable {
		config=new Properties();
		config.load(new FileInputStream("C:\\Users\\user\\eclipse-workspace\\DDT_Framework\\src\\properttyFile\\Primus.Properties"));
		driver=new ChromeDriver();
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}


