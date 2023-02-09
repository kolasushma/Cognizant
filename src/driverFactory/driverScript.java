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
import Constant.AppUtil;
import Utilities.excelFileUtil;
import commonFunctions.FunctionLibrary;
public class driverScript extends AppUtil
{
String inputpath="C:\\Users\\user\\eclipse-workspace\\DDT_Framework\\TestInput\\LoginData.xlsx";
String outputpath="C:\\Users\\user\\eclipse-workspace\\DDT_Framework\\TestOutput\\DataDrivenresults.xlsx";
ExtentReports report;
ExtentTest test;
@Test
public void starttest() throws Throwable
{
	report=new ExtentReports("D:\\Seleniumpractice\\Reports\\DataDriven.html");

//create object for excelfileutil
excelFileUtil xl=new excelFileUtil(inputpath);
//count. of no.of rows from sheet
int rc=xl.rowcount("Login");
//Count no. of cell in rows
int cc=xl.cellcount("Login");
Reporter.log(rc+"   "+cc,true);
//iterations
for (int i = 1; i <=rc; i++) 
{
	test=report.startTest("validatelogin");

	String user=xl.getcelldata("Login",i,0);
	String pass=xl.getcelldata("Login",i,1);
	Reporter.log(user+"       "+pass,true);
	boolean res=FunctionLibrary.validatelogin(user,pass);
	if(res) {
	//write status  as login sucess in results column
	xl.setcellData("Login", i,2 ,"loginsucess",outputpath);
	//write status pass column
	xl.setcellData("login", i, 3,"pass", outputpath);
	test.log(LogStatus.PASS,"Loginsucess");
	}
	else {
		File Screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Screen,new File("D:\\Seleniumpractice\\Screen shots\\"+i+"loginpage.png"));
		//write status  as login fail in results column
		xl.setcellData("Login", i,2 ,"loginFail",outputpath);
		//write status  as fail in results column
		xl.setcellData("Login", i,3 ,"Fail",outputpath);
		test.log(LogStatus.FAIL,"LoginFail");
	}
	report.endTest(test);
	report.flush();
	
}

}
}


