package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	public static WebDriver driver;

	public static WebDriver getDriver() {

//		System.setProperty("webdriver.chrome.driver",
//				"C:/Users/noyan.ahmet/Documents/SeleniumTools/ChromeDriver/chromedriver-win64/chromedriver.exe");

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/ahmtn/OneDrive/" + "Documents/Selenium Tools/chromedriver-win64/chromedriver.exe");

		if (driver == null) {
			driver = new ChromeDriver();

		}

		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}

	}
}
