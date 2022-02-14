package ratna;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class NaukriWindow
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\Drivers\\\\new edge\\\\msedgedriver.exe");
		
		EdgeDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		WebElement ele=driver.findElement(By.xpath("//div[text()='Services']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).clickAndHold().perform();
		driver.findElement(By.xpath("//div[text()='Services']/../..//ul[3]//li[2]")).click();
		
		String mainId=driver.getWindowHandle();
		Set<String> allId=driver.getWindowHandles();
		
		for(String i:allId)
		{
			if(!mainId.equals(i))
			{
				driver.switchTo().window(i);
				//driver.close();
			}
		}
		driver.switchTo().window(mainId);
		Set<String> child=driver.getWindowHandles();
		for(String s1:child)
		{
			driver.switchTo().window(s1);
		}
	
		String s=driver.findElement(By.xpath("//h1[@class='heading']/..//div[2]")).getText();
		System.out.println(s);
	}
}
