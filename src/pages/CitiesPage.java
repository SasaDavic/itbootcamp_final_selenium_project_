package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CitiesPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	
	public CitiesPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebElement getSearchInput() {
		return driver.findElement(By.id("search"));
	}
	
	public WebElement getNewItemButton() {
		return driver.findElement(By.className("btnNewItem"));
	}
	
	
	
	
}
