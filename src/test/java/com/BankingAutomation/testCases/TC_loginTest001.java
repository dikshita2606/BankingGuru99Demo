package com.BankingAutomation.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.BankingAutomation.pageObjects.logInPage;

public class TC_loginTest001 extends BaseClass{
	@Test
	public void loginTest() throws IOException {
		System.out.println("================LogIn Test Case===============");
		
		driver.manage().window().maximize();
		
		logInPage lp= new logInPage(driver);
		lp.setUserName(UserName);
		logger.info("UserName is entered sucessfully");
		lp.setPassword(Password);
		logger.info("Password is entered sucessfully");
		lp.clickSubmit();
		logger.info("Submit button is clicked");
		
		System.out.println(driver.getTitle());
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Title Matched");
		}
		else
		{
			captureScreen(driver,"loginTest");
			logger.info("Title not Matched");
			Assert.assertFalse(true);
			
		}
		
		lp.clicklogOut();
		System.out.println("logout Clicked");
	}
}
