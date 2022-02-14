package ratna;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Drop_Down_Handling
{
	@Test
	public void drop_Down_Handling()
	{
		System.setProperty("webdriver.edge.driver", "C:\\Selenium\\Drivers\\new edge\\msedgedriver.exe");
		EdgeDriver driver=new EdgeDriver();
		driver.get("https://www.orangehrm.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("a.btn-orange.contact-ohrm ")).click();
		driver.findElement(By.id("Form_submitForm_subdomain")).sendKeys("https://google.com");
		driver.findElement(By.id("Form_submitForm_Name")).sendKeys("Srinivas",Keys.TAB,"addlasrinivas459@gmail.com",Keys.TAB,"9902510067");
		WebElement ele=driver.findElement(By.id("Form_submitForm_Country"));
		Select select=new Select(ele);
		select.selectByVisibleText("United Kingdom");
	}
}
