package com.BankingAutomation.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSUtils {
	public static FileInputStream fin;
	public static FileOutputStream fout;
	public static XSSFWorkbook xlsWorkbook;
	public static XSSFSheet xlsSheet;
	public static XSSFCell xlsCell;
	public static XSSFRow xlsRow;
	
	public static int getRowCount(String xlFile, String xlSheet) throws IOException{
		fin = new FileInputStream(xlFile);
		xlsWorkbook = new XSSFWorkbook(fin);
		xlsSheet = xlsWorkbook.getSheet(xlSheet);
		int rowCount = xlsSheet.getLastRowNum();
		xlsWorkbook.close();
		fin.close();
		return rowCount;
	}
	
	public static int getCellCount(String xlFile, String xlSheet, int xlrow) throws IOException{
		fin = new FileInputStream(xlFile);
		xlsWorkbook = new XSSFWorkbook(fin);
		xlsSheet = xlsWorkbook.getSheet(xlSheet);
		xlsRow = xlsSheet.getRow(xlrow);
		int CellCount = xlsRow.getLastCellNum();
		xlsWorkbook.close();
		fin.close();
		return CellCount;
	}

	public static String getCellData(String xlFile, String xlSheet, int xlrow, int xlcell) throws IOException{
		fin = new FileInputStream(xlFile);
		xlsWorkbook = new XSSFWorkbook(fin);
		xlsSheet = xlsWorkbook.getSheet(xlSheet);
		xlsRow = xlsSheet.getRow(xlrow);
		xlsCell = xlsRow.getCell(xlcell);
		String data;
		try {
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(xlsCell);
			return cellData;
		}
		catch(Exception ex) {
			System.out.println("Error encountered : "+ex.getMessage());
			data="";
		}
		xlsWorkbook.close();
		fin.close();
		return data;
	}
	
	public static void setCellData(String xlFile, String xlSheet, int xlrow, int xlcell,String Data) throws IOException{
		fin = new FileInputStream(xlFile);
		xlsWorkbook = new XSSFWorkbook(fin);
		xlsSheet = xlsWorkbook.getSheet(xlSheet);
		xlsRow = xlsSheet.getRow(xlrow);
		xlsCell = xlsRow.createCell(xlcell);
		xlsCell.setCellValue(Data);
		fout = new FileOutputStream(xlFile);
		xlsWorkbook.write(fout);
		xlsWorkbook.close();
		fin.close();
		fout.close();		
	}
	
	public static String addCustomerDetails(String xlFile, String xlSheet, int xlrow, int xlcell) throws IOException {
		fin = new FileInputStream(xlFile);
		xlsWorkbook = new XSSFWorkbook(fin);
		xlsSheet = xlsWorkbook.getSheet(xlSheet);
		xlsRow = xlsSheet.getRow(xlrow);
		xlsCell = xlsRow.getCell(xlcell);
		String details;
		try {
			DataFormatter formatData = new DataFormatter();
			String custDetails = formatData.formatCellValue(xlsCell);
			return custDetails;
		}
		catch(Exception ex)
		{
			System.out.println("Exception Message : "+ex.getMessage());
			details = "";
		}
		xlsWorkbook.close();
		fin.close();
		return details;
	}
}
