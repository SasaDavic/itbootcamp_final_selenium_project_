package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	public void waitForImportantMessageToBecomeVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'v-card__title')]")));
	}
	
	public String importantMessage() {
		return driver.findElement(By.xpath("//div[contains(@class,'v-card__title')]")).getText();
	}
	
	public WebElement getImportantMessageCloseButton() {
		return driver.findElement(By.className("btnClose"));
	}
	
	public void waitForTheErrorPopupToBecomeVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'error')]")));
	}
	
	public String popUpMessage() {
		return driver.findElement(By.xpath("//div[contains(@class, 'error')]//li")).getText();
	}
	
	public WebElement getCloseButton() {
		return driver.findElement(By.xpath("//div[contains(@class, 'error')]//button"));
	}
	
}
