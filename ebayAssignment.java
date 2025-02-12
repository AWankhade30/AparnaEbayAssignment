package SeleniumPractice_Aparna.SeleniumPractice_Aparna;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ebayAssignment{
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();		
		driver.get("https://www.ebay.com");
		driver.manage().window().maximize();

		try {
            // Step 1: Open browser and navigate to eBay
            driver.get("https://www.ebay.com");

            // Step 2: Search for 'book'
            WebElement searchBox = driver.findElement(By.name("_nkw"));
            searchBox.sendKeys("book");
            searchBox.submit();

            // Step 3: Click on the first book in the list
            WebElement firstBook = driver.findElement(By.xpath("(//li[contains(@class, 's-item')]//a[@class='s-item__link'])[1]"));
            firstBook.click();

            // Step 4: Click 'Add to cart'
            WebElement addToCartButton = driver.findElement(By.id("atcRedesignId_btn"));
            addToCartButton.click();

            // Step 5: Verify cart is updated
            Thread.sleep(3000); // Wait for the cart to update
            WebElement cartCount = driver.findElement(By.id("gh-cart-n"));
            String itemCount = cartCount.getText();
            
            if (!itemCount.equals("0")) {
                System.out.println("Test Passed: Item successfully added to cart.");
            } else {
                System.out.println("Test Failed: Cart count did not update.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close browser
            driver.quit();
        }
    }
}