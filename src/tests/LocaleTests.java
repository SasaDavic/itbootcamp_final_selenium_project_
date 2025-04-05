package tests;

import org.testng.annotations.Test;

import pages.LanguageOption;

public class LocaleTests extends BasicTests{
	
	@Test (priority = 10)
	public void setLocaleToES() {
		
	//	Set the language to ES.
		navPage.selectLanguage(LanguageOption.ES);
	//	Verify that the text "Página de aterrizaje" appears in the header of the page.
		navPage.waitUntilHomeHeaderTitleIsVisible("Página de aterrizaje");
		
	}
	
	@Test (priority = 20)
	public void setLocaleToCN() {
		
	//	Set the language to CN.
		navPage.selectLanguage(LanguageOption.CN);
	//	Verify that the text "首页" appears in the header of the page.
		navPage.waitUntilHomeHeaderTitleIsVisible("首页");
		
	}
	
	@Test (priority = 30)
	public void setLocaleToFR() {
		
	//	Set the language to FR.
		navPage.selectLanguage(LanguageOption.FR);
	//	Verify that the text "Page d'atterrissage" appears in the header of the page.
		navPage.waitUntilHomeHeaderTitleIsVisible("Page d'atterrissage");
		
	}
	
	@Test (priority = 40)
	public void setLocaleToUA() {
		
	//	Set the language to UA.
		navPage.selectLanguage(LanguageOption.UA);
	//	Verify that the text "Лендінг" appears in the header of the page.
		navPage.waitUntilHomeHeaderTitleIsVisible("Лендінг");
		
	}
	
	@Test (priority = 50)
	public void setLocaleToEN() {
		
	//	Set the language to EN.
		navPage.selectLanguage(LanguageOption.EN);
	//	Verify that the text "Landing" appears in the header of the page.
		navPage.waitUntilHomeHeaderTitleIsVisible("Landing");
		
	}
	
	
	
	
	

}
