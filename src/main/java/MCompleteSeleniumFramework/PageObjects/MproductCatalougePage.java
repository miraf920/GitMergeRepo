package MCompleteSeleniumFramework.PageObjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MCompleteSeleniumFramework.AbstractComponents.MAbstractComponents;

public class MproductCatalougePage extends MAbstractComponents {
	WebDriver driver;

	public MproductCatalougePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By elementWait = By.cssSelector(".mb-3");
	
	@FindBy(css=".mb-3")
	List <WebElement> productList;
	
		
	By toast = By.cssSelector(".toast-success");
	By spinner = By.cssSelector(".ng-animating");
	
	

	

	
	
	public void getProductsList(Object productsNeeded) {
		List<String> productNeeded = Arrays.asList(((String) productsNeeded).split(","));//		
		//productNeeded.forEach(System.out::println); 
		waitForElementToBeVisible(elementWait);
	   //productList.forEach(s->System.out.println(s.getText())); 
		productNeeded.forEach(f->
		{WebElement product =productList.stream().filter(s->
		s.findElement(By.tagName("b")).getText().equalsIgnoreCase(f)).findFirst().orElse(null);
		
		
		if(product!= null) {
			product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
			
		}
		
		waitForElementToBeVisible(toast);
		
		try {
			waitForElementToBeInVisible(spinner);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		});
		
		
		
		
	}
	
	
	
	
	
	
	
	
	

}
