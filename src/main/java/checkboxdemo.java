import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class checkboxdemo {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		
		//url for check box select and operation
		driver.get("https://www.hyrtutorials.com/p/basic-controls.html");
		
		driver.manage().window().maximize();
		
	
		List <WebElement>chckbox = driver.findElements(By.xpath("//input[@class=\"bcCheckBox\" and @class=\"bcCheckBox\" and @name=\"language\"]"));
		System.out.println("checkBox with name tool are : "+chckbox.size());
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		System.out.println("Selecting checkbox all");
		for(int i=0;i<chckbox.size();i++)
		{
			if(i%2==0)
			{
				chckbox.get(i).click();	
			}
		}
		
		Thread.sleep(4000);
		System.out.println("deselecting checkboxes all"); 
		for (WebElement ele : chckbox) 
		{ 
			if(ele.isSelected())
			{
				System.out.println("Element is selected now deselect");
				ele.click(); 
			}
			else
			{
				ele.click(); 
			}
		}
		
		
	}

}
