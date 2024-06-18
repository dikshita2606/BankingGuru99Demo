import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrokenLinks {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//fetching all a tags
		List<WebElement> allList = driver.findElements(By.tagName("a"));
		System.out.println("Total Links are : "+allList.size());
		
		int brokenLink = 0;
		
		for (WebElement link : allList)
		{
			String hrefValue = link.getAttribute("href");
			if(hrefValue==null || hrefValue.isEmpty())
			{
				System.out.println("href value is empty");
				continue;
			}
			
			//Checking link is broken or not 
			URL actualURL=new URL(hrefValue); 
			
			HttpURLConnection conn = (HttpURLConnection) actualURL.openConnection(); ////send request to server - open , connect
			conn.connect();
			
			if(conn.getResponseCode()>=400)
			{
				System.out.println(hrefValue+"     "+"====> Broken Link");
				brokenLink++;
			}
			else
			{
				System.out.println(hrefValue+"     "+"====> Not Broken Link");
			}
			
		}
		
		System.out.println("total number of broken links:"+brokenLink);

	}

}
