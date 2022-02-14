package ratna;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Date_Picker1 
{
	static WebDriver driver;
	public static void main(String[] args)
	{
		System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\Drivers\\\\new edge\\\\msedgedriver.exe");
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html?m=1");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("second_date_picker")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-datepicker-calendar")));
		
		selectDate("1", "May", "2012");
		
	}
		public static String[] getMonthYear(String monthYear)
		{
			return monthYear.split(" ");
		}
		
		
		public static void selectDate(String day, String month,String year)
		{
			
		String monthYear=driver.findElement(By.className("ui-datepicker-title")).getText();//title of the table
		System.out.println(monthYear);//February 2022
		
		while(!(getMonthYear(monthYear)[0].equals(month) 
			  && getMonthYear(monthYear)[1].equals(year)))
		{
			
		
			driver.findElement(By.xpath("//span[text()='Prev']")).click();
			//driver.findElement(By.xpath("//span[text()='Next']")).click();//
			monthYear=driver.findElement(By.className("ui-datepicker-title")).getText();
			System.out.println(monthYear);//February 2022
		
		}
		
		driver.findElement(By.xpath("//a[text()='"+day+"']")).click();
		}
}
