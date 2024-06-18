package DataDrivenTesting;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCase {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		
		String file=System.getProperty("user.dir")+"/src/main/java/DataDrivenTesting/Data.xlsx";
		
		int row = XLUtils.getRowCount(file, "Sheet1");
		System.out.println("Rows :" + row);
		
		for(int i=1;i<=row;i++)
		{
			//read data from excel
			int col = XLUtils.getCellCount(file, "Sheet1", i);
			System.out.println("Cols : "+col+ " at row : "+i);
			
			
			String princ=XLUtils.getCellData(file,"Sheet1",i,0);
			String rateofinterest=XLUtils.getCellData(file,"Sheet1",i,1);
			String per1=XLUtils.getCellData(file,"Sheet1",i,2);
			String per2=XLUtils.getCellData(file,"Sheet1",i,3);
			String fre=XLUtils.getCellData(file,"Sheet1",i,4);
			String exp_mvalue=XLUtils.getCellData(file,"Sheet1",i,5);
			
			//passing data to the UI
			driver.findElement(By.id("principal")).sendKeys(princ);
			driver.findElement(By.id("interest")).sendKeys(rateofinterest);
			driver.findElement(By.id("tenure")).sendKeys(per1);

			Select period = new Select(driver.findElement(By.id("tenurePeriod")));
			period.selectByVisibleText(per2);
			
			Select frequency = new Select(driver.findElement(By.id("frequency")));
			frequency.selectByVisibleText(fre);
			
			JavascriptExecutor js =  (JavascriptExecutor)driver; 
			js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[contains(@class,\"PT15\")]/a[1]")));
			
			String act_value = driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText(); 
			System.out.println(act_value);
			
		/*	if (Double.parseDouble(exp_mvalue)==Double.parseDouble(act_value))
			{
				System.out.println("test Passed");
				XLUtils.setCellData(file, "Sheet1",i,7,"Passed");
				XLUtils.fillGreenColor(file, "Sheet1", i, 7);
			}
			else
			{
				System.out.println("test Failed");
				XLUtils.setCellData(file,"Sheet1", i, 7, act_value);
				XLUtils.fillRedColor(file, "Sheet1", i, 7);
			}*/
			
			if(Double.parseDouble(exp_mvalue)==Double.parseDouble(act_value))
			{
				System.out.println("Test Passsed");
				XLUtils.setCellData(file, "Sheet1",i,6,act_value);
				XLUtils.setCellData(file, "Sheet1",i,7,"Passed");
				XLUtils.fillGreenColor(file, "Sheet1",i,7);
			}
			else
			{
				System.out.println("Test Failed");
				XLUtils.setCellData(file, "Sheet1",i,6,act_value);
				XLUtils.setCellData(file, "Sheet1",i,7,"Failed");
				XLUtils.fillRedColor(file, "Sheet1",i,7);
			}

			
			Thread.sleep(3000);
			
			//clear all contents
			js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[contains(@class,\"PT15\")]/a[2]")));
			
			driver.quit();
			
			
		}


	}

}
