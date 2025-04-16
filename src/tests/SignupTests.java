package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTests {
	
	@Test (priority = 10)
	public void visitsTheSignupPage() {
		
//	Click the sign-up button in the navigation
	navPage.getSignUpLink().click();
	signupPage.waitForPageToLoad();
//	Verify that the URL contains the /signup route
	Assert.assertTrue(driver.getCurrentUrl().endsWith("/signup"),
			"You are not on signup page!");
	}
	
	
	@Test (priority = 20)
	public void checksInputTypes() {
//	Click the sign-up button in the navigation
	navPage.getSignUpLink().click();
	signupPage.waitForPageToLoad();
//	Verify that the name input field has the type attribute set to text	
	Assert.assertEquals(signupPage.getNameInput().getAttribute("type"), 
			"text", 
			"The attribute type is not set to text!");
//	Verify that the email input field has the type attribute set to email
	Assert.assertEquals(signupPage.getEmailInput().getAttribute("type"), 
			"email", 
			"The attribute type is not set to email!");
//	Verify that the password input field has the type attribute set to password
	Assert.assertEquals(signupPage.getPasswordInput().getAttribute("type"), 
			"password", 
			"The attribute type is not set to password!");
//	Verify that the confirm password input field has the type attribute set to password	
	Assert.assertEquals(signupPage.getConfirmPasswordInput().getAttribute("type"), 
			"password", 
			"The attribute type is not set to password!");
	}
	
	@Test (priority = 30)
	public void displaysErrorsWhenTheUserAlreadyExists() {
//		Click the sign-up button in the navigation
		navPage.getSignUpLink().click();
		signupPage.waitForPageToLoad();
//		Verify that the URL contains the /signup route
		Assert.assertTrue(driver.getCurrentUrl().endsWith("/signup"), 
				"URL doesn't contains the /signup route");
//		Fill in the registration form with the provided data
		signupPage.getNameInput().sendKeys("Another User");
		signupPage.getEmailInput().sendKeys("admin@admin.com");
		signupPage.getPasswordInput().sendKeys("12345");
		signupPage.getConfirmPasswordInput().sendKeys("12345");
//		Click the sign-up button
		signupPage.getSignupButton().click();
//		Wait for the message popup to become visible
		messagePopUpPage.waitForTheErrorPopupToBecomeVisible();
//		Verify that the error message contains the text "E-mail already exists"
		Assert.assertEquals(messagePopUpPage.getErrorPopUpMessage(), 
				"E-mail already exists", 
				"Pop-up message is not as expected!");
//		Verify that the URL still contains the /signup route
		Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), 
				"URL doesn't contains the /signup route");
//		close popUp message
		messagePopUpPage.getErrorCloseButton().click();
	}
	
	
	@Test (priority = 40)
	public void signup() {
//	Click the sign-up button in the navigation
	navPage.getSignUpLink().click();
//	Fill in the registration form with the provided data
	signupPage.getNameInput().sendKeys("Sasa Zivkovic");
	signupPage.getEmailInput().sendKeys("sasa.zivkovic@itbootcamp.rs");
	signupPage.getPasswordInput().sendKeys("12345");
	signupPage.getConfirmPasswordInput().sendKeys("12345");
//	Click the sign-up button
	signupPage.getSignupButton().click();
//	Load the /home page
	navPage.waitForPageToLoad();
	messagePopUpPage.waitForImportantMessageToBecomeVisible();
	softAssert.assertEquals(messagePopUpPage.importantMessage(), 
			"IMPORTANT: Verify your account", 
			"Message is not as expected!");
	softAssert.assertAll();
	messagePopUpPage.getImportantMessageCloseButton().click();
//	Click Logout
	navPage.getLogoutButton().click();
	}
	
}
