import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdownwithSelect {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		driver.manage().window().maximize();
		WebElement dropdownele = driver.findElement(By.cssSelector("select#course"));
		
		Select dropdownvlues = new Select(dropdownele);
		//selection option from dropdown
		//dropdownvlues.selectByVisibleText("Dot Net");
		//dropdownvlues.selectByValue("net");
		dropdownvlues.selectByIndex(3);

	}

}
