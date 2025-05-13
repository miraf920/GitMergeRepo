package MCompleteSeleniumFramework.Tests;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import MCompleteSeleniumFramework.PageObjects.MCartPage;
import MCompleteSeleniumFramework.PageObjects.MCheckOutPage;
import MCompleteSeleniumFramework.PageObjects.MOrdersPage;
import MCompleteSeleniumFramework.PageObjects.MconfirmationPage;
import MCompleteSeleniumFramework.PageObjects.MproductCatalougePage;
import MCompleteSeleniumFramework.TestsComponents.MBaseTest;

public class MStandAloneTest extends MBaseTest {
	List<String> productsNeeded = Arrays.asList("ZARA COAT 3", "ADIDAS ORIGINAL");
	String country = "India";

	@Test(dataProvider = "getData", groups = "purchaseOrder")
	public void submitOrder(HashMap<Object, Object> input) throws InterruptedException, IOException {

		MproductCatalougePage mproductcatalouge = mLandingPage.logInTheApplication(input.get("email"),
				input.get("password"));
		mproductcatalouge.getProductsList(input.get("productNeeded"));
		MCartPage mcartpage = mproductcatalouge.goToCartPage();

		boolean value = mcartpage.getTheCartList(input.get("productNeeded"));
		Assert.assertTrue(value);
		MCheckOutPage mcheckoutpage = mcartpage.goToCheckOutPage();

		mcheckoutpage.select_Country(country);

		MconfirmationPage mconfirmationpage = mcheckoutpage.placeOrder();
		String message = mconfirmationpage.confirmationMessage();

		Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	// Verify if Zara coat in being displayed in the Orders page
	// this depends on the test above
	@Test(dependsOnMethods = { "submitOrder" })
	public void orderHistoryTest() {
		MproductCatalougePage mproductcatalouge = mLandingPage.logInTheApplication("Ronald_Joe@hotmail.com",
				"Qwer123$$");

		MOrdersPage morderspage = mproductcatalouge.goToOrdersPage();
		boolean value = morderspage.getTheOrdersList(productsNeeded);
		Assert.assertTrue(value);
	}
	
	
	
//	@DataProvider
//	public Object[][] getData() {
//	return new Object[][] {{"Ronald_Joe@hotmail.com","Qwer123$$"},{"sofhar@gmail.com","Qwer123$$"}};	
//	}
//	

	/*
	 * @DataProvider public Object[][] getData() { HashMap<Object, Object> map = new
	 * HashMap<Object, Object>(); map.put("email", "Ronald_Joe@hotmail.com");
	 * map.put("password", "Qwer123$$"); map.put("productNeeded",
	 * "ZARA COAT 3,ADIDAS ORIGINAL");
	 * 
	 * HashMap<Object, Object> map1 = new HashMap<Object, Object>();
	 * map1.put("email", "sofhar@gmail.com"); map1.put("password", "Qwer123$$");
	 * map1.put("productNeeded", "ADIDAS ORIGINAL"); return new Object[][] { { map
	 * }, { map1 } }; }
	 */
	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String,Object>> data = getJsonDataMap(System.getProperty("user.dir")+"\\src\\test\\java\\MCompleteSeleniumFramework\\Tests\\data\\MPurchaseOrder.json");
		
		return new Object[][] {{data.get(0)},{data.get(1)}};

	}

}
