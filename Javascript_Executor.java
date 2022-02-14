package ratna;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Javascript_Executor 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.edge.driver", "C:\\Selenium\\Drivers\\new edge\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		//driver.get("https://www.google.com/");
		driver.get("https://demo.actitime.com/login.do");
		//driver.get("https://login.yahoo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.findElement(By.id("username")).sendKeys("admin",Keys.TAB,"manager");
		//driver.findElement(By.xpath("//input[@id='keepLoggedInCheckBox']")).click();
		
		//driver.findElement(By.id("login-username")).sendKeys("admin@yahoo.com");
		//driver.findElement(By.cssSelector("label[for='persistent']")).click();
		//driver.findElement(By.xpath("//label[text()='Stay signed in']")).click();
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("document.getElementById('persistent').click()");//this one method to click
		
		//WebElement ele=driver.findElement(By.xpath("//label[text()='Stay signed in']"));
		//js.executeScript("arguments[0].click()", ele);//this is the second method to click using JavascriptExecutor
		
		//js.executeScript("alert('WelCome to Google')");
		
		//js.executeScript("confirm('Are you sure')");
		
		//js.executeScript("prompt('please enter your name')");
		//Thread.sleep(3000);
		WebElement username=driver.findElement(By.id("username"));
		js.executeScript("arguments[0].value='admin'", username);
		
		WebElement password=driver.findElement(By.name("pwd"));
		js.executeScript("arguments[0].value='manager'", password);
		
		WebElement loginClick=driver.findElement(By.xpath("//div[text()='Login ']"));
		js.executeScript("arguments[0].click()",loginClick);
		
		
	}
}
