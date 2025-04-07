package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyProfilePage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public MyProfilePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void waitForMyProfilePageToLoad() {
		wait.until(ExpectedConditions.textToBe(By.xpath("//h1"), "My profile"));
	}
	
	public WebElement getEmailInput() {
		return driver.findElement(By.id("email"));
	}
	
	public WebElement getNameInput() {
		return driver.findElement(By.id("name"));
	}
	
	public WebElement getPhoneInput() {
		return driver.findElement(By.id("phone"));
	}
	//name of next input:
	//	Select with search
	//	Autocomplete with strict matching or
	//	Dropdown input field
	public WebElement getCityInput() {
		return driver.findElement(By.id("city"));
	}
	
	public WebElement getCountryInput() {
		return driver.findElement(By.id("country"));
	}
	
	public WebElement getUrlTwitterInput() {
		return driver.findElement(By.id("urlTwitter"));
	}
	
	public WebElement getUrlGitHubInput() {
		return driver.findElement(By.id("urlGitHub"));
	}
	
	public WebElement getSaveButton() {
		return driver.findElement(By.className("btnSave"));
	}
}
