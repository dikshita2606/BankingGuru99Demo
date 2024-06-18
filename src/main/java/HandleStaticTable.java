import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleStaticTable {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		
		//Find total number of rows
		List<WebElement> rows = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//tr"));
		int row = rows.size();
		System.out.println("Number of rows are : "+row);
		System.out.println("Using tag Name = "+driver.findElements(By.tagName("tr")).size());
		
		//find total number of columns
		int cols = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//tr//th")).size();
		System.out.println("Column Numbers are : "+cols);
		
		//read each row and column value
		for(int r=2;r<=row;r++)
		{
			for(int c=1;c<=cols;c++)
			{
				String value = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(value+"\t");
			}
			System.out.println("");
		}
		
		
		System.out.println("=================================================");
		
		//print books name whose author is Amit
		for(int r=2;r<=row;r++)
		{
			String author = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+r+"]//td[2]")).getText();
			//driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+r+"]//td["+c+"]//following-sibling::td[1]")).getText();
			if(author.contains("Amit"))
			{
				System.out.println("Book whose author is Amit is :"+driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+r+"]//td[1]")).getText());
			}
		}
		
		System.out.println("=================================================");
		
		//find the sum of all the prices of the books
		int ans = 0;
		
		for(int r=2;r<=row;r++)
		{
			String price = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+r+"]//td[4]")).getText();
			//driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+r+"]//td["+c+"]//following-sibling::td[1]")).getText();
			ans = ans+Integer.parseInt(price);
		}
		
		System.out.println("Sum of all prices of books are "+ans);
		
		
		
		
		
		
		
		driver.quit();
	}

}
