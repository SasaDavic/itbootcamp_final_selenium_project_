package tests;

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
	loginPage.waitUntilLoginHeaderTitleIsVisible();
//	Verify that the URL contains the /login route
	Assert.assertTrue(driver.getCurrentUrl().contains("/login"), 
			"You're not on login page!");
		
	}
	
	@Test (priority = 20)
	public void checksInputTypes() {
// 	Clicks the login button from the navigation  
	navPage.getLoginLink().click();
//	Verify that we are on the login page	
	loginPage.waitUntilLoginHeaderTitleIsVisible();
// 	Verifies that the email input field has the attribute type with the value "email"  
	Assert.assertEquals(loginPage.getEmailInput().getAttribute("type"), "email", "Attribute type is not the value \"email\"!");
// 	Verifies that the password input field has the attribute type with the value "password"
	Assert.assertEquals(loginPage.getPasswordInput().getAttribute("type"), "password", "Attribute type is not the value \"password\"!");
	
	}
	
	@Test (priority = 30)
	public void displaysErrorsWhenUserDoesNotExist() {
//	Click on the login button from the navigation
	navPage.getLoginLink().click();
	loginPage.waitUntilLoginHeaderTitleIsVisible();
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
	Assert.assertEquals(messagePopUpPage.popUpMessage(), 
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
	loginPage.waitUntilLoginHeaderTitleIsVisible();
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
	Assert.assertEquals(messagePopUpPage.popUpMessage(), 
			"Wrong password", 
			"Message is not as expected!");
//	Verify that the page URL contains the /login route	
	Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"), 
			"You're not on login page!");
//	close message pop up
	messagePopUpPage.getCloseButton().click();
	
	}
	
	@Test (priority = 50)
	public void login() {
//	Click on the login button in the navigation.
	navPage.getLoginLink().click();
	loginPage.waitUntilLoginHeaderTitleIsVisible();
//	Fill in the login form with the provided credentials.
	loginPage.getEmailInput().sendKeys("admin@admin.com");
	loginPage.getPasswordInput().sendKeys("12345");
	loginPage.getLoginButton().click();
	navPage.waitUntilLoginHeaderTitleIsVisible();
//	Verify that the page URL contains the /home route.
	Assert.assertTrue(driver.getCurrentUrl().endsWith("/home"), 
			"You are not on home page");
	}
	
	
	
	
	
}
