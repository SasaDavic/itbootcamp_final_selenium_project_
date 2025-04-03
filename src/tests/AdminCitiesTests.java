package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTests{
	
	private String expectedUrl = "https://vue-demo.daniel-avellaneda.com/admin/cities";
	
	public void verifyURL() {
		Assert.assertEquals(driver.getCurrentUrl(), 
				expectedUrl,
				"URL is not as expected!");
	}
	

	@Test (priority = 10)
	public void visitsTheAdminCitiesPageAndListCities() {
	//	Click the sign-up button in the navigation.
		navPage.getLoginLink().click();
	//	Log in to the system using admin credentials.
		loginPage.waitUntilLoginHeaderTitleIsVisible();
		loginPage.loginAsAdmin();
	//	Click the admin button in the navigation.
		Assert.assertTrue(navPage.isAdminButtonVisible(), "Admin button is not visible!");
		navPage.getAdminButton().click();
	//	Click the Cities button from the dropdown Admin menu.
		navPage.getAdminMenuOption_CitiesLink().click();
	//	Verify that the URL of the page contains the /admin/cities route.
		this.verifyURL();

	}

	@Test (priority = 20)
	public void checksInputTypesForCreateEditNewCity() {
	//	Click the admin button in the navigation.
		if (navPage.isAdminButtonVisible() == true) {
			navPage.getAdminButton().click();
		} else {
			System.out.println("Admin button is not visible!");
		}
	//	Click the Cities button from the dropdown Admin menu.
		navPage.getAdminMenuOption_CitiesLink().click();
	//	Click the New Item button.
		citiesPage.getNewItemButton().click();
	//	Wait for the dialog for creating and editing a city to appear.
		citiesPage.waitForTheDialogForCreatingAndEditingACityToAppear();
	//	Verify that the input field for the city has the attribute type="text".
		Assert.assertTrue(citiesPage.getDialogNameInput().getAttribute("type").equals("text"), 
				"Input field for the city has the attribute that is not as expected!");
	}
	
	@Test (priority = 30)
	public void createNewCity() {
		navPage.waitUntilHomeHeaderTitleIsVisible();
	//	Click the admin button in the navigation.
		navPage.getAdminButton().click();
	//	Click the Cities button from the dropdown Admin menu.
		navPage.clickOnCitiesLinkWithActions();
	//	Click the New Item button.
		citiesPage.getNewItemButton().click();
	//	Wait for the dialog for creating and editing a city to appear.
		citiesPage.waitForTheDialogForCreatingAndEditingACityToAppear();
	//	Enter the city name in the input field.
		citiesPage.getDialogNameInput().clear();
		citiesPage.getDialogNameInput().sendKeys("Nis");
	//	Click the Save button.
		citiesPage.getDialogSaveButton().click();
	//	Wait for the popup displaying the message to appear.
		messagePopUpPage.waitForTheSuccessPopupToBecomeVisible();
	//	Verify that the message contains the text "Saved successfully".
		Assert.assertTrue(messagePopUpPage.getSuccessPopUpMessage().contains("Saved successfully"), 
				"Message is not as expected!");

	}
	
	@Test (priority = 40)
	public void editCity() {
	//	Click the admin button in the navigation.
		navPage.waitUntilHomeHeaderTitleIsVisible();
		if (navPage.isAdminButtonVisible() == true) {
			navPage.getAdminButton().click();
		} else {
			System.out.println("Admin button is not visible!");
		}
	//	Click the Cities button from the dropdown Admin menu.
		navPage.clickOnCitiesLinkWithActions();
	//	In the search field, enter the old city name.
		citiesPage.getSearchInput().clear();
		citiesPage.getSearchInput().sendKeys("Nis");
	//	Wait for the table to show 1 row.
		citiesPage.waitForSearchResultsToBe(1);
	//	Click the Edit button in the first row.
		citiesPage.getEditButton(1).click();
	//	Enter the new city name.
		citiesPage.getDialogNameInput().clear();
		citiesPage.getDialogNameInput().sendKeys("Kikinda");
	//	Click the Save button.
		citiesPage.getDialogSaveButton().click();
	//	Wait for the popup displaying the message to appear.
		messagePopUpPage.waitForTheSuccessPopupToBecomeVisible();
	//	Verify that the message contains the text "Saved successfully".
		System.out.println(messagePopUpPage.getSuccessPopUpMessage());
		Assert.assertTrue(messagePopUpPage.getSuccessPopUpMessage().contains("Saved successfully"), 
				"Message is not as expected!");
	}
	
	@Test (priority = 50)
	public void searchCity() throws InterruptedException {
	//	Click the admin button in the navigation.
		navPage.getAdminButton().click();
	//	Click the Cities button from the dropdown Admin menu.
		navPage.clickOnCitiesLinkWithActions();
	//	In the search field, enter the old city name.
		citiesPage.getSearchInput().sendKeys("Kikinda");
	//	Wait for the table to show 1 row.
		citiesPage.waitForSearchResultsToBe(1);
	//	Verify that the Name column of the first row contains the search text.
		Thread.sleep(2000);
		//treba da bude jednako, vidi kako da obrises Nis iz naziva
		Assert.assertTrue(citiesPage.getCityName(1).contains("Kikinda"), "The city name is not as expected!");
	}
	
	@Test (priority = 60)
	public void deleteCity() {
	//	Click the admin button in the navigation.
		navPage.getAdminButton().click();
	//	Click the Cities button from the dropdown Admin menu.
		navPage.getAdminMenuOption_CitiesLink().click();
	//	In the search field, enter the old city name.
		citiesPage.getSearchInput().sendKeys("Kikinda");
	//	Wait for the table to show 1 row.
		citiesPage.waitForSearchResultsToBe(1);
	//	Verify that the Name column of the first row contains the search text.
		Assert.assertTrue(citiesPage.getCityName(1).contains("Kikinda"), "Expected city name is not in first row");
	//	Click the Delete button in the first row.
		citiesPage.getDeleteButton(1).click();
	//	Wait for the delete dialog to appear.
		citiesPage.waitForTheDialogForDeleteACityToAppear();
	//	Click the Delete button in the dialog.
		citiesPage.getDeleteButton().click();
	//	Wait for the popup displaying the message to appear.
		messagePopUpPage.waitForTheSuccessPopupToBecomeVisible();
	//	Verify that the message contains the text "Deleted successfully".
		Assert.assertTrue(messagePopUpPage.getSuccessPopUpMessage().contains("Deleted successfully"), "Message is not as expected!");
	}
	
	
	
	
	
}
