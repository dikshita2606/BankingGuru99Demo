package com.BankingAutomation.testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TableDataDynamic {

	@Test
	public  void VerifyTable() throws InterruptedException {
		
		
		//selenium test with extensions
//		ChromeOptions opt = new ChromeOptions();
//		/*
//		 * System.out.println(System.getProperty("user.dir")); String filepath
//		 * =System.getProperty("user.dir")+"\\Extension\\AdBlock.crx";
//		 * System.out.println(filepath);
//		 */
//		
//		opt.addExtensions(new File(System.getProperty("user.dir")+"\\Extension\\AdBlock.crx"));
		
		/*ChromeOptions opt = new ChromeOptions();
		//opt.setHeadless(true);
		opt.addArguments("--headless=new");
		WebDriver driver = new ChromeDriver(opt);*/
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		System.out.println("Launching URL");
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		
		//Fetching all header into list 
		List<WebElement> allHeader = driver.findElements(By.xpath("//table[contains(@id,\"contactList\")]//th"));
		//List<WebElement> allHeader = driver.findElements(By.cssSelector("table#contactList"));
		
		System.out.println("Header SIze : "+allHeader.size());
		boolean headerStatus =false;
		System.out.println("Column Names are : ");
		for (WebElement ele : allHeader) 
		{
			System.out.println(ele.getText());
			if(ele.getText().contains("Contact"))
			{
				headerStatus = true;
							
			}
		}
		
		Assert.assertTrue(headerStatus,"Value is not present.");
		
		Assert.assertEquals(allHeader.size(), 5, "Header Size does not match");
		
		System.out.println("_____________________________________________________");
		
		List<WebElement> noOfRows = driver.findElements(By.xpath("//table[contains(@id,\"contactList\")]//tr"));
		System.out.println("Rows SIze : "+noOfRows.size());
		System.out.println("Rows Values are : ");
		for (WebElement ele : noOfRows) 
		{
			System.out.println(ele.getText());
		}
		
		Assert.assertEquals(noOfRows.size(), 7,"Rows doesnot match");
		

		System.out.println("_____________________________________________________");
		
		List<WebElement> tableData = driver.findElements(By.xpath("//table[contains(@id,\"contactList\")]//td"));
		System.out.println("Data SIze : "+tableData.size());
		boolean dataStatus = false;
		System.out.println("Data Values are : ");
		for (WebElement ele : tableData) 
		{
			System.out.println(ele.getText());
			if(ele.getText().contains("Canada")) 
			{
				dataStatus = true;
			}
		}
		Assert.assertTrue(dataStatus,"Data value is not present.");
		
		for (WebElement ele : tableData) 
		{
			System.out.println(ele.getText());
			if(ele.getText().contains("Mexico")) 
			{
				driver.findElement(By.xpath("//table[contains(@id,\"contactList\")]//td/preceding-sibling::td//input")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//table[contains(@id,\"contactList\")]//td/following-sibling::td//a")).click();
				Thread.sleep(5000);
				break;
			}
		}
		
		driver.quit();
		
		
		
		
		
	}

}
