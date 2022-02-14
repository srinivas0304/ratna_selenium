package ratna;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Drag_Drop 
{
	@Test
	public void dragAndDrop() throws InterruptedException
	{
		System.setProperty("webdriver.edge.driver", "C:\\Selenium\\Drivers\\new edge\\msedgedriver.exe");
		EdgeDriver driver=new EdgeDriver();
		driver.get("https://demoqa.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		Thread.sleep(1000);
		WebElement drag=driver.findElement(By.id("draggable"));
		Thread.sleep(1000);
		WebElement drop=driver.findElement(By.id("droppable"));
		act.dragAndDrop(drag, drop).build().perform();
	}
}
