import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dropdownwithoutSelectwithCheckbox {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
		//selecting on dropdowm
		driver.findElement(By.xpath("//button[contains(@class,\"multiselect\")]")).click();
		
		//fetching all values
		List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,dropdown-menu)]//label"));
		
		System.out.println("Size of elements : "+options.size());
		for(WebElement op:options)
		{
			System.out.println(op.getText());
		}
		
		for(WebElement op:options)
		{
			String str = op.getText();
			if(str.equals("Java")|| str.equals("MySQL"))
			{
				op.click();
				System.out.println("Clicked Option : "+str);
			}
		}
		
		
		
	}
}
