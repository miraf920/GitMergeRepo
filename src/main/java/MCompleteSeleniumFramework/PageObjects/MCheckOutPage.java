package MCompleteSeleniumFramework.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MCompleteSeleniumFramework.AbstractComponents.MAbstractComponents;

public class MCheckOutPage extends MAbstractComponents{
WebDriver driver;

	public MCheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	
	
	
	By country_DropDown = By.cssSelector("[placeholder='Select Country']");
	
	By country_Items = By.cssSelector(".ta-item span");
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".ta-item span")
	List <WebElement> countryList;
	
	@FindBy(css=".action__submit")
	WebElement placeOrder;
	
	
	
	public void select_Country(String Country) {
		
		waitForElementToBeVisible(country_DropDown);

		Actions action = new Actions(driver);
		action.sendKeys(country, "ind").build().perform();
		waitForElementToBeVisible(country_Items);
		WebElement Country_selected= countryList.stream().filter(s->s.getText().equalsIgnoreCase(Country)).findFirst().orElse(null);  
		Country_selected.click();
		
	}
	
	
	public MconfirmationPage placeOrder() {
		placeOrder.click();
		return new MconfirmationPage(driver);
		
	}
	

	
	
	
	
}
