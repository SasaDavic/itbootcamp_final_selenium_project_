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
		myProfilePage.waitForPageToLoad();
		Assert.assertTrue(driver.getCurrentUrl().contains("/profile"), "You're not on correct route!");
	//	Verify that the email input field has the value attribute set to admin@admin.com.
		//System.out.println(myProfilePage.getEmailInput().getAttribute("value"));
		Assert.assertTrue(myProfilePage.getEmailInput().getAttribute("value").contentEquals("admin@admin.com"), "Email is not as expected");
	//	Click the Logout button.
		navPage.getLogoutButton().click();
	}
	
	
	@Test (priority = 20)
	public void checksInputTypes() throws InterruptedException {
	//	Click on the Login button from the navigation
		navPage.getLoginLink().click();
	//	Log in to the system with admin credentials
		loginPage.loginAsAdmin();
	//	Click on the My Profile button from the navigation
		navPage.getMyProfileLink().click();
	//	Verify that the email field has the attribute type with the value email
		Assert.assertTrue(myProfilePage.getEmailInput().getAttribute("type").contentEquals("email"), 
				"Attribute type is not as expected!");
	//	Verify that the email field has the attribute disabled with the value disabled
		Thread.sleep(2000);
		Assert.assertFalse(myProfilePage.getEmailInput().isEnabled(),
				"Email input should be disabled, but it is enabled!");
	//	Verify that the name field has the attribute type with the value text
		Assert.assertEquals(myProfilePage.getNameInput().getAttribute("type"), "text", "Attribute type for input name is not as expected!");
	//	Verify that the city field has the attribute type with the value text
		Assert.assertEquals(myProfilePage.getCityInput().getAttribute("type"), "text", "Attribute type for input city is not as expected!");
	//	Verify that the country field has the attribute type with the value text
		Assert.assertEquals(myProfilePage.getCountryInput().getAttribute("type"), "text", "Attribute type for input country is not as expected!");
	//	Verify that the urlTwitter field has the attribute type with the value url
		Assert.assertEquals(myProfilePage.getUrlTwitterInput().getAttribute("type"), "url", "Attribute type for input urlTwitter is not as expected!");
	//	Verify that the urlGitHub field has the attribute type with the value url
		Assert.assertEquals(myProfilePage.getUrlGitHubInput().getAttribute("type"), "url", "Attribute type for input urlGitHub is not as expected!");
	//	Verify that the phone field has the attribute type with the value tel
		Assert.assertEquals(myProfilePage.getPhoneInput().getAttribute("type"), "tel", "Attribute type for input phone is not as expected!");
	//	Click on the Logout button
		navPage.getLogoutButton().click();
		
				
	}
	
	@Test (priority = 30)
	public void editProfile() {
		
	//	Click on the login button from the navigation
		navPage.getLoginLink().click();
	//	Log in to the system with admin credentials
		loginPage.loginAsAdmin();
	//	Click on the "My Profile" button from the navigation
		navPage.getMyProfileLink().click();
	//	Fill in the form with data
		myProfilePage.clearInputField(myProfilePage.getNameInput());
		myProfilePage.getNameInput().sendKeys("Sasa Zivkovic");
		myProfilePage.clearInputField(myProfilePage.getPhoneInput());
		myProfilePage.getPhoneInput().sendKeys("+38161283223");
		myProfilePage.clearInputField(myProfilePage.getCityInput());
		myProfilePage.getCityInput().sendKeys("Bucaramanga");
		myProfilePage.clearInputField(myProfilePage.getCountryInput());
		myProfilePage.getCountryInput().sendKeys("Spain");
		myProfilePage.clearInputField(myProfilePage.getUrlTwitterInput());
		myProfilePage.getUrlTwitterInput().sendKeys("https://twitter.com/profile/milan1232");
		myProfilePage.clearInputField(myProfilePage.getUrlGitHubInput());
		myProfilePage.getUrlGitHubInput().sendKeys("https://github.com/SasaDavic");
	//	Click on the "Save" button
		myProfilePage.getSaveButton().click();
	//	Verify that the message dialog is visible
		messagePopUpPage.waitForTheSuccessPopupToBecomeVisible();
	//	Verify that the message "Profile saved successfully" is displayed
		Assert.assertTrue(messagePopUpPage.getSuccessPopUpMessage().contains("Profile saved successfuly"), 
				"Message is not as expected! You got message: " + messagePopUpPage.getSuccessPopUpMessage());
	//	Verify that each input now has a value attribute with the value entered in the form
		Assert.assertEquals(myProfilePage.getNameInput().getText(), 
				"Sasa Zivkovic", 
				"Name is not as expected!");
		Assert.assertEquals(myProfilePage.getPhoneInput().getText(), 
				"+38161283223", 
				"Phone number is not as expected!");
		Assert.assertEquals(myProfilePage.getCityInput().getText(), 
				"Bucaramanga", 
				"City is not as expected!");
		Assert.assertEquals(myProfilePage.getCountryInput().getText(), 
				"Spain", 
				"Country is not as expected!");
		Assert.assertEquals(myProfilePage.getUrlTwitterInput().getText(), 
				"https://twitter.com/profile/milan1232", 
				"Twitter is not as expected!");
		Assert.assertEquals(myProfilePage.getUrlGitHubInput().getText(), 
				"https://github.com/SasaDavic", 
				"GitHub is not as expected!");
	//	Click on the logout button
		navPage.getLogoutButton().click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
