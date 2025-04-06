package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BasicTests {
	
	@Test (priority = 10)
	public void visitsTheProfilePage() {
	//	Click the Login button in the navigation bar.
		navPage.getLoginLink().click();
	//	Log in using valid admin credentials.
		loginPage.loginAsAdmin();
		navPage.waitUntilHomeHeaderTitleIsVisible("Welcome Super Administrator");
	//	Navigate to the /profile page.
		navPage.getMyProfileLink().click();
	//	Verify that the current URL contains the /profile route.
		myProfilePage.waitForMyProfilePageToLoad();
		Assert.assertTrue(driver.getCurrentUrl().contains("/profile"), "You're not on correct route!");
	//	Verify that the email input field has the value attribute set to admin@admin.com.
		//System.out.println(myProfilePage.getEmailInput().getAttribute("value"));
		Assert.assertTrue(myProfilePage.getEmailInput().getAttribute("value").contentEquals("admin@admin.com"), "Email is not as expected");
	//	Click the Logout button.
		navPage.getLogoutButton().click();
	}

}
