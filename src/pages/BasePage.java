package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
abstract class BasePage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Actions actions;
	
	
	public BasePage(WebDriver driver) {
	    this.driver = driver;
	    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    this.actions = new Actions(driver);
	}
	
	public void clearInputField(WebElement input) {
		actions.moveToElement(input)
			.click()
			.keyDown(Keys.CONTROL)
			.sendKeys("a")
			.keyUp(Keys.CONTROL)
			.sendKeys(Keys.DELETE)
			.perform();
	}
	
	protected void clickOnButton(WebElement button) {
		wait.until(ExpectedConditions.elementToBeClickable(button));
		actions.moveToElement(button)
			.click()
			.perform();
	}
	
	public abstract void waitForPageToLoad();
	
	//implementuje se u waitForPageToLoad() 
	protected void waitForH1WithText(String expectedText) {
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h1"), expectedText));
	}
	
	/*
	 * IDEJA: 
	 * protected WebElement find(By locator) {
    		return driver.findElement(locator);
		}
	 * PAGE:
		public WebElement getPhoneInput() {
    		return find(By.id("phone"));
		}
	 */
	protected WebElement find(By locator) {
		return driver.findElement(locator);
	}
	
	
	

}
