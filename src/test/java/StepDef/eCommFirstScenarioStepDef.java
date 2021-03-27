package StepDef;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import Utilities.OpenCloseBrowser;
import Utilities.WaitForPageLoad;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class eCommFirstScenarioStepDef extends OpenCloseBrowser {

	SoftAssert sAssert = new SoftAssert();

	@Given("ecommerce Website is launched Successfully")
	public void launchWebsite() {
		driver.navigate().to(rc.getURL("webUrlL"));
	}

	@Then("wait for pageLoad and verify the application loaded")
	public void waitForLoad() {
		new WaitForPageLoad(driver).waitForPageLoaded();
		wait.until(ExpectedConditions.titleContains("Your Store"));
		Reporter.log("Homepage Lodaed Successfully", true);
	}

	@Given("User is on Homepage")
	public void userOnHomepage() {
		sAssert.assertTrue(driver.findElement(By.xpath(rc.getLoc("slideshow"))).isDisplayed());
		sAssert.assertTrue(driver.findElement(By.xpath(rc.getLoc("carausel"))).isDisplayed());
		sAssert.assertAll();
	}

	@Given("User clicks on Create an account link")
	public void clickOnRegister() throws Exception {
		driver.findElement(By.xpath(rc.getLoc("Account"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(rc.getLoc("Register"))).click();
		new WaitForPageLoad(driver).waitForPageLoaded();
		Reporter.log("On Registration page", true);
	}

	@Given("Fill in the Details of the page click on Continue")
	public void fillTheForm() throws Exception {
		driver.findElement(By.xpath(rc.getLoc("fname"))).sendKeys(rc.getTestData("fname"));
		driver.findElement(By.xpath(rc.getLoc("lname"))).sendKeys(rc.getTestData("lname"));
		driver.findElement(By.xpath(rc.getLoc("email")))
				.sendKeys(rc.getTestData("email") + new Random().nextInt() + rc.getTestData("emailDomain"));
		driver.findElement(By.xpath(rc.getLoc("tel"))).sendKeys(rc.getTestData("tel"));
		driver.findElement(By.xpath(rc.getLoc("pwd"))).sendKeys(rc.getTestData("pwd"));
		driver.findElement(By.xpath(rc.getLoc("pwdcnf"))).sendKeys(rc.getTestData("pwdcnf"));
		Thread.sleep(2000);
		if (rc.getTestData("subscribe").equalsIgnoreCase("yes")) {
			driver.findElement(By.xpath(rc.getLoc("subscribeYes"))).click();
		} else if (rc.getTestData("subscribe").equalsIgnoreCase("no")) {
			driver.findElement(By.xpath(rc.getLoc("subscribeNo"))).click();
		}
		driver.findElement(By.xpath(rc.getLoc("privacyPolicy"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(rc.getLoc("continue"))).click();
		new WaitForPageLoad(driver).waitForPageLoaded();
		Reporter.log("Form Filled", true);
	}

	@Then("Click on Contact link")
	public void clickOnContactUs() throws Exception {
		driver.findElement(By.xpath(rc.getLoc("contactLink"))).click();
		new WaitForPageLoad(driver).waitForPageLoaded();
		Reporter.log("On Contact Us", true);
	}

	@And("Type the Enquiry in Enquiry Box")
	public void enterEnquiry() throws Exception {
		driver.findElement(By.xpath(rc.getLoc("enquiryBox"))).sendKeys(rc.getTestData("enquiryText"));
		Thread.sleep(2000);
		Reporter.log("Entered the enquiry", true);
	}

	@And("Click on Submit and Continue")
	public void ClickOnSubmitAndContinueToHomepage() throws Exception {
		driver.findElement(By.xpath(rc.getLoc("submit"))).click();
		new WaitForPageLoad(driver).waitForPageLoaded();
		driver.findElement(By.xpath(rc.getLoc("continueOnContactPage"))).click();
		new WaitForPageLoad(driver).waitForPageLoaded();
		Reporter.log("On Homepage Now", true);
	}

	@When("User Click on Samsung Tab Image")
	public void ClickOnSamsunTabImage() throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(rc.getLoc("samsungTabImage"))));
		driver.findElement(By.xpath(rc.getLoc("samsungTabImage"))).click();
		new WaitForPageLoad(driver).waitForPageLoaded();
		Reporter.log("On samsungTabImage page Now", true);
	}

	@And("Click on Review Tab")
	public void ClickOnReviewTab() throws Exception {
		driver.findElement(By.xpath(rc.getLoc("reviewsTab"))).click();
		Thread.sleep(2000);
		Reporter.log("Reviews Tab open Now", true);
	}

	@And("^Fill in details for Review with rating (.*)$")
	public void fillReviewDetails(int rating) throws Exception {
		driver.findElement(By.xpath(rc.getLoc("reviewsTab"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(rc.getLoc("name"))).clear();
		driver.findElement(By.xpath(rc.getLoc("name"))).sendKeys(rc.getTestData("name"));
		driver.findElement(By.xpath(rc.getLoc("reviewBox"))).sendKeys(rc.getTestData("reviewText"));
		Thread.sleep(2000);
		if (rating == 1)
			driver.findElement(By.xpath(rc.getLoc("rating1"))).click();
		else if (rating == 2)
			driver.findElement(By.xpath(rc.getLoc("rating2"))).click();
		else if (rating == 3)
			driver.findElement(By.xpath(rc.getLoc("rating3"))).click();
		else if (rating == 4)
			driver.findElement(By.xpath(rc.getLoc("rating4"))).click();
		else if (rating == 5)
			driver.findElement(By.xpath(rc.getLoc("rating5"))).click();
		Thread.sleep(2000);
		Reporter.log("Reviews Filled Now", true);
	}

	@And("Click on Continue")
	public void ClickOnContinieRevs() throws Exception {
		driver.findElement(By.xpath(rc.getLoc("continueRev"))).click();
		Thread.sleep(2000);
		sAssert.assertTrue(driver.findElement(By.xpath(rc.getLoc("revSuccessfull"))).isDisplayed());
		sAssert.assertAll();
		Reporter.log("Reviews Submitted", true);
	}

	@And("Click on add to wishlist")
	public void ClickOnAddtoWishlist() throws Exception {
		driver.findElement(By.xpath(rc.getLoc("addToWishlist"))).click();
		Thread.sleep(2000);
		sAssert.assertTrue(driver.findElement(By.xpath(rc.getLoc("closeBannerButton"))).isDisplayed());
		sAssert.assertAll();
		Reporter.log("Added to wishlist", true);
	}

	@And("Close the success ribbon message on the page.")
	public void closeSuccessButton() throws Exception {
		driver.findElement(By.xpath(rc.getLoc("closeBannerButton"))).click();
		Thread.sleep(2000);
		Reporter.log("wishlist banner closed", true);
	}

	@And("Click on Wishlist link.")
	public void clickWishlistLink() throws Exception {
		driver.findElement(By.xpath(rc.getLoc("wishlistLink"))).click();
		new WaitForPageLoad(driver).waitForPageLoaded();
		Reporter.log("clcked to wishlist link", true);
	}

	@And("Click on Pound Sterling")
	public void clickonPoundSterling() throws Exception {
		driver.findElement(By.xpath(rc.getLoc("currency"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(rc.getLoc("pound"))).click();
		new WaitForPageLoad(driver).waitForPageLoaded();
		Reporter.log("clcked on pound", true);
	}

	@And("Retrieve the value and display Pound value.")
	public void displayPoundVals() throws Exception {
		System.out.println(driver.findElement(By.xpath(rc.getLoc("price"))).getText());
		Thread.sleep(1000);
		Reporter.log("Pound Val Displayed on console");
	}

	@And("Click on Euro Sterling")
	public void clickonEuro() throws Exception {
		driver.findElement(By.xpath(rc.getLoc("currency"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(rc.getLoc("Euro"))).click();
		new WaitForPageLoad(driver).waitForPageLoaded();
		Reporter.log("clcked on Euro", true);
	}

	@And("Retrieve the value and display Euro value.")
	public void displayEuroVals() throws Exception {
		System.out.println(driver.findElement(By.xpath(rc.getLoc("price"))).getText());
		Thread.sleep(1000);
		Reporter.log("Euro Val Displayed on console");
	}

	@And("Click on US Dollar Sterling")
	public void clickonDollarSterling() throws Exception {
		driver.findElement(By.xpath(rc.getLoc("currency"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(rc.getLoc("dollar"))).click();
		new WaitForPageLoad(driver).waitForPageLoaded();
		Reporter.log("clcked on pound", true);
	}

	@And("Retrieve the value and display US Dollar value.")
	public void displayDollarVals() throws Exception {
		System.out.println(driver.findElement(By.xpath(rc.getLoc("price"))).getText());
		Thread.sleep(1000);
		Reporter.log("Dollar Val Displayed on console");
	}

	@And("Click on Add To Cart icon")
	public void AddToCart() throws Exception {
		driver.findElement(By.xpath(rc.getLoc("addToCartButton"))).click();
		Thread.sleep(2000);
		sAssert.assertTrue(driver.findElement(By.xpath(rc.getLoc("closeBannerButton"))).isDisplayed());
		sAssert.assertAll();
		Reporter.log("Clicked on Add to Cart");
	}

	@And("Close the success message on the page.")
	public void closeSuccessMsg() throws Exception {
		driver.findElement(By.xpath(rc.getLoc("closeBannerButton"))).click();
		Thread.sleep(2000);
		Reporter.log("wishlist banner closed", true);
	}

	@And("Click Remove icon on the product in My Wishlist page.")
	public void removeFromWishlist() throws Exception {
		driver.findElement(By.xpath(rc.getLoc("removeFromWishList"))).click();
		Thread.sleep(2000);
		sAssert.assertTrue(driver.findElement(By.xpath(rc.getLoc("closeBannerButton"))).isDisplayed());
		sAssert.assertAll();
		Reporter.log("Removed From Wishlist", true);
	}

	@And("Click on continue from wishlist page.")
	public void continueFromWishlist() throws Exception {
		driver.findElement(By.xpath(rc.getLoc("ContinuefromWishlist"))).click();
		new WaitForPageLoad(driver).waitForPageLoaded();
		Reporter.log("Continued From Wishlist", true);
	}

	@Then("Click on Logout.")
	public void logOut() throws Exception {
		driver.findElement(By.xpath(rc.getLoc("MyAccount"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(rc.getLoc("logOut"))).click();
		new WaitForPageLoad(driver).waitForPageLoaded();
		Reporter.log("Continued From Wishlist", true);
	}
	
}
