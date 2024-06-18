package com.BankingAutomation.testCases;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.BankingAutomation.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readData = new ReadConfig();
	
	String Url = readData.getApplicationURL();
	String UserName = readData.getUserName();
	String Password = readData.getPassword();
	
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setup() {
		logger = Logger.getLogger(BaseClass.class);
		PropertyConfigurator.configure("log4j2.properties");
		
		driver = new ChromeDriver();
		logger.info("Chrome instance is open");
		driver.get(Url);
		logger.info("launching URL");
	}
	
	@AfterClass
	public void teardown() {
		acceptalert(driver);
		driver.quit();
		logger.info("Test Case ended and Chrome is closed");
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = ((TakesScreenshot)driver);
		File source =  ts.getScreenshotAs(OutputType.FILE);
		String date = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
		File destination = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+"_"+date+".png");
		FileHandler.copy(source, destination);
		System.out.println("ScreenShot taken");		
	}
	
	public void handleGoogleAds(WebDriver driver) throws InterruptedException {
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
	}

	
	public void acceptalert(WebDriver driver) {
		try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert Text : "+alert.getText());
            alert.accept();
        } catch (NoAlertPresentException e) {
            // Handle the case where no alert is present
            System.out.println("No alert found: " + e.getMessage());
        }
	}
}
