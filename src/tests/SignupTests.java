package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SignupTests extends BasicTests {
	
	@Test (priority = 10)
	public void visitsTheSignupPage() {
		
//	Click the sign-up button in the navigation
	navPage.getSignUpLink().click();
	signupPage.waiUntilSignupHeaderTitleIsVisible();
//	Verify that the URL contains the /signup route
	Assert.assertTrue(driver.getCurrentUrl().endsWith("/signup"),
			"You are not on signup page!");
	}
	
	
	@Test (priority = 20)
	public void checksInputTypes() {
//	Click the sign-up button in the navigation
	navPage.getSignUpLink().click();
	signupPage.waiUntilSignupHeaderTitleIsVisible();
//	Verify that the name input field has the type attribute set to text	
	Assert.assertEquals(signupPage.getNameInput().getAttribute("type"), 
			"text", 
			"The atribute type is not set to text!");
//	Verify that the email input field has the type attribute set to email
	Assert.assertEquals(signupPage.getEmailInput().getAttribute("type"), 
			"email", 
			"The atribute type is not set to email!");
//	Verify that the password input field has the type attribute set to password
	Assert.assertEquals(signupPage.getPasswordInput().getAttribute("type"), 
			"password", 
			"The atribute type is not set to password!");
//	Verify that the confirm password input field has the type attribute set to password	
	Assert.assertEquals(signupPage.getConfirmPasswordInput().getAttribute("type"), 
			"password", 
			"The atribute type is not set to password!");
	}
	
	@Test (priority = 30)
	public void displaysErrorsWhenTheUserAlreadyExists() {
//		Click the sign-up button in the navigation
		navPage.getSignUpLink().click();
		signupPage.waiUntilSignupHeaderTitleIsVisible();
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
		Assert.assertEquals(messagePopUpPage.popUpMessage(), 
				"E-mail already exists", 
				"Pop uo message is not as expected!");
//		Verify that the URL still contains the /signup route
		Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), 
				"URL doesn't contains the /signup route");
//		close popUp message
		messagePopUpPage.getCloseButton().click();
	}
	
	
	@Test (priority = 40)
	public void signup() throws InterruptedException {
//	Click the sign-up button in the navigation
	navPage.getSignUpLink().click();
//	Fill in the registration form with the provided data
	signupPage.getNameInput().sendKeys("Sasa Zivkovic1");
	signupPage.getEmailInput().sendKeys("sasa.zivkovic1@itbootcamp.rs");
	signupPage.getPasswordInput().sendKeys("12345");
	signupPage.getConfirmPasswordInput().sendKeys("12345");
//	Click the sign-up button
	signupPage.getSignupButton().click();
//	Load the /home page
	navPage.waitUntilLoginHeaderTitleIsVisible();
	Thread.sleep(2000);
	messagePopUpPage.waitForImportantMessageToBecomeVisible();
	softAssert.assertEquals(messagePopUpPage.importantMessage(), " IMPORTANT: Verify your account ", "Message is not as exspected!");
	messagePopUpPage.getImportantMessageCloseButton().click();
//	Click Logout
	navPage.getLogoutButton();
	}
	
}
