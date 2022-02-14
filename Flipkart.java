package ratna;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Flipkart
{
	@Test
	public void flip() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\\\Drivers\\\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("nokia");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		driver.findElement(By.xpath("(//a[text()='Nokia 105 SS 2021'])[1]")).click();
		String main=driver.getWindowHandle();
		Set<String> all=driver.getWindowHandles();
		for(String i:all)
		{
			if(main.equals(i))
			{
				driver.switchTo().window(i);
				//driver.close();
			}
		}
		driver.switchTo().window(main);
		Set<String> allId=driver.getWindowHandles();
		for(String s:allId)
		{
			if(!main.equals(s))
			{
				driver.switchTo().window(s);
			}
		}
		driver.findElement(By.id("pincodeInputId")).sendKeys("500027");
		driver.findElement(By.xpath("//span[text()='Check']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();	
		driver.findElement(By.xpath("//button[text()='+']")).click();
		driver.findElement(By.xpath("//div[text()='Remove']")).click();
		driver.findElement(By.xpath("(//div[text()='Remove'])[1]")).click();
}
}
