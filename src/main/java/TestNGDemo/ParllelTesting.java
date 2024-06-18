package TestNGDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ParllelTesting {

	WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser"})
	void setUp(String br) throws InterruptedException {
		if(br.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			driver = new InternetExplorerDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
	}
	
	@Test(priority = 1)
	void testLogo() {
		
		try 
		{
			boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
			Assert.assertEquals(status, true);
		} 
		catch (Exception e) 
		{
			Assert.fail(); 
		}
		
	}
	
	@Test(priority = 2)
	void testHomePage() {
		Assert.assertEquals(driver.getTitle(),"OrangeHRM","Titles are bot matched..");
	}
	
	@AfterClass
	void closeApp(){
		driver.close();
	}
	
	
}
