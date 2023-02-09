package commonFunctions;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Reporter;
import Constant.AppUtil;
public class FunctionLibrary extends AppUtil{
	public static boolean validatelogin(String username,String Password) 
	{
		driver.get(config.getProperty("Url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(config.getProperty("user"))).sendKeys(username);;
		driver.findElement(By.cssSelector(config.getProperty("pass"))).sendKeys(Password);;
		driver.findElement(By.cssSelector(config.getProperty("Login"))).click();
		String Expected="dashboard";
		String Actual=driver.getCurrentUrl();
		if (Actual.contains(Expected))
		{
			Reporter.log(Expected+"      "+Actual,true);
			return true;
		} else 
		{
			String Errormessage=driver.findElement(By.cssSelector(config.getProperty("Emessge"))).getText();
			Reporter.log(Errormessage+Expected+ "      "+Actual,true);
			return false;
		}
	}
}
