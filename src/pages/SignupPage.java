package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public SignupPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void waitUntilSignupHeaderTitleIsVisible() {
		wait.until(ExpectedConditions.textToBe(By.tagName("h1"), "Signup"));
	}
	
	public WebElement getNameInput() {
		return driver.findElement(By.id("name"));
	}
	
	public WebElement getEmailInput() {
		return driver.findElement(By.id("email"));
	}
	
	public WebElement getPasswordInput() {
		return driver.findElement(By.id("password"));
	}
	
	public WebElement getConfirmPasswordInput() {
		return driver.findElement(By.id("confirmPassword"));
	}
	
	public WebElement getSignupButton() {
		return driver.findElement(By.xpath("//button[@type='submit']"));
	}
	
	
	
}
