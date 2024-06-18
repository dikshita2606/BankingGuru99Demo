package ExcelHandling;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataInExcel {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream fs = new FileOutputStream(System.getProperty("user.dir")+"/src/main/java/ExcelHandling/test-data/DataExcel.xlsx");
		System.out.println("File instance created");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		System.out.println("workbook instance created");
		
		XSSFSheet sheet = workbook.createSheet("Test");
		System.out.println("Sheet instance created");
		
		//XSSFCell cell = sheet.createRow(0).createCell(1);
		//cell.setCellValue("Test");
		/*XSSFRow row1 = sheet.createRow(0);
		row1.createCell(0).setCellValue("welcome");
		row1.createCell(1).setCellValue("to");
		row1.createCell(2).setCellValue("the");
		
		XSSFRow row2 = sheet.createRow(1);
		row2.createCell(0).setCellValue("excel");
		row2.createCell(1).setCellValue("file");
		row2.createCell(2).setCellValue("handling");
		System.out.println("cells instances are created");
		*/
		
		//file cell updating using loop
		for(int r=0;r<5;r++)
		{
			XSSFRow row = sheet.createRow(r);
			for(int c=0;c<4;c++)
			{
				row.createCell(c).setCellValue("["+r+","+c+"]");
			}
		}
			
			
			
			
		workbook.write(fs);
		workbook.close();
		fs.close();
		System.out.println("Voila!!! Data updated successfully. Please check excel for the confirmation :)");
		
		
	}

}
