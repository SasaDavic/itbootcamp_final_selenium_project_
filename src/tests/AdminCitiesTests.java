package tests;

import static org.testng.Assert.assertTrue;

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

	public void checksInputTypesForCreateEditNewCity() {
	//	Click the admin button in the navigation.

	//	Click the Cities button from the dropdown Admin menu.

	//	Click the New Item button.

	//	Wait for the dialog for creating and editing a city to appear.

	//	Verify that the input field for the city has the attribute type="text".
	}
	
	public void createNewCity() {
	//	Click the admin button in the navigation.

	//	Click the Cities button from the dropdown Admin menu.

	//	Click the New Item button.

	//	Wait for the dialog for creating and editing a city to appear.

	//	Enter the city name in the input field.

	//	Click the Save button.

	//	Wait for the popup displaying the message to appear.

	//	Verify that the message contains the text "Saved successfully".


	}
	
	public void editCity() {
	//	Click the admin button in the navigation.

	//	Click the Cities button from the dropdown Admin menu.

	//	In the search field, enter the old city name.

	//	Wait for the table to show 1 row.

	//	Click the Edit button in the first row.

	//	Enter the new city name.

	//	Click the Save button.

	//	Wait for the popup displaying the message to appear.

	//	Verify that the message contains the text "Saved successfully".
	}
	
	public void searchCity() {
	//	Click the admin button in the navigation.

	//	Click the Cities button from the dropdown Admin menu.

	//	In the search field, enter the old city name.

	//	Wait for the table to show 1 row.

	//	Verify that the Name column of the first row contains the search text.
	}
	
	public void deleteCity() {
	//	Click the admin button in the navigation.

	//	Click the Cities button from the dropdown Admin menu.

	//	In the search field, enter the old city name.

	//	Wait for the table to show 1 row.

	//	Verify that the Name column of the first row contains the search text.

	//	Click the Delete button in the first row.

	//	Wait for the delete dialog to appear.

	//	Click the Delete button in the dialog.

	//	Wait for the popup displaying the message to appear.

	//	Verify that the message contains the text "Deleted successfully".
	}
	
	
	
	
	
}
