package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtilities
{
XSSFWorkbook wb;
public ExcelUtilities(String excelpath) throws Throwable
{
FileInputStream Fi=new FileInputStream(excelpath);
wb=new XSSFWorkbook(Fi);
}
//method for row count
public int rowcount(String sheetname)
{

	return wb.getSheet(sheetname).getLastRowNum();
} 
//method for column count
public int cellcount(String sheetname)
{
return wb.getSheet(sheetname).getRow(0).getLastCellNum();

}
//method for celldata
public String celldata(String sheetname,int row,int column)
{
	String data="";
	if ((wb.getSheet(sheetname).getRow(row).getCell(column).getCellType()==Cell.CELL_TYPE_NUMERIC)) 
	{
		int celldata=(int)wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
		 data=String.valueOf(celldata);
	}
else
{
	data=wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
}
	return data;
}
//method for setcelldata
public void setcelldata(String sheetname,int row,int column,String status,String writeExcel) throws Throwable 
{
XSSFSheet ws=wb.getSheet(sheetname);
XSSFRow rowcount= ws.getRow(row);
XSSFCell wc=rowcount.getCell(column);

//write status
wc.setCellValue(status);
FileOutputStream fo=new FileOutputStream(writeExcel);
wb.write(fo);
}
}

	


