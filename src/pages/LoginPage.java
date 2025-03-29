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
	
//	Verify that we are on the login page	
	public void waitUntilLoginHeaderTitleIsVisible() {
		wait.until(ExpectedConditions.textToBe(By.tagName("h1"), "Login"));
	}

	public WebElement getEmailInput() {
		return driver.findElement(By.id("email"));
	}
	
	public WebElement getPasswordInput() {
		return driver.findElement(By.id("password"));
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(By.xpath("//button[@type='submit']"));
	}
	
	public void loginAsAdmin() {
		wait.until(ExpectedConditions.visibilityOf(getEmailInput()));
		
		WebElement emailInput = this.getEmailInput();
		WebElement passwordInput = this.getPasswordInput();
		WebElement loginButton = this.getLoginButton();
		
		emailInput.clear();
		emailInput.sendKeys("admin@admin.com");
		passwordInput.clear();
		passwordInput.sendKeys("12345");
		loginButton.click();
// TODO: Ensure to verify if the admin button is visible on the NavPage after login.

	}
}
