package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelFileUtil
{
	XSSFWorkbook wb;

	//constructor
	public  excelFileUtil(String excelpath)throws Throwable {

		FileInputStream fi=new FileInputStream(excelpath);
		wb=new XSSFWorkbook(fi);
	}
	//Method for row count
	public int rowcount(String sheetname) 
	{
		return wb.getSheet(sheetname).getLastRowNum();

	}
	//Method for cell count
	public int cellcount(String sheetname) {
		return wb.getSheet(sheetname).getRow(0).getLastCellNum();

	}
	//Method for celldata
	public String getcelldata(String sheetname,int row,int cell) {
		String data="";
		if(wb.getSheet(sheetname).getRow(row).getCell(cell).getCellType()==Cell.CELL_TYPE_NUMERIC) {
			int celldata=(int)wb.getSheet(sheetname).getRow(row).getCell(cell).getNumericCellValue();
			data=String.valueOf(celldata);

		}
		else {
			data=wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		}
		return data;

	}
	//method for setcelldata
	public void setcellData(String sheetname,int row,int column,String status,String writeexcel)throws Throwable {
		//get sheet from workbook
		XSSFSheet ws=wb.getSheet(sheetname);
		//get row
		XSSFRow wr=ws.getRow(row);

		//getcell
		XSSFCell wc=wr.createCell(column);
		//write status
		wc.setCellValue(status);

		FileOutputStream fo=new FileOutputStream(writeexcel);
		wb.write(fo);
	}
	/*public static void main(String[]args) throws Throwable {
		excelFileUtil xl=new excelFileUtil("D:/seleniumpractice/Excel/LoginData.xlsx");
		//row count
		int rc=xl.rowcount("Login");
		//cellcount
		int cc=xl.cellcount("Login");
		System.out.println(rc+":     "+cc);
		//celldata
		for (int i = 1; i<=rc; i++) {
			String user=xl.getcelldata("Login", i, 0);
			String pass=xl.getcelldata("Login", i, 1);
			System.out.println(user+"         "+pass);
			xl.setcellData("Login",i,2, "Pass","D:/Seleniumpractice/Results/LoginDataresult.xlsx");
			//xl.setcellData("Login",i,2, "Fail","D:\\Seleniumpractice\\Results.xlsx");
			//xl.setcellData("Login",i,2, "Blocked","D:\\Seleniumpractice\\Results.xlsx");

	 */


}





