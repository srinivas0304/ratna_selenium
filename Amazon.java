package ratna;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import io.netty.handler.codec.http.multipart.FileUpload;
public class Amazon 
{
		public static void main(String[] args) throws IOException
		{
			 	System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\\\Drivers\\\\chromedriver.exe");
				ChromeDriver driver=new ChromeDriver();
				driver.get("https://www.amazon.in/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nokia");
				driver.findElement(By.cssSelector("input[type='submit']")).click();
				List<WebElement> ele=driver.findElements(By.xpath("//span[contains(text(),'Nokia')]"));
				List<WebElement> ele1=driver.findElements(By.xpath("//span[contains(text(),'Nokia')]/../../../..//div//div//div//div//div//a"));
				/*
				 * int count=0; 
				 * List<WebElement> ele=driver.findElements(By.xpath("//span[contains(text(),'Nokia')]/../../../..//div//div//div//div//div//a"));
				 * for(WebElement i:ele)
				 * { 
				 * System.out.println(i.getText()); 
				 * count++; 
				 * }
				 * System.out.println("Number of items: "+count);
				 */
				
				for(int i=0;i<ele.size();i++)
				{
					System.out.println(ele.get(i).getText()+": "+ele1.get(i).getText());
				}
				//System.out.println(ele.getText()+": "+ele1.getText());
				
				TakesScreenshot ts=((TakesScreenshot)driver);
				File src=ts.getScreenshotAs(OutputType.FILE);
				File des=new File("C:\\Users\\addla\\ratnaglobal\\Selenium\\screenshot.jpg");
				Files.copy(src, des);
				
		}
}

