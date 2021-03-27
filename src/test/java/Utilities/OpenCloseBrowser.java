package Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenCloseBrowser {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static ReadConfig rc = new ReadConfig();
	
	public static void openChrome() {
		System.setProperty("webdriver.chrome.driver", rc.getConfigItems("driverPath"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Long.parseLong(rc.getConfigItems("implicitWait")), TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, Long.parseLong(rc.getConfigItems("explicitWait")));
	}
	
	public static void closeChrome() {
		driver.quit();
	}


}
