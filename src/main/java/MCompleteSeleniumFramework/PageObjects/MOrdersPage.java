package MCompleteSeleniumFramework.PageObjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MCompleteSeleniumFramework.AbstractComponents.MAbstractComponents;

public class MOrdersPage extends MAbstractComponents{

	WebDriver driver;
	public MOrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	By singleElement= By.xpath("//tbody/tr[1]/td[2]");
	
	@FindBy(xpath ="//tbody/tr/td[2]")
	List<WebElement> ordersList;
	
	public boolean getTheOrdersList(List<String> productsNeeded) {
		 waitForElementToBeVisible(singleElement);
		 
	//	 ordersList.forEach(order -> System.out.println(order.getText()));	
		 
		 List<String> matchedProducts = productsNeeded.stream()
			        .filter(f -> ordersList.stream()
			            .anyMatch(s -> s.getText().equalsIgnoreCase(f)))
			        .collect(Collectors.toList());
			    
			    // Example: Print the matched products
			   // matchedProducts.forEach(System.out::println); 
			    
			    boolean value = matchedProducts.containsAll(productsNeeded);
			    
			    return value;	 
	 }
	
	
	
	
	
	
	

}
