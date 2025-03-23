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

}
