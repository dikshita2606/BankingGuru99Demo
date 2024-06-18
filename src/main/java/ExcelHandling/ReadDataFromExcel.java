package ExcelHandling;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	public static void main(String[] args) throws IOException {
		
		// File --> Workbook --> Sheet --> Row --> Cell
		
		//System.out.println(System.getProperty("user.dir"));
		String Path =System.getProperty("user.dir")+"/src/main/java/ExcelHandling/test-data/CustomerDetailsNew.xlsx";
				
		FileInputStream fs = new FileInputStream(Path);
		System.out.println("File instance created");
		
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		System.out.println("workbook instance created");
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		System.out.println("Sheet instance created");
		
		int rows = sheet.getLastRowNum();		
		//System.out.println("Rows : "+rows+ " Cols : "+cells);
		
		System.out.println("Reading Data and Data is as follows :");
		for(int r=0;r<rows;r++)
		{
			XSSFRow currentRow = sheet.getRow(r);
			int cells = sheet.getRow(r).getLastCellNum();
			for(int c=0;c<cells;c++)
			{
				XSSFCell value = currentRow.getCell(c);
				System.out.print(value.toString()+"	    ");
			}
			System.out.println("");
		}
		workbook.close();
		fs.close();
	}

}
