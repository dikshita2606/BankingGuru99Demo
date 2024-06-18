
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleDynamicTable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/admin/index.php?route=common/login");
		
		driver.manage().window().maximize();
		
		
		driver.findElement(By.cssSelector("input#input-username")).sendKeys("demo");
		driver.findElement(By.cssSelector("input#input-password")).sendKeys("demo");
		driver.findElement(By.cssSelector("button.btn")).click();
		
		/*
		 * if (driver.findElement(By.cssSelector("button.btn-close")).isDisplayed()) 
		 * {
		 * driver.findElement(By.cssSelector("button.btn-close")).click(); }
		 *
		if(driver.findElement(By.xpath("//button[@class='btn-close']")).isDisplayed())
		{
			driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		}*/
		
		Thread.sleep(3000);
		//opening customers details
		List<WebElement> options= driver.findElements(By.xpath("//ul[@id=\"menu\"]/li"));
			
		for(int i=1;i<=options.size();i++)
		{
			String optionId = driver.findElement(By.xpath("//ul[@id=\"menu\"]/li["+i+"]")).getAttribute("id").toUpperCase();
			if(optionId.contains("CUSTOMER")) 
			{
				driver.findElement(By.xpath("//ul[@id=\"menu\"]/li["+i+"]")).click();
				driver.findElement(By.xpath("//ul[@id=\"menu\"]/li["+i+"]//ul/li["+1+"]")).click();
			}
		}		
		
		String text=driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();  //Showing 91 to 100 of 5513 (552 Pages)
		int total_pages=Integer.parseInt(text.substring(text.indexOf("(")+1,text.indexOf("Pages")-1));
		
		System.out.println("Totl Number of Pages : "+total_pages);

		for(int p=1;p<=5;p++)
		{
			if(total_pages>1)
			{
				WebElement activepage = driver.findElement(By.xpath("//ul[@class='pagination']//li//*[text()="+p+"]"));
										//driver.findElement(By.xpath("//ul[@class='pagination']//li//*[text()="+p+"]"));	

				System.out.println("Active Page : "+activepage.getText());
				activepage.click();
				Thread.sleep(2000);				
			}
			
			int total_row = driver.findElements(By.xpath("//table[contains(@class,\"table\")]//tbody//tr")).size();
			System.out.println("Total Row at page "+p+" is : "+total_row);
			
			for(int r=1;r<=total_row;r++)
			{
				String Cname = driver.findElement(By.xpath("//table[contains(@class,\"table\")]//tbody//tr["+r+"]//td[2]")).getText();
				String Cmail = driver.findElement(By.xpath("//table[contains(@class,\"table\")]//tbody//tr["+r+"]//td[3]")).getText();
				String Cgroup = driver.findElement(By.xpath("//table[contains(@class,\"table\")]//tbody//tr["+r+"]//td[4]")).getText();
				
				System.out.println("Customer Name : "+Cname);
				System.out.println("Customer Email : "+Cmail);
				System.out.println("Customer Group : "+Cgroup);
			}
			
		}
		
		
		driver.quit();
		
	}

}
