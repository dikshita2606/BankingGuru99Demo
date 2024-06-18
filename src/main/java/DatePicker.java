import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/datepicker/");
		
		Thread.sleep(5000);
		
		//Approach1: send directly dates 
		/*
		 * driver.switchTo().frame(0);		
		 * driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("10/12/2024");
		 */
		
		//Approach 2
		String year = "2024";
		String month ="November";
		String date = "25";
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		//select month and year
		while(true)
		{
			String ActualMonth = driver.findElement(By.xpath("//span[contains(@class,'ui-datepicker-month')]")).getText();
			String ActualYear = driver.findElement(By.xpath("//span[contains(@class,'ui-datepicker-year')]")).getText();
			
			if(ActualMonth.equals(month) && ActualYear.equals(year))
			{
				System.out.println("Month : "+month+" Year : "+year);
				break;
			}
			
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		
		
		//select date 
		List<WebElement> alldates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		for(WebElement dt : alldates)
		{
			if(date.equals(dt.getText()))
			{
				dt.click();
				System.out.println("Date Selected : "+dt.getText());
				break;
			}
		}
		
		
		 

	}

}
