package itbootcamp_final_selenium_project;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumTest {
	
	@Test
	public void test() {
		System.out.println("Test");
	}
	
	
    public static void main(String[] args) {
    	// Set the path to chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        // Create an instance of Chrome driver
        WebDriver driver = new ChromeDriver();

        // Open the Google homepage
        driver.get("https://www.google.com");

        // Print the current URL in the console (verification that the page is loaded)
        System.out.println("Trenutni URL je: " + driver.getCurrentUrl());

        // Close the browser
        driver.quit();
    }
}
