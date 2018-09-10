package test;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import org.openqa.selenium.*;
public class ItemSearchTest {
	@Test
	public void firstSearchResultIsRelatedTest() {
	    
        System.out.println( "Hello World! this is my test" );

	    // This line tells your test where to find the chromedriver, which is the "glue"
	    // between Selenium and the Chrome installation on your machine
	    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
	    
	    // Start a new Chrome browser instance and maximize the browser window
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    
	    // Navigate to the Amazon.com home page
	    driver.get("https://www.amazon.com/");
	    
	    // Type "Software testing" in the search window
	    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Software Testing");
	    
	    // Click on the search button
	    driver.findElement(By.xpath("//input[@value='Go']")).click();
	    
	    // Select the first item in the list of search results
	    driver.findElement(By.xpath("(//div[@id='resultsCol']//a[contains(@class,'access-detail-page')])[1]")).click();
	    
	    // Check that the page title contains the term "Software Testing"
	    Assert.assertTrue(driver.getTitle().contains("Software Testing"));    

	    // Close the browser
	    driver.quit();    
	}

}

