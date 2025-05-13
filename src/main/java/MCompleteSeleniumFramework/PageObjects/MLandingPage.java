package MCompleteSeleniumFramework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MCompleteSeleniumFramework.AbstractComponents.MAbstractComponents;

public class MLandingPage extends MAbstractComponents{
	WebDriver driver;

	public MLandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement userPassword;

	@FindBy(id = "login")
	WebElement login_Button;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	

	public MproductCatalougePage logInTheApplication(Object email, Object Password) {
		
		userEmail.sendKeys((String)email);
		userPassword.sendKeys((String)Password);
		login_Button.click();
		
		return new MproductCatalougePage(driver);

	}
	
	public String getErrorMessage() {
		waitForWebelementToBeVisible(errorMessage);
		return errorMessage.getText();
		
	}
	
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");

	}
}
