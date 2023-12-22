package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
public static WebDriver driver;
	
	public static WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/noyan.ahmet/Documents/SeleniumTools/ChromeDriver/chromedriver-win64/chromedriver.exe");
		if(driver==null) {
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		
		
		return driver;
	}
	
	public static void quitDriver() {
		if(driver !=null) {
			driver.quit();
			driver=null; 
		}
		
	}
}
