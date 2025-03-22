package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pages.NavPage;

public abstract class BasicTests {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
	protected NavPage navPage;
	
	@BeforeClass
	public void setup() {
		
		// Set the path to chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        // Create an instance of Chrome driver
        driver = new ChromeDriver();
        
        // Set up implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        
        // Initialize explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Initialize page objects
        navPage = new NavPage(driver, wait);
        
	}
	
	@BeforeMethod
	public void beforeMethod() {
	// Navigate to the home page before each test
		driver.get(baseUrl);
	}

	@AfterMethod
	public void afterMethod() {
	// Clean up after each test, if needed (e.g., clear cookies, etc.)	
	}
	
	@AfterClass
	public void afterClass() {
	// Close the browser after all tests are completed
		driver.quit();
	}
	
	
	
	
	
	
}
