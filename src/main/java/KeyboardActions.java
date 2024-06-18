import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("textarea#inputText1")).sendKeys("Checking KeyBoard Actions");
		Actions act = new Actions(driver);
		
		//performing Ctrl+A		
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		
		//performing Ctrl+C
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		
		//performing Tab
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		//act.sendKeys(Keys.CONTROL).perform();
		
		//performing Ctrl=V
		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		
		driver.findElement(By.cssSelector("button#compareButton")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String msg = driver.findElement(By.cssSelector("span.messageForUser")).getText();
		
		if(msg.contains("identical!"))
		{
			System.out.println("Msg printed is : "+msg);
		}
		
		
		
		
	}

}
