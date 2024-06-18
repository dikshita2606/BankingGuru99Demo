package com.BankingAutomation.testCases;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.BankingAutomation.pageObjects.AddCustomerPage;
import com.BankingAutomation.pageObjects.logInPage;

import net.bytebuddy.utility.RandomString;

@Test
public class AddCustomerDetailsSaveDemo extends BaseClass{
	
	String filePath = System.getProperty("user.dir")+"/src/test/java/com/BankingAutomation/testData/LoginData.xlsx";
	
	public void addCustomer() throws InterruptedException, IOException {
		
		System.out.println("================Add Customer Test Case===============");
		
		driver.manage().window().maximize();
		logInPage lp =new logInPage(driver);
		lp.setUserName(UserName);
		logger.info("User Name set successfully");
		lp.setPassword(Password);
		logger.info("Password set successfully");
		lp.clickSubmit();
		logger.info("Submit Button Clicked");
		System.out.println("_________________________________________________________________");
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		addcust.newCustomerClick();
		logger.info("Add Customer Link is clicked");
		System.out.println("_________________________________________________________________");
		Thread.sleep(5000);
		
		//handling google ad's
		WebElement frame1 = driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));        //Switch to frame with element
        driver.switchTo().frame(frame1);        //Check button X or Close displays     
        List < WebElement > checkButtonX = driver.findElements(By.xpath("//div[@id='dismiss-button']"));
        System.out.println("checkButtonX: " + checkButtonX.size());
        if (checkButtonX.size() > 0) 
        {
            driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
        } 
        else 
        {
            WebElement frame2 = driver.findElement(By.id("ad_iframe"));
            driver.switchTo().frame(frame2);
            Thread.sleep(1000);
            List < WebElement > checkButtonClose = driver.findElements(By.xpath("//div[@id='dismiss-button']//span[normalize-space()='Close']"));
            System.out.println("checkButtonClose: " + checkButtonClose.size());
            if (checkButtonClose.size() > 0) 
            {
                driver.findElement(By.xpath("//div[@id='dismiss-button']//span[normalize-space()='Close']")).click();
            } 
            else 
            {
                driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
            }
        }

        driver.switchTo().defaultContent();
        Thread.sleep(2000);
    
	
		addcust.custNameInput("Diks");
		addcust.custGender("female");
		addcust.custdob("10","15","2007");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("Dewas");
		addcust.custstate("Dewas");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");
		addcust.custPassword("Test@123");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custsubmit();
		logger.info("Submit btn clicked");
		System.out.println("_________________________________________________________________");
		
		//for handling if ny type of alert 
		try {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		catch(NoAlertPresentException ex) {
			System.out.println(ex.getMessage());
		}
		
		
		WebElement table = driver.findElement(By.xpath("//table[@id='customer']"));
		 
		//create hashmap to store header name and values adn stored the values in excel vrtically
		Map<String, String> customerData = new HashMap<>();
		
		List<WebElement> rows = table.findElements(By.xpath(".//tr"));
		System.out.println("Row Size : "+rows.size());
		for(int i=3;i<rows.size()-1;i++) {
			WebElement row = rows.get(i);
			List<WebElement> cells = row.findElements(By.xpath(".//td"));
			String header = cells.get(0).getText();
			System.out.println("Header : "+header);
			String Value = cells.get(1).getText();
			System.out.println("Value : "+Value);
			customerData.put(header, Value);			
		}
		
		System.out.println("Saving value in excel now");
			
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		//method below is used to add data into excel from hash map
		addHashMapToSheetHorizontally(workbook, "CustomerDetails", customerData);
		
		try (FileOutputStream outputStream = new FileOutputStream(System.getProperty("user.dir")+"/src/test/java/com/BankingAutomation/testData/CustomerDetails.xlsx")) {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

		Thread.sleep(3000);
		
		//click home Link Right bottom
		driver.findElement(By.xpath("//p/a")).click();
		
		lp.clicklogOut();
		logger.info("logOut clicked");
		
	}
	
	public String randomestring() {
		String randomString = RandomString.make(8);
		return(randomString);
	}
	
	//method for writing data in excel from hashmap
	public void addHashMapToSheetHorizontally(Workbook workbook, String sheetName, Map<String, String> hashMap) throws IOException {
		XSSFSheet sheet = (XSSFSheet) workbook.createSheet(sheetName);
	
		int rowNum = sheet.getLastRowNum()+1;
    	System.out.println("RowNum : "+rowNum);
	    System.out.println(rowNum);
	    for (Map.Entry<String, String> entry : hashMap.entrySet()) {
	    	Row row = sheet.createRow(rowNum++);
	        row.createCell(0).setCellValue(entry.getKey());
	        row.createCell(1).setCellValue(entry.getValue());
	    }
	}

}
