package TestNGDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class DataProviderDemo {

	WebDriver driver;
	
	@BeforeClass
	void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider = "dp")
	void loginCheck(String email, String pwd) {
		driver.get("https://demo.nopcommerce.com/login");
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[contains(@class,\"login-button\")]")).click();
		
		String exp_title = "nopCommerce demo store";
		String act_title = driver.getTitle();

		Assert.assertEquals(exp_title, act_title);
	}
	
	
	@AfterTest
	void tearDown() {
		driver.close();
	}
	
	@DataProvider(name="dp", indices = {1,3,5})
	String [][] loginData()
	{
		String data[][]= {  
							{ "abc@gmail.com", "test123" }, 
							{ "pavanol@gmail.com", "test@123" },
							{ "pavanoltraining@gmail.com", "test3" },
							{ "pavanoltraining@gmail.com", "test@123" },
							{ "pavanoltraining@gmail.com", "test@123" },
							{ "TEST@GMAIL.COM", "TEST123"},
							{ "TEST@GMAIL.COM", "TEST123"} /*Id Pass created by me*/
						};
		
		return data;
	}

}
