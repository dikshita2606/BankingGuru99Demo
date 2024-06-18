import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowHandles {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
			
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		if (driver.findElement(By.xpath("//img[@alt=\"company-branding\"]")).isDisplayed() == true)
		{
			System.out.println(driver.getTitle()+" is loaded successfully!!!");
		}
		
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
		
		driver.findElement(By.partialLinkText("OrangeHRM")).click();
		
		Set<String> windowIds = driver.getWindowHandles();  //captures window ids in set data type
		
		List<String> WId = new ArrayList<String>(windowIds); //converting Set to List data type in order to fetch the details 
		
		//fetching parnt and child window id 
		String parentWId = WId.get(0);  
		String childWId = WId.get(1);
		
		//Switch to child Window 
		driver.switchTo().window(childWId);
		
		if (driver.findElement(By.xpath("//img[contains(@alt,\"OrangeHRM\")]")).isDisplayed() == true)
		{
			System.out.println("In Child window");
			driver.findElement(By.partialLinkText("Contact")).click();
		}
		
		System.out.println("Switching back to parent window");
		driver.switchTo().window(parentWId);
		
		if (driver.findElement(By.xpath("//img[@alt=\"company-branding\"]")).isDisplayed() == true)
		{
			System.out.println(driver.getTitle()+" is loaded successfully!!!");
		}

		
		driver.close();
		driver.quit();
	}

}
