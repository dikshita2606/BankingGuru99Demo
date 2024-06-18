import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		JavascriptExecutor js = driver;
		
		//scroll down page by pixel 
		/*js.executeScript("window.scrollBy(0,3000)", "");
		System.out.println(js.executeScript("return window.pageYOffset;"));		*/
		
		//scroll till element find
		/*driver.switchTo().frame(0);
		WebElement ele = driver.findElement(By.id("FSsubmit"));
		js.executeScript("arguments[0].scrollIntoView()", ele);
		System.out.println(js.executeScript("return window.pageYOffset;"));	*/
		
		//scroll down till end of the page/document
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
				

		
		Thread.sleep(3000);
		
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");

		
	}

}
