package pages;

import org.openqa.selenium.By;

public enum LanguageOption {
	

	//Enum to represent the available language options in the navigation menu with corresponding locators.
	EN("English", By.id("list-item-73")),
	ES("Spanish", By.id("list-item-75")),
	FR("French", By.id("list-item-77")),
	CN("China", By.id("list-item-79")),
	UA("Ukrainian", By.id("list-item-81"));
	
	private final String languageName;
    private final By locator;
    
    // Constructor for initializing language name and locator for each language option.
	private LanguageOption(String languageName, By locator) {
		this.languageName = languageName;
		this.locator = locator;
	}

	// Method to get language name
	public String getLanguageName() {
		return languageName;
	}

	 // Method to get locator for the language element
	public By getLocator() {
		return locator;
	}
    
    
	
}
