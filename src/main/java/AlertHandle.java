import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHandle {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));

		//driver.findElement(By.xpath("//button[contains(text(),'Alert')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
		
		//Alert normalAlert = driver.switchTo().alert();
		Alert normalAlert = mywait.until(ExpectedConditions.alertIsPresent());
		System.out.println("Alert Text : "+normalAlert.getText());
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Accepting Alert");
		normalAlert.accept();

		driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
		
		//Alert normalAlert = driver.switchTo().alert();
		normalAlert = mywait.until(ExpectedConditions.alertIsPresent());
		System.out.println("Alert Text : "+normalAlert.getText());
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Declining Alert");
		normalAlert.dismiss();
			
	}
}
