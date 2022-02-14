package ratna;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowsing 
{
	public WebDriver driver;
    
    //Expected header value
    //public String headerValue = "Applied Selenium";
   
    @Test
    @Parameters("browser")
    
    //The @Test method should accept a String variable
    public void crossBros(String browserName) {
        
        //check for the browser value and invoke the called browser
        if (browserName.equalsIgnoreCase("chrome")) 
        {
        	System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\Drivers\\geckodriver\\geckodriver.exe");
			driver=new FirefoxDriver();
			String s=driver.findElement(By.xpath("//h1[text()='Coronavirus Cases:']/..//div")).getText();
			System.out.println("Coronavirus Cases: "+s);
			String s1=driver.findElement(By.xpath("//h1[text()='Recovered:']/..//div")).getText();
			System.out.println("Recovered: "+s1);
        }
        else if(browserName.equalsIgnoreCase("firefox")) 
        {
        	System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\Drivers\\geckodriver\\geckodriver.exe");
			driver=new FirefoxDriver();
			String s=driver.findElement(By.xpath("//h1[text()='Coronavirus Cases:']/..//div")).getText();
			System.out.println("Coronavirus Cases: "+s);
			String s1=driver.findElement(By.xpath("//h1[text()='Recovered:']/..//div")).getText();
			System.out.println("Recovered: "+s1);
        }
        
        //print which browser is started
       
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.worldometers.info/coronavirus");
        
        
        driver.quit();
        
    }
}
