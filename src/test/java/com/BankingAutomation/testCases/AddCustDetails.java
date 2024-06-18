package com.BankingAutomation.testCases;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BankingAutomation.pageObjects.AddCustomerPage;
import com.BankingAutomation.pageObjects.logInPage;
import com.BankingAutomation.utilities.XLSUtils;


public class AddCustDetails extends BaseClass{
	
	@Test(dataProvider = "CustomerDetailsAdd")
	public void addcustomerDetails(String custName, String custG, String custdob, String custAdd, String custCity, String custState, String custPin, String custPhone, String CustEmail, String CustPass ) throws InterruptedException, IOException {
		System.out.println("====================== Launching Website ======================");
		driver.manage().window().maximize();
		logInPage lp =new logInPage(driver);
		lp.setUserName(UserName);
		System.out.println("UserName Set");
		logger.info("UserNAme set");
		lp.setPassword(Password);
		System.out.println("Password Set");
		logger.info("Password set");
		lp.clickSubmit();
		System.out.println("Login Btn Clicked");
		logger.info("Login Btn Clicked");
		System.out.println("_________________________________________________________________");
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		addcust.newCustomerClick();
		System.out.println("New Customer Clicked");
		logger.info("New Customer Clicked");
		System.out.println("____________________________________________________________________");
		Thread.sleep(5000);

		System.out.println("--------------------Handling Google Adds ------------------------");
		if(driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0")).isDisplayed()) {
			handleGoogleAds(driver);
			driver.switchTo().defaultContent();
		}
		else
		{
			System.out.println(("Ads not present"));
		}
		
		
		Thread.sleep(2000);
		System.out.println("---------------Adding Customer Details---------------");
		addcust.custNameInput(custName);
		addcust.custGender(custG);
		String[] dob = custdob.split(";");
		addcust.custdob(dob[0],dob[1],dob[2]);
		Thread.sleep(5000);
		addcust.custaddress(custAdd);
		addcust.custcity(custCity);
		addcust.custstate(custState);
		addcust.custpinno(custPin);
		addcust.custtelephoneno(custPhone);
		addcust.custPassword(CustPass);
		addcust.custemailid(CustEmail);
		
		System.out.println("====================Data added successfully and Click Submit button============");
		addcust.custsubmit();
		
		acceptalert(driver);
		
		System.out.println("fetching all data from UI to Hashtable");
		HashCustomerDetails();
		
		//click home Link Right bottom
		driver.findElement(By.xpath("//p/a")).click();
		
		lp.clicklogOut();
		logger.info("logOut clicked");
		acceptalert(driver);
			 
	}

	@DataProvider(name = "CustomerDetailsAdd")
	String[][] getCustomerDetails() throws IOException{
		String filePath = System.getProperty("user.dir")+"/src/test/java/com/BankingAutomation/testData/CustomerDetailsAd.xlsx";
		
		int rowNum = XLSUtils.getRowCount(filePath, "CustomerData");
		int colNum = XLSUtils.getCellCount(filePath, "CustomerData", 1);
		System.out.println("Row Count in excel Sheet: "+rowNum);
		System.out.println("Cloumn Count  in excel Sheet: "+colNum);
		
		
		String data[][] = new String[rowNum][colNum];
		
		for(int i=1;i<=rowNum;i++) {
			for(int j = 0;j<colNum;j++)
			{
				data[i-1][j] = XLSUtils.addCustomerDetails(filePath, "CustomerData", i, j);
			}
		}
		//System.out.println("Data Customer Details : "+data);
		return data;
	}
	
	
	public List<Map<String, String>> HashCustomerDetails(){
		WebElement table = driver.findElement(By.xpath("//table[@id='customer']"));
		List<Map<String, String>> dataList = new ArrayList<>();
		//create hashmap to store header name and values adn stored the values in excel vertically
		Map<String, String> deatils = new HashMap<>();
		
		List<WebElement> rows = table.findElements(By.xpath(".//tr"));
		System.out.println("Row Size : "+rows.size());
		for(int i=3;i<rows.size()-1;i++) {
			WebElement row = rows.get(i);
			List<WebElement> cells = row.findElements(By.xpath(".//td"));
			String header = cells.get(0).getText();
			System.out.println("Header : "+header);
			String Value = cells.get(1).getText();
			System.out.println("Value : "+Value);
			deatils.put(header, Value);			
		}
		dataList.add(deatils);
		System.out.println("DataList : "+dataList);
		return dataList;
		
	}
}
