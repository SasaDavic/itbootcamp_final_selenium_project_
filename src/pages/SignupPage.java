package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage{
	
	
	public SignupPage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public void waitForPageToLoad() {
		waitForH1WithText("Signup");
	}

	public WebElement getNameInput() {
		return find(By.id("name"));
	}
	
	public WebElement getEmailInput() {
		return find(By.id("email"));
	}
	
	public WebElement getPasswordInput() {
		return find(By.id("password"));
	}
	
	public WebElement getConfirmPasswordInput() {
		return find(By.id("confirmPassword"));
	}
	
	public WebElement getSignupButton() {
		return find(By.xpath("//button[@type='submit']"));
	}

	
	
	
	
}
