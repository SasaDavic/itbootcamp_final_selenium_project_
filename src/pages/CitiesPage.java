package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CitiesPage extends BasePage {

	public CitiesPage(WebDriver driver) {
		super(driver);
	}

	//ovde se text na osnou kog cekamo ucitavanje stranice ne nalazi u h1
	@Override
	public void waitForPageToLoad() {
		wait.until(ExpectedConditions.textToBe(By.xpath("//*[text()='Cities']"), "Cities"));
	}
	
	public WebElement getSearchInput() {		
		return find(By.id("search"));
	}
	
	public WebElement getNewItemButton() {
		return find(By.className("btnNewItem"));
	}
	
	//Dialog For Creating And Editing
	public void waitForTheDialogForCreatingAndEditingACityToAppear() {
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'v-card')]")));
	}
	//Dialog For Delete
	public void waitForTheDialogForDeleteACityToAppear() {
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Do you really want to delete this item?')]")));
	}
	public WebElement getDeleteButton() {
		return find(By.xpath("//*[contains(text(), ' Delete ')]/.."));
	}
		
	public WebElement getDialogNameInput() {
		return find(By.id("name"));
	}
	public WebElement getDialogSaveButton() {
		WebElement saveButton = driver.findElement(By.className("btnSave"));
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		return saveButton;
	}
	public WebElement getDialogCancelButton() {
		return find(By.className("btnCancel"));
	}
	
	private List<WebElement> tableRows() {
		return driver.findElements(By.xpath("//tbody/tr"));		
	}
	//1 is first row, 2 is second row,...
	public WebElement getEditButton(int rowNumber) {
		return this.tableRows().get(rowNumber - 1).findElement(By.id("edit"));
	}
	public WebElement getDeleteButton(int rowNumber) {
		return this.tableRows().get(rowNumber - 1).findElement(By.id("delete"));
	}
	
	public String getCityName(int rowNumber) {
		return this.tableRows().get(rowNumber - 1).findElement(By.xpath("./td[2]")).getText();
	}
	
	public void waitForSearchResultsToBe(int resultNumbers) {
		wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//tbody/tr"), resultNumbers));
	}

	
	
}
