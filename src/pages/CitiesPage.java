package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
	}
	
	public WebElement getNewItemButton() {
		return driver.findElement(By.xpath("//button[contains(@class, 'btnNewItem')]"));
	}
	
	//Dialog For Creating And Editing
	public void waitForTheDialogForCreatingAndEditingACityToAppear() {
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'v-card')]")));
	}
	public WebElement getDialogNameInput() {
		return driver.findElement(By.id("name"));
	}
	public WebElement getDialogSaveButton() {
		WebElement saveButton = driver.findElement(By.className("btnSave"));
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		return saveButton;
	}
	public WebElement getDialogCancelButton() {
		return driver.findElement(By.className("btnCancel"));
	}
	
	private List<WebElement> tableRows() {
		return driver.findElements(By.xpath("//tbody/tr"));		
	}
	//1 is first row, 2 is second row,...
	public WebElement getEditButton(int rowNumber) {
		return this.tableRows().get(rowNumber - 1).findElement(By.id("edit"));
	}
	
	public String getCityName(int rowNumber) {
		return this.tableRows().get(rowNumber - 1).findElement(By.xpath("//td[2]")).getText();
	}
	
	public void waitForSearchResultsToBe(int resultNumbers) {
		wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//tbody/tr"), resultNumbers));
	}
	
}
