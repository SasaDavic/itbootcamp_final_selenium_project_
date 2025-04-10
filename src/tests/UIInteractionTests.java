package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UIInteractionTests extends BasicTests{
	
	
	@Test
	public void testInitialTheme() {
	    WebElement body = driver.findElement(By.tagName("body"));
	    String themeClass = body.getAttribute("class");

	    // Proveriti da li je početna tema svetla
	    Assert.assertTrue(themeClass.contains("light-mode"));
	}
	
	@Test
	public void testThemeToggleFunctionality() {
	    WebElement themeToggle = driver.findElement(By.cssSelector("input[type='checkbox'][role='switch']"));
	    
	    // Kliknuti na dugme da bi se promenila tema
	    themeToggle.click();

	    // Proveriti da li se tema promenila
	    WebElement body = driver.findElement(By.tagName("body"));
	    String themeClass = body.getAttribute("class");
	    Assert.assertTrue(themeClass.contains("dark-mode"));
	}
	
	@Test
	public void testThemeToggleBackToLight() {
	    WebElement themeToggle = driver.findElement(By.cssSelector("input[type='checkbox'][role='switch']"));
	    
	    // Kliknuti da bi se promenila tema na tamnu
	    themeToggle.click();
	    
	    // Kliknuti ponovo da bi se vratilo na svetlu temu
	    themeToggle.click();

	    WebElement body = driver.findElement(By.tagName("body"));
	    String themeClass = body.getAttribute("class");
	    
	    // Proveriti da li se tema vratila na svetlu
	    Assert.assertTrue(themeClass.contains("light-mode"));
	}
	@Test
	public void testThemeToggleState() {
	    WebElement themeToggle = driver.findElement(By.cssSelector("input[type='checkbox'][role='switch']"));

	    // Proveriti početno stanje prekidača (da li je uključen ili isključen)
	    boolean isChecked = themeToggle.isSelected();
	    
	    // Početno stanje bi trebalo da bude isključeno
	    Assert.assertFalse(isChecked);

	    // Promeniti stanje
	    themeToggle.click();
	    
	    // Proveriti da li je dugme sada selektovano
	    Assert.assertTrue(themeToggle.isSelected());
	}
	
	@Test
	public void testBackgroundColorChange() {
	    WebElement themeToggle = driver.findElement(By.cssSelector("input[type='checkbox'][role='switch']"));
	    
	    // Kliknuti na dugme da bi se promenila tema
	    themeToggle.click();
	    
	    // Proveriti pozadinsku boju tela
	    WebElement body = driver.findElement(By.tagName("body"));
	    String backgroundColor = body.getCssValue("background-color");
	    
	    // Očekivana tamna pozadina (možeš koristiti odgovarajuću boju)
	    Assert.assertEquals("rgb(0, 0, 0)", backgroundColor);
	}

}
