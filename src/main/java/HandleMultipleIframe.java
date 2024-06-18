import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleMultipleIframe {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://ui.vision/demo/webtest/frames/");
		
		WebElement frm =  driver.findElement(By.xpath("//frame[@src=\"frame_3.html\"]"));
		driver.switchTo().frame(frm);
		
		driver.findElement(By.xpath("//input[@name=\"mytext3\"]")).sendKeys("TESTFA TESTLA");
		
		WebElement innerfrm = driver.findElement(By.xpath("//iframe[contains(@src,\"https://docs.google\")]"));
		
		driver.switchTo().frame(innerfrm);
		
		List<WebElement> options = driver.findElements(By.xpath("//div[@class=\"SG0AAe\"]/div[contains(@class,\" zwllIb\")]"));
		for(WebElement op:options)
		{
			//System.out.println("Getting Text : "+op.getText());
			if(op.getText().contains("human"))
			{
				op.click();
			}
		}
		
		
		driver.switchTo().defaultContent();
		
		WebElement frm2 =  driver.findElement(By.xpath("//frame[@src=\"frame_1.html\"]"));
		driver.switchTo().frame(frm2);
		
		driver.findElement(By.xpath("//input[@name=\"mytext1\"]")).sendKeys("TESTFA2 TESTLA2");

		

	}

}
