package MCompleteSeleniumFramework.PageObjects;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MCompleteSeleniumFramework.AbstractComponents.MAbstractComponents;





public class MCartPage extends MAbstractComponents {
	WebDriver driver;
	
	
	
	
	public MCartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	
	
	
	By cartElelement = By.cssSelector(".cart h3");
	
	@FindBy(css=".cart h3")
	List<WebElement> ProductsBought;
	
	
	@FindBy(css=".totalRow button")
	WebElement checkout_Button;
	
	
   public boolean getTheCartList(Object productsNeeded) {
	   
	   
	 List<String> productNeeded = Arrays.asList(((String) productsNeeded).split(","));	
	 
	 waitForElementToBeVisible(cartElelement);
	 
	 List<String> matchedProducts = productNeeded.stream()
		        .filter(f -> ProductsBought.stream()
		            .anyMatch(s -> s.getText().equalsIgnoreCase(f)))
		        .collect(Collectors.toList());
		    
		    // Example: Print the matched products
		   // matchedProducts.forEach(System.out::println); 
		    
		    boolean value = matchedProducts.containsAll(productNeeded);
		    
		    return value;
	 
 }
   
   
   public MCheckOutPage goToCheckOutPage() throws InterruptedException  {
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	   waitForElementToBeClickable(checkout_Button);
	   checkout_Button.click();
	   return new MCheckOutPage(driver);
   }

}

