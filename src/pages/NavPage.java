package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public NavPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

//	Verify that we are on the home page	
	public void waitUntilLoginHeaderTitleIsVisible() {
		wait.until(ExpectedConditions.or(ExpectedConditions.textToBe(By.tagName("h1"), "Landing"),
			    ExpectedConditions.textToBePresentInElementLocated(By.tagName("h1"), "Welcome"))) ;
	}
	public WebElement getHomeLink() {
		return driver.findElement(By.partialLinkText("HOME"));
	}
	
	public WebElement getAboutLink() {
		return driver.findElement(By.partialLinkText("ABOUT"));
	}
	
	public WebElement getMyProfileLink() {
		return driver.findElement(By.partialLinkText("MY PROFILE"));
	}
	
	public WebElement getLoginLink() {
		return driver.findElement(By.partialLinkText("LOGIN"));
	}
	
	public WebElement getSignUpLink() {
		return driver.findElement(By.partialLinkText("SIGN UP"));
	}
	
	public WebElement getLogoutButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'btnLogout')]"));
	}
	
	public WebElement getThemeSwitchCheckbox() {
		return driver.findElement(By.id("input-26"));
	}
	
//	public boolean isDarkTheme() {
//		if (this.getThemeSwitchCheckbox().getAttribute("aria-checked").contains("true")) {
//			return true;
//		}
//		return false;
//	}
	
// Improved version: Returns true if the theme is dark (when aria-checked is 'true'), otherwise false for light theme.	
	public boolean isDarkTheme() {
		// When the attribute is true, the theme is dark, so it returns true; otherwise, it is light.
		return Boolean.parseBoolean(this.getThemeSwitchCheckbox().getAttribute("aria-checked"));
	}
	
	public boolean isAdminButtonVisible() {
		try {
			//Without '!= null', we could get a NullPointerException if the adminButton is null.
			return wait.until(ExpectedConditions.visibilityOf(getAdminButton())) != null;
		} catch (Exception e) {
			return false;
		}
	}
	
	public WebElement getAdminButton() {
		return driver.findElement(By.className("btnAdmin"));
	}
	
	public WebElement getAdminMenuOption_CitiesLink() {
		By locator = By.xpath("//div[contains(text(),'Cities')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator);
	}
	
	public WebElement getAdminMenuOption_UsersLink() {
		By locator = By.xpath("//div[contains(text(),'Users')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator);
	}
	
	private WebElement getLanguageButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'btnLocaleActivation')]"));
	}
	
	// Find and click on the language option based on the selected enum locator.
	public void selectLanguage(LanguageOption languageOption) {
		this.getLanguageButton().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'v-menu__content')]")));
		driver.findElement(languageOption.getLocator()).click();
	}
}
