package MCompleteSeleniumFramework.StepDefination;

import java.io.IOException;

import org.testng.Assert;

import MCompleteSeleniumFramework.PageObjects.MCartPage;
import MCompleteSeleniumFramework.PageObjects.MCheckOutPage;
import MCompleteSeleniumFramework.PageObjects.MLandingPage;
import MCompleteSeleniumFramework.PageObjects.MconfirmationPage;
import MCompleteSeleniumFramework.PageObjects.MproductCatalougePage;
import MCompleteSeleniumFramework.TestsComponents.MBaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MStepDefination extends MBaseTest {
	public MLandingPage mLandingPage;
	public MproductCatalougePage mproductcatalouge;
	public MCartPage mcartpage;
	public MCheckOutPage mcheckoutpage;
	public MconfirmationPage mconfirmationpage;
	

	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {

		mLandingPage = launchApplication();
	}

	@Given("^I logged in with username (.+) and password (.+)$")
	public void I_logged_in_with_username_and_password(String username, String password) {
		mproductcatalouge = mLandingPage.logInTheApplication(username, password);
	}

	@When("^I add the product (.+) to Cart$")
	public void I_add_the_product_to_Cart(String productName) {
		mproductcatalouge.getProductsList(productName);

	}

	@And("^Checkout product (.+) and submit the order$")
	public void Checkout_product_and_submit_the_order(String productName) throws InterruptedException {
		mcartpage = mproductcatalouge.goToCartPage();
		boolean value = mcartpage.getTheCartList(productName);
		Assert.assertTrue(value);
		mcheckoutpage = mcartpage.goToCheckOutPage();
		mcheckoutpage.select_Country("india");
		mconfirmationpage = mcheckoutpage.placeOrder();
	}

	@Then("{string} message is displayed on ConfirmationPage")
	public void message_is_displayed_on_ConfirmationPage(String string) {
		String message = mconfirmationpage.confirmationMessage();
		Assert.assertTrue(message.equalsIgnoreCase(string));
		driver.quit();

	}
	
	@Then("{string} message is displayed")
	public void message_is_displayed(String string) {
		Assert.assertEquals("Incorrect email or password.",mLandingPage.getErrorMessage() );
		driver.quit();
			}


}
