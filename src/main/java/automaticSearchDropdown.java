import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class automaticSearchDropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.co.in/");

		//enter into search box
		driver.findElement(By.xpath("//div[@class=\"a4bIc\"]//textarea")).sendKeys("Selenium");
		
		Thread.sleep(3000);
		
		//getting available values
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class=\"G43f7e\"]/li"));
		
		System.out.println("Options Availble are : "+options.size());
		for(WebElement op:options)
		{
			System.out.println(op.getText());
		}
		
		Thread.sleep(5000);
		for(int i =0;i<options.size();i++)
		{
			if(i==3)
			{
				options.get(i).click();
				break;
			}
		}
	}

}
