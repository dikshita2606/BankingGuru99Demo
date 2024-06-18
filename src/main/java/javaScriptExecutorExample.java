import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class javaScriptExecutorExample {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		//ChromeDriver driver = new ChromeDriver();

		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		//driver.switchTo().frame(0);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		//JavascriptExecutor js = driver;

		WebElement name = driver.findElement(By.id("name"));
		js.executeScript("arguments[0].setAttribute('value','john')",name);

		WebElement male = driver.findElement(By.id("male"));
		js.executeScript("arguments[0].click();",male);
		
		WebElement sun = driver.findElement(By.id("sunday"));
		js.executeScript("arguments[0].click();",sun);
		


	}
}
