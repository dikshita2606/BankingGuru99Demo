import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureScreenshot {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();		
		driver.get("https://demo.nopcommerce.com/");
		
		//capture full page screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String date = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
		File target = new File("D:/eclipse/eclipse/eclipse-workspace/selenium/BankingAutomation_v1/Screenshots/"+date+".png");
		
		FileHandler.copy(src,target);
		System.out.println("ScreenShot taken");	
		
		
		//Caputre of specific area
		File srcSpecificEle = driver.findElement(By.xpath("//div[@class=\"product-grid home-page-product-grid\"]")).getScreenshotAs(OutputType.FILE);
		target = new File("D:/eclipse/eclipse/eclipse-workspace/selenium/BankingAutomation_v1/Screenshots/"+date+".png");
		
		FileHandler.copy(srcSpecificEle,target);
		System.out.println("ScreenShot taken for specific element");	
	}

}
