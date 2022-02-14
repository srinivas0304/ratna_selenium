package ratna;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DatePicker_Jquery 
{
	static WebDriver driver;
	@Test
	public void calendar() throws Exception
	{
		System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\Drivers\\\\new edge\\\\msedgedriver.exe");
	    driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/datepicker/");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(1000);
		WebElement ele = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(ele);
		Thread.sleep(1000);
		driver.findElement(By.id("datepicker")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-datepicker-calendar")));
		
		selectDate("1", "Feb", "2023");
		
	}
	
	public static String[] getMonthYear(String monthYear)
	{
		return monthYear.split(" ");
	}
	
	public static void selectDate(String day, String month, String year) throws Exception
	{
		String monthYear = driver.findElement(By.className("ui-datepicker-title")).getText();
		System.out.println(monthYear);
		
		
		while(!(getMonthYear(monthYear)[0].equals(month)
			&& (getMonthYear(monthYear)[1].equals(year))))
			
			{
				  
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				
				monthYear=driver.findElement(By.className("ui-datepicker-title")).getText();
				System.out.println(monthYear);
			}			
		
		driver.findElement(By.xpath("//a[text()='"+day+"']")).click();
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./Screenshots/DatePicker.jpg"));
		System.out.println("screenshot taken successfully");
	}
}
