import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseEvents {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		WebElement desktop = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/a"));
		WebElement mac = driver.findElement(By.xpath("//ul[@class='list-unstyled']/li[2]/a"));
		
		Actions act = new Actions(driver);
		act.moveToElement(desktop).moveToElement(mac).build().perform();
		System.out.println("Mouse Hover Done");
		
		driver.navigate().to("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().frame("iframeResult");
		WebElement field1 = driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement field2 = driver.findElement(By.xpath("//input[@id='field2']"));
		WebElement btn = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		
		field1.clear();
		field1.sendKeys("TEXTME!!!");
		
		act.doubleClick(btn).perform();
		
		String text = field2.getAttribute("value");
		System.out.println("Text in field 2 is : "+text);
		
		driver.navigate().to("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement button = driver.findElement(By.xpath("//p/span[contains(@class,'btn')]"));
		
		act.contextClick(button).perform();
		driver.findElement(By.xpath("//span[normalize-space()='Copy']")).click(); // click on copy option
		Thread.sleep(5000);
		driver.switchTo().alert().accept(); // close alert window
		
		
		driver.navigate().to("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		WebElement min = driver.findElement(By.xpath("//span[1]"));
		System.out.println("min current location : "+min.getLocation());
		act.dragAndDropBy(min, 100, 250).perform();
		System.out.println("min updated location : "+min.getLocation());
		
		
		driver.quit();
	
		
		
	}

}
