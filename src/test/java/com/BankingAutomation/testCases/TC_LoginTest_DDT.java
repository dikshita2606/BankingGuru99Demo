package com.BankingAutomation.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BankingAutomation.pageObjects.logInPage;
import com.BankingAutomation.utilities.XLSUtils;

public class TC_LoginTest_DDT extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException{
		driver.manage().window().maximize();
		logInPage lp = new logInPage(driver);
		lp.setUserName(user);
		logger.info("User Name set successfully");
		lp.setPassword(pwd);
		logger.info("Password set successfully");
		lp.clickSubmit();
		logger.info("Submit Button Clicked");
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			System.out.println(driver.switchTo().alert().getText());
			logger.warn("Login Failed");
			Assert.assertTrue(false);
		}
		else {
			logger.info("Login passed");
			Assert.assertTrue(true);
			lp.clicklogOut();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent() //user defined method created to check alert is presetn or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException{
		
		String filePath = System.getProperty("user.dir")+"/src/test/java/com/BankingAutomation/testData/LoginData.xlsx";
		
		int rowNum = XLSUtils.getRowCount(filePath, "LogInSheet");
		int colNum = XLSUtils.getCellCount(filePath, "LogInSheet", 1);
		
		String loginData[][] = new String[rowNum][colNum];
		
		for(int i=1;i<=rowNum;i++) {//started from 1 index because at 0 row there will be headings
			for(int j=0;j<colNum;j++) {
				loginData[i-1][j] = XLSUtils.getCellData(filePath, "LogInSheet", i, j);
			}
		}
		return loginData;
	}
}
