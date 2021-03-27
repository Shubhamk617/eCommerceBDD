package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class WaitForPageLoad {
	public WebDriver driver = null;
	ReadConfig rc = new ReadConfig();

	public WaitForPageLoad(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(rc.getConfigItems("implicitWait")));
			wait.until(expectation);
			System.out.println("Page Loaded Succesfully");
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}
}