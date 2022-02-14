package ratna;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class KeysClass 
{
	@Test
	public void keysClass() throws InterruptedException
	{
		System.setProperty("webdriver.edge.driver", "C:\\Selenium\\Drivers\\new edge\\msedgedriver.exe");
		EdgeDriver driver=new EdgeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement ele=driver.findElement(By.name("q"));
		ele.sendKeys("Rohit Sharma");
		ele.submit();
		Thread.sleep(1000);
		driver.findElement(By.id("gsr")).sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN);
	}
}
