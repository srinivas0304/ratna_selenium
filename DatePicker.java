package ratna;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import bsh.ParseException;

public class DatePicker 
{
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\Drivers\\\\new edge\\\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html?m=1");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Calendar calendar=Calendar.getInstance();
		String targetDate="01-Feb-2013";
		SimpleDateFormat targetDateFormat=new SimpleDateFormat("dd-MMM-yyyy");
		Date formattedTargetDate;
		targetDateFormat.setLenient(false);
		formattedTargetDate = targetDateFormat.parse(targetDate);
		calendar.setTime(formattedTargetDate);
		
		int targetDay=calendar.get(Calendar.DAY_OF_MONTH);
		int targetMonth=calendar.get(Calendar.MONTH);
		int targetYear=calendar.get(Calendar.YEAR);
		driver.findElement(By.id("second_date_picker")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td[not(contains(@class,'ui-datepicker-other-month '))]//a[text()="+targetDay+"]")).click();
		String actualDate=driver.findElement(By.className("ui-datepicker-title")).getText();// 
		System.out.println(formattedTargetDate);	
	}
}
