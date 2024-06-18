package com.BankingAutomation.testCases;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BankingAutomation.pageObjects.DeleteCustomerPage;
import com.BankingAutomation.pageObjects.logInPage;

public class DeleteCustomer extends BaseClass {
	@Test(dataProvider = "DelCustomer")
	public void deletecust(String custid) throws InterruptedException {
		
		System.out.println("-------------------Deleteing Customer-----------------");
		driver.manage().window().maximize();
		logInPage lp= new logInPage(driver);
		lp.setUserName(UserName);
		lp.setPassword(Password);
		lp.clickSubmit();
		logger.info("LogIn bn clicked");
		
		Thread.sleep(5000);
		DeleteCustomerPage dc = new DeleteCustomerPage(driver);
		//dc.deletecustomerLink();
		driver.findElement(By.xpath("html/body/div[3]//ul[@class='menusubnav']/li[4]/a")).click();
		System.out.println("Delete");
		System.out.println("--------------------Handling Google Adds ------------------------");
		if(driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0")).isDisplayed()) {
			handleGoogleAds(driver);
			driver.switchTo().defaultContent();
		}
		else
		{
			System.out.println(("Ads not present"));
		}
		
		dc.enterCustID(custid);
		logger.info(custid+" entered");
		System.out.println(custid+" entered");
		dc.clickSubmit();
		logger.info("Submit btn Clicked");
		System.out.println("Submit btn Clicked");
		acceptalert(driver);
		acceptalert(driver);
		
		//click home Link Right bottom
		driver.findElement(By.xpath("//p/a")).click();
		
		lp.clicklogOut();
		logger.info("logOut clicked");
		acceptalert(driver);
		
	}
	
	@DataProvider(name="DelCustomer")
	public Object[][] getDataFromDataprovider(){
		return new Object[][] {
            { "26161" }
        };
	}
}
