package com.BankingAutomation.testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.BankingAutomation.pageObjects.AddCustomerPage;
import com.BankingAutomation.pageObjects.logInPage;

import net.bytebuddy.utility.RandomString;

public class TC_AddCustomerTest extends BaseClass{

		@Test
	public void addCustomer() throws InterruptedException {
		driver.manage().window().maximize();
		logInPage lp =new logInPage(driver);
		lp.setUserName(UserName);
		logger.info("User Name set successfully");
		lp.setPassword(Password);
		logger.info("Password set successfully");
		lp.clickSubmit();
		logger.info("Submit Button Clicked");
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		addcust.newCustomerClick();
		logger.info("Add Customer is clicked");
		Thread.sleep(5000);
		
		WebElement frame1 = driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
        //Switch to frame with element
        driver.switchTo().frame(frame1);
        //Check button X or Close displays
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
    
	
		addcust.custNameInput("Dikshita");
		addcust.custGender("female");
		addcust.custdob("10","15","2000");
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
		

		WebElement table = driver.findElement(By.xpath("//table[@id='customer']"));
		List<WebElement> rows = table.findElements(By.xpath(".//tr"));
		for (WebElement row : rows) {
		    List<WebElement> cells = row.findElements(By.xpath(".//td"));
		    for (WebElement cell : cells) {
		        System.out.println(cell.getText());
		    }
		}

		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//p/a")).click();
		
		lp.clicklogOut();
		logger.info("logOut clicked");
		
	}
	
	public String randomestring() {
		String randomString = RandomString.make(8);
		return(randomString);
	}
	
	
}
