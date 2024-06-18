import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dynamictable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		
		
		int total_pages =4;
		System.out.println("Totl Number of Pages : "+total_pages);

		for(int p=1;p<=4;p++)
		{
			if(total_pages>=1)
			{
				WebElement activepage = driver.findElement(By.xpath("//ul[contains(@id,'pagination')]//li["+p+"]"));						
				System.out.println("Active Page : "+activepage.getText());
				activepage.click();
				Thread.sleep(2000);				
			}
			
			int total_row = driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr")).size();
			System.out.println("Total Row at page "+p+" is : "+total_row);
			
			for(int r=1;r<=total_row;r++)
			{
				String Id = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td[2]")).getText();
				String Name = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td[2]")).getText();
				String Price = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td[3]")).getText();
				

				System.out.println(" ID : "+Id);
				System.out.println(" Name : "+Name);
				System.out.println(" Price : "+Price);
				System.out.println("========================================");
				if(Name.contains("14") || Id.contains("9") || Price.contains("10.99"))
				{
					driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td//following-sibling::td//input")).click();
					System.out.println("Clicked!!!! now moving to next Page");
					//break;
				}
			}
			
		}
		
		
		//driver.quit();
	}

}
