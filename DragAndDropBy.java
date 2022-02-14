package ratna;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDropBy 
{
	@Test
	public void radioButton() throws InterruptedException
	{
		System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\Drivers\\\\new edge\\\\msedgedriver.exe");
		EdgeDriver driver=new EdgeDriver();
		driver.get("http://www.flipkart.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		WebElement ele=driver.findElement(By.name("q"));
		ele.sendKeys("mobiles",Keys.ENTER);
		//driver.findElement(By.cssSelector("button[type='submit']")).click();
		driver.findElement(By.xpath("//div[text()='RAM']/../..//div[3]")).click();
		WebElement drag=driver.findElement(By.xpath("(//div[@class='_3FdLqY'])[1]"));
		Actions act=new Actions(driver);
		Thread.sleep(1000);
		act.dragAndDropBy(drag, 40, 0).perform();
		Thread.sleep(1000);
		WebElement drop=driver.findElement(By.xpath("(//div[@class='_3FdLqY'])[2]"));
		act.dragAndDropBy(drop, -20, 0).perform();
		
		
	}
}
