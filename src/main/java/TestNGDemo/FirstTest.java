package TestNGDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTest {
	
	WebDriver driver;
	
  @BeforeTest
  public void OpenUrl() {
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  System.out.println("Webdriver instance created and url is opened.");
  }
  
  @Test
  public void login() {
	  driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("Admin");
	  driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("Admin123");
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  System.out.println("Login Done sccessfully!!!");
 }
  
  @AfterTest
  public void logout() {
	  driver.quit();
	  System.out.println("Chrome closed successfully");
  }
  
  
}
