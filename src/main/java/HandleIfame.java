import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleIfame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		
		
		driver.switchTo().frame("frm1");
  
		List <WebElement> options = driver.findElements(By.xpath("//select[@class=\"selectnav\" and @id=\"selectnav2\"][1]/option"));
  
		for(WebElement op : options){ String str = op.getText(); if
		(str.equals("Home")) { op.click(); System.out.println(str+" is clicked"); } }
		 
		driver.switchTo().defaultContent();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().frame("frm2");
		driver.findElement(By.xpath("//input[@id=\"firstName\"]")).sendKeys("TESTFA");
		driver.findElement(By.xpath("//input[@id=\"lastName\"]")).sendKeys("TESTLA");
		
		
		String gender = "F";
		if (gender.equals("F"))
		{
			driver.findElement(By.id("femalerb")).click();
		}
		else
		{
			driver.findElement(By.id("malerb")).click();
		}
		
		List <WebElement> languages = driver.findElements(By.xpath("//input[@class=\"bcCheckBox\" and @name=\"language\"]"));
		
		for(WebElement lang : languages)
		{
			String langid = lang.getDomProperty("id");
			if(langid.equals("hindichbx") || langid.equals("englishchbx") || langid.equals("latinchbx"))
			{
				lang.click();
			}
		}
	}

}
