package ratna;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Parallel_Execution 
{
public WebDriver driver;
	
	@Test
	@org.testng.annotations.Parameters("browsers")
	
	public void crossBrowsing(String browserName) throws Throwable
	{
		if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\Drivers\\geckodriver\\geckodriver.exe");
			driver=new FirefoxDriver();
			String s=driver.findElement(By.xpath("//h1[text()='Coronavirus Cases:']/..//div")).getText();
			System.out.println("Coronavirus Cases: "+s);
			String s1=driver.findElement(By.xpath("//h1[text()='Recovered:']/..//div")).getText();
			System.out.println("Recovered: "+s1);
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\\\\\\\Selenium\\\\\\\\Drivers\\\\\\\\chromedriver.exe");
			driver=new ChromeDriver();
			String s=driver.findElement(By.xpath("//h1[text()='Coronavirus Cases:']/..//div")).getText();
			System.out.println("Coronavirus Cases: "+s);
			String s1=driver.findElement(By.xpath("//h1[text()='Recovered:']/..//div")).getText();
			System.out.println("Recovered: "+s1);
		}
		
		else if(browserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Selenium\\Drivers\\new edge\\msedgedriver.exe");
			driver=new EdgeDriver();
			String s=driver.findElement(By.xpath("//h1[text()='Coronavirus Cases:']/..//div")).getText();
			System.out.println("Coronavirus Cases: "+s);
			String s1=driver.findElement(By.xpath("//h1[text()='Recovered:']/..//div")).getText();
			System.out.println("Recovered: "+s1);
		}
		driver.get("https://www.worldometers.info/coronavirus");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}
}
