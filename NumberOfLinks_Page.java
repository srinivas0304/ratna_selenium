package ratna;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberOfLinks_Page
{
	@Test
	public void linksTitle()
	{
		System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\Drivers\\\\new edge\\\\msedgedriver.exe");
		EdgeDriver driver=new EdgeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		int count =0;
		for(WebElement s:links)
		{
			count++;
		}
		
		System.out.println("The total number of links present in the page: "+count);
		
		driver.findElement(By.xpath("//div[text()='Jobs']")).click();
		
		String mainId=driver.getWindowHandle();
		Set<String> allId=driver.getWindowHandles();
		
		for(String i:allId)
		{
			if(!mainId.equals(i))
			{
				driver.switchTo().window(i);
			}
		}		
		String actual=driver.getTitle();
		
		System.out.println(actual);
		
		String expected="Browse Jobs by Company, Location, Skills, Designation & Industry - Naukri.com";
		
		Assert.assertEquals(actual, expected);
		
		System.out.println("test completed");	
	}
}
