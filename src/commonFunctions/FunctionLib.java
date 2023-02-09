package commonFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Reporter;

import Constant.ApplicationUtil;

public class FunctionLib extends ApplicationUtil
{
	public static boolean verifylogin(String user,String pass)
	{
		driver.get(config.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(config.getProperty("username"))).sendKeys(user);
		driver.findElement(By.cssSelector(config.getProperty("password"))).sendKeys(pass);
		driver.findElement(By.cssSelector(config.getProperty("Login"))).sendKeys(Keys.ENTER);
		//driver.switchTo().alert().accept();
		/*
		 * String Expected="InCorrect BankerName/Password"; String
		 * Actual=driver.switchTo().alert().getText();
		 * 
		 * if (Actual.equalsIgnoreCase(Expected)) { Reporter.log(Expected+Actual,true);
		 * return true; }
		 * 
		 * else { driver.switchTo().alert().accept();
		 * 
		 * } driver.switchTo().alert().accept();
		 */		 
		
		return false;
	}
}
