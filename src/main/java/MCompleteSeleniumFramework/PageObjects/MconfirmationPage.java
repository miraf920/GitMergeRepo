package MCompleteSeleniumFramework.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MCompleteSeleniumFramework.AbstractComponents.MAbstractComponents;

public class MconfirmationPage extends MAbstractComponents {
	WebDriver driver;

	public MconfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	
	By message = By.cssSelector(".hero-primary");
	
	@FindBy(css=".hero-primary")
	WebElement ConfirmationMessage;
	
	
	
	
	public String confirmationMessage() {	
		waitForElementToBeVisible(message);
		return ConfirmationMessage.getText();
	}


}
