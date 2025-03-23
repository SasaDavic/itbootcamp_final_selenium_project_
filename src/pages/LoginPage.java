package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	private WebDriver driver;
	private WebDriverWait wait;

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void waitUntilLoginHeaderTitleIsVisible() {
		wait.until(ExpectedConditions.textToBe(By.tagName("h1"), "Login"));
	}

	public WebElement getEmailInput() {
		return driver.findElement(By.id("email"));
	}
	
	public WebElement getPasswordInput() {
		return driver.findElement(By.id("password"));
	}
}
