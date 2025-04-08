package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
	
	
	
	public LoginPage(WebDriver driver) {
			super(driver);
		}
	
//	Verify that we are on the login page
	@Override
	public void waitForPageToLoad() {
		waitForH1WithText("Login");
	}
	
	public WebElement getEmailInput() {
		return find(By.id("email"));
	}
	
	public WebElement getPasswordInput() {
		return find(By.id("password"));
	}
	
	public WebElement getLoginButton() {
		return find(By.xpath("//button[@type='submit']"));
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

	}

}
