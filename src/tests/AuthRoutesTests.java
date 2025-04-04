package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.NavPage;

public class AuthRoutesTests extends BasicTests{
	
	@Test (priority = 10)
	public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
		
		navPage.waitUntilHomeHeaderTitleIsVisible();
	//	Load the /home page.
		driver.get(baseUrl + "/home");
	//	Verify that the URL contains the /login route.
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "You're not on login page");
	}
	
	@Test (priority = 20)
	public void forbidsVisitsToProfileURLIfNotAuthenticated() {
		
		navPage.waitUntilHomeHeaderTitleIsVisible();
	//	Load the /profile page.
		driver.get(baseUrl + "/profile");
	//	Verify that the URL contains the /login route.
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "You're not on login page");
	}
	
	
	
	
	
	
	
}
