package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyProfilePage extends BasePage{
	
	public MyProfilePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void waitForPageToLoad() {
		waitForH1WithText("My profile");
	}
	
	public void waitForInputToBeClickable(WebElement input) {
		wait.until(ExpectedConditions.elementToBeClickable(input));
	}
	
	public WebElement getEmailInput() {
		return find(By.id("email"));
	}
	
	public WebElement getNameInput() {
		return find(By.id("name"));
	}
	
	public WebElement getPhoneInput() {
		return find(By.id("phone"));
	}
	
	/*		NAME of next input:
		Select with search, Autocomplete with strict matching, Dropdown input field		*/
	
	public WebElement getCityInput() {
		return find(By.id("city"));
	}
	
	public WebElement getCountryInput() {
		return find(By.id("country"));
	}
	
	public WebElement getUrlTwitterInput() {
		return find(By.id("urlTwitter"));
	}
	
	public WebElement getUrlGitHubInput() {
		return find(By.id("urlGitHub"));
	}
	
	public WebElement getSaveButton() {
		return find(By.className("btnSave"));
	}



	

	
}
