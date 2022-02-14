package ratna;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class MakeMyTrip 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\Drivers\\\\new edge\\\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("(//div[@class='landingContainer'])[1]")).click();
		
		driver.findElement(By.cssSelector("div.fsw_inputBox.dates.inactiveWidget.activeWidget")).click();
	}
}
