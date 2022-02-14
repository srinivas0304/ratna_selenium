package ratna;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseActions 
{
@Test
	
	public void mouseActions()
	{
		System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\Drivers\\\\new edge\\\\msedgedriver.exe");
		EdgeDriver driver=new EdgeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/pim/viewEmployeeList");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin", Keys.TAB, "admin123", Keys.ENTER);
		
		WebElement ele=driver.findElement(By.xpath("//b[text()='Admin']"));
		
		Actions act=new Actions(driver);
		
		act.moveToElement(ele).perform();
		
		WebElement ele1=driver.findElement(By.id("menu_admin_UserManagement"));
		
		act.moveToElement(ele1).perform();
		
		WebElement ele2=driver.findElement(By.id("menu_admin_viewSystemUsers"));
		
		act.moveToElement(ele2).click().perform();
		
		WebElement ele3=driver.findElement(By.id("searchSystemUser_userName"));
		
		act.moveToElement(ele3).sendKeys(ele3, "srinivas").perform();
		
	}
}
