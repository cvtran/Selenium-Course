import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoppingCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//start webdriver and navigate to shopping tutorial page
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chomedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		TimeUnit.SECONDS.sleep(3);
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		String[] itemsNeeded = {"Brocolli", "Tomato", "Beetroot"};
		List itemsNeededList = Arrays.asList(itemsNeeded);
		int numOfItems = 3;
		
		//iterate through the products and add products that match shoppingList items to cart
		for(int i = 0; i < products.size(); i++) {
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			if(itemsNeededList.contains(formattedName)) {
				numOfItems--;
				//click on add to cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if(numOfItems == 0)
					break;
			}
		}
	
		TimeUnit.SECONDS.sleep(5);
		driver.quit();
		
	}

}
