package StepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import Utilities.OpenCloseBrowser;
import Utilities.WaitForPageLoad;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class eCommSecondScenarioStepDef extends OpenCloseBrowser {
	SoftAssert sAssert = new SoftAssert();

	@When("User CLicks On Login Link")
	public void clickOnLogin() throws Exception {
		driver.findElement(By.xpath(rc.getLoc("Account"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(rc.getLoc("Login"))).click();
		new WaitForPageLoad(driver).waitForPageLoaded();
		Reporter.log("On Login page", true);
	}

	@And("Enter Email Address and Password and click on Login button")
	public void enterLoginDetails() throws Exception {
		driver.findElement(By.xpath(rc.getLoc("email"))).sendKeys(rc.getTestData("userId"));
		Thread.sleep(1000);
		driver.findElement(By.xpath(rc.getLoc("pwd"))).sendKeys(rc.getTestData("password"));
		driver.findElement(By.xpath(rc.getLoc("LoginButton"))).click();
		new WaitForPageLoad(driver).waitForPageLoaded();
		Reporter.log("Succesfully Logged In", true);
	}

	@Then("Enter the key word in search text box and Hit Enter")
	public void enterKeySearch() throws Exception {
		driver.findElement(By.xpath(rc.getLoc("SearchArea"))).sendKeys(rc.getTestData("searchTxt"));
		Thread.sleep(1000);
		driver.findElement(By.xpath(rc.getLoc("SearchArea"))).sendKeys(Keys.ENTER);
		new WaitForPageLoad(driver).waitForPageLoaded();
		Reporter.log("On Search page", true);
	}

	@And("Select Monitors under Components in the drop down and Check Search in sub categories and click Search")
	public void selectCategories() throws Exception {
		Select category = new Select(driver.findElement(By.xpath(rc.getLoc("SelectDrpDown"))));
		category.selectByValue(rc.getTestData("MonitorsCat"));
		Thread.sleep(1000);
		driver.findElement(By.xpath(rc.getLoc("subCatCheckBox"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(rc.getLoc("searchButton"))).click();
		new WaitForPageLoad(driver).waitForPageLoaded();
		Reporter.log("On Categorised Search page", true);
	}

	@Then("Click on Phones and PDA")
	public void clickPhoneTab() throws Exception {
		driver.findElement(By.xpath(rc.getLoc("PhonePda"))).click();
		new WaitForPageLoad(driver).waitForPageLoaded();
		Reporter.log("On Phones page", true);
	}

	@And("Sort from the Price high to low on the page")
	public void selectSort() throws Exception {
		Select category = new Select(driver.findElement(By.xpath(rc.getLoc("sortSelect"))));
		category.selectByVisibleText(rc.getTestData("pricehTOl"));
		new WaitForPageLoad(driver).waitForPageLoaded();
		Reporter.log("Sorted from HtoL", true);
	}

	@Then("Click on Add to Compare for the first three phones and click on Close button")
	public void clickAddToCompare() throws Exception {
		for (int i = 1; i <= 3; i++) {
			driver.findElement(By.xpath("(" + rc.getLoc("addToCompare") + ")[" + i + "]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(rc.getLoc("closeBannerButton"))).click();
		}
		new WaitForPageLoad(driver).waitForPageLoaded();
		Reporter.log("Products Added to Compare", true);
	}
	
	@And("Click on Product Compare")
	public void clickOnCompare() throws Exception {
		driver.findElement(By.xpath(rc.getLoc("produtCompareButton"))).click();
		new WaitForPageLoad(driver).waitForPageLoaded();
		Reporter.log("On Compare Page", true);
	}
	
	@Then("Click on the first phone link on the page")
	public void clickOnFirstPhone() throws Exception {
		driver.findElement(By.xpath(rc.getLoc("FirstPhoneLink"))).click();
		new WaitForPageLoad(driver).waitForPageLoaded();
		Reporter.log("On first phone description Page", true);
	}
	
	@And("Check the fifth feature in the description section of the phone and write into flat file.")
	public void checkFithDescription() throws Exception {
		driver.findElement(By.xpath(rc.getLoc("fifthDescription"))).isDisplayed();
		System.out.println(driver.findElement(By.xpath(rc.getLoc("fifthDescription"))).getText());
		Thread.sleep(1000);
		Reporter.log("On first phone description Page", true);
	}
	
	@And("Click On the Add to cart button from PDP")
	public void clickAddToCartPDP() throws Exception {
		driver.findElement(By.xpath(rc.getLoc("AddToCartButtonFromPDP"))).click();
		Thread.sleep(4000);
		sAssert.assertTrue(driver.findElement(By.xpath(rc.getLoc("SuccessAddMsg"))).isDisplayed());
		Thread.sleep(1000);
		sAssert.assertAll();
		Reporter.log("Clicked on Add to Cart", true);
	}
	
	@Then("Click on Shopping Cart displayed on ribbon message")
	public void clickonShoppingCart() throws Exception {
		driver.findElement(By.xpath(rc.getLoc("ShoppingCart"))).click();
		new WaitForPageLoad(driver).waitForPageLoaded();
		Thread.sleep(1000);
		Reporter.log("Clicked on Add to Cart", true);
	}

}
