package MCompleteSeleniumFramework.Tests;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import MCompleteSeleniumFramework.PageObjects.MCartPage;
import MCompleteSeleniumFramework.PageObjects.MproductCatalougePage;
import MCompleteSeleniumFramework.TestsComponents.MBaseTest;

public class MErrorValidationsTest extends MBaseTest {

	@Test(groups = {"ErrorHandling"})
	public void logInErrorValidation() throws InterruptedException, IOException {
		
		mLandingPage.logInTheApplication("wr1Ronald_Joe@hotmail.com",
				"Qwer123$$");
		
		Assert.assertEquals("Incorrect email or password.",mLandingPage.getErrorMessage() );

	}
	
	
	@Test
	public void productErrorValidation() throws InterruptedException, IOException {
		String productsNeeded = "ZARA COAT 3, ADIDAS ORIGINAL";

		//UNIQUE ACCOUNTS SHOULD BE USED SO WHEN USING SAME ACCOUNT AT SAME TIME THERE WILL BE AN ISSUE
		MproductCatalougePage mproductcatalouge = mLandingPage.logInTheApplication("sofhar@gmail.com",
				"Qwer123$$");
		mproductcatalouge.getProductsList(productsNeeded);
		MCartPage mcartpage = mproductcatalouge.goToCartPage();
		

		String productsNeededValidation  = "ZARA COAT 33, ADIDAS ORIGINAL";
		boolean value = mcartpage.getTheCartList(productsNeededValidation);
		Assert.assertFalse(value);

	}
	
	
	/*
	 * @DataProvider public Object[][] getData1() throws IOException {
	 * List<HashMap<String,Object>> data =
	 * getJsonDataMap(System.getProperty("user.dir")+
	 * "\\src\\test\\java\\MCompleteSeleniumFramework\\Tests\\data\\MiranCompleteSeleniumDesign/src/test/java/MCompleteSeleniumFramework/Tests/data/MErrorvalidation.json"
	 * );
	 * 
	 * return new Object[][] {{data.get(0)},{data.get(1)}};
	 * 
	 * }
	 */

}
