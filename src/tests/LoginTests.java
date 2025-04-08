package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LanguageOption;

public class LoginTests extends BasicTests {
	
	@Test (priority = 10)
	public void visitsTheLoginPage() {
//	Verify that we are on the home page
	Assert.assertTrue(driver.getCurrentUrl().equals("https://vue-demo.daniel-avellaneda.com/"),
				"You're not on home page!");
// 	Set the page language to EN (English)
	navPage.selectLanguage(LanguageOption.EN);
//	Click on the login button from the navigation
	navPage.getLoginLink().click();
	loginPage.waitForPageToLoad();
//	Verify that the URL contains the /login route
	Assert.assertTrue(driver.getCurrentUrl().contains("/login"), 
			"You're not on login page!");
		
	}
	
	@Test (priority = 20)
	public void checksInputTypes() {
// 	Clicks the login button from the navigation  
	navPage.getLoginLink().click();
//	Verify that we are on the login page	
	loginPage.waitForPageToLoad();
// 	Verifies that the email input field has the attribute type with the value "email"  
	Assert.assertEquals(loginPage.getEmailInput().getAttribute("type"), "email", "Attribute type is not the value \"email\"!");
// 	Verifies that the password input field has the attribute type with the value "password"
	Assert.assertEquals(loginPage.getPasswordInput().getAttribute("type"), "password", "Attribute type is not the value \"password\"!");
	
	}
	
	@Test (priority = 30)
	public void displaysErrorsWhenUserDoesNotExist() {
//	Click on the login button from the navigation
	navPage.getLoginLink().click();
	loginPage.waitForPageToLoad();
//	Fill in the login form with login credentials:
//	email: non-existing-user@gmal.com
//	password: password123
	loginPage.getEmailInput().sendKeys("non-existing-user@gmal.com");
	loginPage.getPasswordInput().sendKeys("password123");
//	Click on the login button
	loginPage.getLoginButton().click();
//	Wait for the error popup to become visible
	messagePopUpPage.waitForTheErrorPopupToBecomeVisible();
//	Verify that the error message contains 'User does not exist'
	Assert.assertEquals(messagePopUpPage.getErrorPopUpMessage(), 
			"User does not exists", 
			"Message is not as expected!");
//	Verify that the page URL contains the /login route
	Assert.assertEquals(driver.getCurrentUrl(), 
			"https://vue-demo.daniel-avellaneda.com/login",
			"You're not on login page!");
	
	}
	
	@Test (priority = 40)
	public void displaysErrorsWhenPasswordIsWrong() {
//	Click on the login button from the navigation
	navPage.getLoginLink().click();
	loginPage.waitForPageToLoad();
//	Fill in the login form with login credentials:
//	email: admin@admin.com
//	password: password123	
	loginPage.getEmailInput().sendKeys("admin@admin.com");
	loginPage.getPasswordInput().sendKeys("password123");
//	Click on the login button
	loginPage.getLoginButton().click();
//	Wait for the error popup to become visible
	messagePopUpPage.waitForTheErrorPopupToBecomeVisible();
//	Verify that the error message contains 'Wrong password'	
	Assert.assertEquals(messagePopUpPage.getErrorPopUpMessage(), 
			"Wrong password", 
			"Message is not as expected!");
//	Verify that the page URL contains the /login route	
	Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"), 
			"You're not on login page!");
//	close message pop up
	messagePopUpPage.getErrorCloseButton().click();
	
	}
	
	@Test (priority = 50)
	public void login() {
//	Click on the login button in the navigation.
	navPage.getLoginLink().click();
	loginPage.waitForPageToLoad();
//	Fill in the login form with the provided credentials.
	loginPage.loginAsAdmin();
	navPage.waitForPageToLoad();
	Assert.assertTrue(navPage.isAdminButtonVisible(), "There is no admin button!");
//	Verify that the page URL contains the /home route.
	Assert.assertTrue(driver.getCurrentUrl().endsWith("/home"), 
			"You are not on home page");
	}
	
	@Test (priority = 60)
	public void logout() {
//	Verify that the logout button is visible on the page.
	Assert.assertTrue(navPage.getLogoutButton().isDisplayed(), "Logout button is not visible!");
//	Click on the logout button.
	navPage.getLogoutButton().click();
// 	wait for user to logout
	loginPage.waitForPageToLoad();
	}
	
	
	
}
