package ratna;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ControlShift 
{
	@Test
	public void control_Shift()
	{
		System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\Drivers\\\\new edge\\\\msedgedriver.exe");
		EdgeDriver driver=new EdgeDriver();
		driver.get("https://demoqa.com/text-box");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		/*
		 * WebElement ele=driver.findElement(By.id("details-button")); ele.click();
		 */
		//ele.sendKeys(Keys.TAB,Keys.ENTER);
		//driver.findElement(By.id("proceed-link")).click();
		WebElement username=driver.findElement(By.id("userName"));
		username.sendKeys("A Srinivas",Keys.TAB,"addlasrinivass@gmail.com",Keys.TAB);
		WebElement currentAddress=driver.findElement(By.id("currentAddress"));
		currentAddress.sendKeys("Barkatpura, Kachiguda, Hyderabad");
		//selecting address
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.build().perform();
		//copying address
		act.keyDown(Keys.CONTROL);
		act.sendKeys("c");
		act.keyUp(Keys.CONTROL);
		act.build().perform();
		//tab to enter next section
		act.sendKeys(Keys.TAB);
		act.build().perform();
		//past the address
		act.keyDown(Keys.CONTROL);
		act.sendKeys("v");
		act.keyUp(Keys.CONTROL);
		act.build().perform();
	}
}
