package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
		public static FileInputStream fi;
		public static FileOutputStream fo;
		public static XSSFWorkbook wb;
		public static XSSFSheet sheet;
		public static XSSFRow row;
		public static XSSFCell cell;
		public static CellStyle style;   

		
		public static int getRowCount(String xlfile, String xlSheet) throws IOException
		{
			fi= new FileInputStream(xlfile);
			wb = new XSSFWorkbook(fi);
			sheet= wb.getSheet(xlSheet);
			int rowcount = sheet.getLastRowNum();
			wb.close();
			fi.close();
			return rowcount;
		}
		
		public static int getCellCount(String xlfile, String xlSheet, int rownum) throws IOException
		{
			fi= new FileInputStream(xlfile);
			wb = new XSSFWorkbook(fi);
			sheet= wb.getSheet(xlSheet);
			row = sheet.getRow(rownum);
			int cellcount = row.getLastCellNum();
			wb.close();
			fi.close();
			return cellcount;
		}
		
		public static String getCellData(String xlfile, String xlSheet, int rownum, int cellnum) throws IOException
		{
			fi= new FileInputStream(xlfile);
			wb = new XSSFWorkbook(fi);
			sheet= wb.getSheet(xlSheet);
			row = sheet.getRow(rownum);
			cell = row.getCell(cellnum);
			String Data;
			try
			{
				DataFormatter df = new DataFormatter();
				Data = df.formatCellValue(cell);
				//return Data;
			}
			catch(Exception e)
			{
				Data = "";
			}
			
			wb.close();
			fi.close();
			return Data;
		}
		
		public static void setCellData(String xlfile, String xlSheet, int rownum, int cellnum, String data) throws IOException 
		{
			fi = new FileInputStream(xlfile);
			wb = new XSSFWorkbook(fi);
			sheet = wb.getSheet(xlSheet);
			row = sheet.getRow(rownum);
			cell = row.createCell(cellnum);
			cell.setCellValue(data);
			fo = new FileOutputStream(xlfile);
			wb.write(fo);
			wb.close();
			fi.close();
			fo.close();		

		}
		
		public static void fillGreenColor(String xlfile, String xlSheet, int rownum, int cellnum) throws IOException 
		{
			fi = new FileInputStream(xlfile);
			wb = new XSSFWorkbook(fi);
			sheet = wb.getSheet(xlSheet);
			row = sheet.getRow(rownum);
			cell = row.getCell(cellnum);
			style = wb.createCellStyle();
			
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
					
			cell.setCellStyle(style);
			fo=new FileOutputStream(xlfile);
			wb.write(fo);
			wb.close();
			fi.close();
			fo.close();
		}
		
		public static void fillRedColor(String xlfile, String xlSheet, int rownum, int cellnum) throws IOException 
		{
			fi = new FileInputStream(xlfile);
			wb = new XSSFWorkbook(fi);
			sheet = wb.getSheet(xlSheet);
			row = sheet.getRow(rownum);
			cell = row.getCell(cellnum);
			style = wb.createCellStyle();
			
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
					
			cell.setCellStyle(style);
			fo=new FileOutputStream(xlfile);
			wb.write(fo);
			wb.close();
			fi.close();
			fo.close();
		}
			
		

	

}
