package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasePage{

	public NavPage(WebDriver driver) {
			super(driver);
		}
	

//	Verify that we are on the home page	
	@Override
	public void waitForPageToLoad() {
		wait.until(ExpectedConditions.or(ExpectedConditions.textToBe(By.tagName("h1"), "Landing"),
				ExpectedConditions.textToBePresentInElementLocated(By.tagName("h1"), "Welcome")));
	}
	
//	Verify that we are on the home page on any language
	public void waitUntilHomeHeaderTitleIsVisible(String titleName) {
		wait.until(ExpectedConditions.textToBe(By.tagName("h1"), titleName));
	}
	
	public WebElement getHomeLink() {
		return find(By.partialLinkText("HOME"));
	}
	
	public WebElement getAboutLink() {
		return find(By.partialLinkText("ABOUT"));
	}
	
	public WebElement getMyProfileLink() {
		return find(By.partialLinkText("MY PROFILE"));
	}
	
	public WebElement getLoginLink() {
		return find(By.partialLinkText("LOGIN"));
	}
	
	public WebElement getSignUpLink() {
		return find(By.partialLinkText("SIGN UP"));
	}
	
	public WebElement getLogoutButton() {
		return find(By.xpath("//*[contains(@class, 'btnLogout')]"));
	}
	
	public WebElement getThemeSwitchCheckbox() {
		return find(By.id("input-26"));
	}
	
//	public boolean isDarkTheme() {
//		if (this.getThemeSwitchCheckbox().getAttribute("aria-checked").contains("true")) {
//			return true;
//		}
//		return false;
//	}
	//**parsiramo zato sto vraca string "true" ne boolean true
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
		return find(By.className("btnAdmin"));
	}
	
	public WebElement getAdminMenuOption_CitiesLink() {
		return find(By.xpath("//a[@href='/admin/cities']"));
	}
	
	public void clickOnCitiesLinkWithActions() {
		clickOnButton(getAdminMenuOption_CitiesLink());
	}
	
	public WebElement getAdminMenuOption_UsersLink() {
		return find(By.xpath("//div[contains(text(),'Users')]"));
	}
	
	public void clickOnUsersLinkWithActions() {
		clickOnButton(getAdminMenuOption_UsersLink());
	}
	
	private WebElement getLanguageButton() {
		return find(By.xpath("//*[contains(@class, 'btnLocaleActivation')]"));
	}
	
	// Find and click on the language option based on the selected enum locator.
	public void selectLanguage(LanguageOption languageOption) {
		this.getLanguageButton().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'v-menu__content')]")));
		driver.findElement(languageOption.getLocator()).click();
	}


	
}
