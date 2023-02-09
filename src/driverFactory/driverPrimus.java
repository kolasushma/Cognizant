package driverFactory;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Constant.ApplicationUtil;
import Utilities.ExcelUtilities;
import commonFunctions.FunctionLib;

public class driverPrimus extends ApplicationUtil
{
	String inputpath="C:\\Users\\user\\eclipse-workspace\\DDT_Framework\\TestInput\\primuslogin.xlsx";
	String outputpath="C:\\Users\\user\\eclipse-workspace\\DDT_Framework\\TestOutput\\PrimusResults.xlsx";
	ExtentReports report;
	ExtentTest test;
	@Test
	public void startTest() throws Throwable {
		report=new ExtentReports("D:\\Seleniumpractice\\Reports\\PrimusDatadriven.html"); 
		//create object for excle file
		ExcelUtilities eu=new ExcelUtilities(inputpath);
		//count no. of rows
		int rc=eu.rowcount("Login");
		//count no. of cells
		int cc=eu.cellcount("Login");
		Reporter.log(rc+"  "+cc,true);
		//METHOD FOE CELLDATA
		for (int i = 1; i <=rc; i++)
		{
			test=report.startTest("Validation login");
			String user=eu.celldata("Login", i, 0);
			String pass=eu.celldata("Login", i, 1);

			Reporter.log(user+"    "+pass);
			boolean res=FunctionLib.verifylogin(user,pass);
			if (res)
			{
				//write login sucess into column
				eu.setcelldata("Login",i,2,"LoginSucess",outputpath);
				//write login passin status into column
				eu.setcelldata("Login",i,3,"Pass",outputpath);
				//test.log(LogStatus.PASS,"LoginSucess");
			}
			else {
				//Take a screen shot
				File Screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(Screen,new File("D:\\Seleniumpractice\\Screen shots\\primus"+i+"primuslogin.png"));
				//write login sucess into column
				eu.setcelldata("Login",i,2,"LoginFail",outputpath);
				//write login passin status into column
				eu.setcelldata("Login",i,3,"Fail",outputpath);
				test.log(LogStatus.FAIL,"LoginFail");
			}
			report.endTest(test);
			report.flush();
		}
	}
}
