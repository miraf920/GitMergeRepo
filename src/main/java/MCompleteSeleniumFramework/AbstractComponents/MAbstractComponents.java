package MCompleteSeleniumFramework.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import MCompleteSeleniumFramework.PageObjects.MCartPage;
import MCompleteSeleniumFramework.PageObjects.MOrdersPage;

public class MAbstractComponents {

	WebDriver driver;

	public MAbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "button[routerlink*='cart']")
	WebElement cart;
	
	@FindBy(css = "button[routerlink*='myorders']")
	WebElement orders;

	public void waitForElementToBeVisible(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}

	public void waitForElementToBeInVisible(By findBy) throws InterruptedException {
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
		Thread.sleep(1500);

	}

	public void waitForElementToBeClickable(WebElement element) throws InterruptedException {
		Thread.sleep(500);
	}

	public void waitForWebelementToBeVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	
	public MCartPage goToCartPage() {
		cart.click();
		return new MCartPage(driver);
	}


	public MOrdersPage goToOrdersPage() {
		orders.click();
		return new MOrdersPage(driver);
	}

}
