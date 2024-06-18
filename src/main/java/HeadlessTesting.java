import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessTesting {

	public static void main(String[] args) throws Throwable {
		
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--headless=new");
		
		WebDriver driver = new ChromeDriver(op);
		System.out.println("Chorme instance created successfully");
		driver.manage().window().maximize();		
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		Thread.sleep(5000);
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		System.out.println("Value set for username");
		driver.findElement(By.name("password")).sendKeys("admin123");
		System.out.println("Value set for password");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		System.out.println("Login Done");
		driver.quit();

	}

}
