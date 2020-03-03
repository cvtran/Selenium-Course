import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//start webdriver
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chomedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //declare implicit wait
		WebDriverWait w = new WebDriverWait(driver, 5); // declare explicit wait
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/"); //navigate to shopping tutorial page

		String[] itemsNeeded = {"Brocolli", "Tomato", "Beetroot"}; //items to purchase
		addItems(driver, itemsNeeded); //add items to cart
		
		//go to checkout
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode"))); //explicit wait for promo code text field to display
		
		//apply promo code
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo"))); //explicit wait for promo code to be applied
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText()); //print promo code info
		
		TimeUnit.SECONDS.sleep(5);
		driver.quit();
		
	}
	
	//adds items from itemsNeeded to the cart
	public static void addItems(WebDriver driver, String[] itemsNeeded)	{
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		List<String> itemsNeededList = Arrays.asList(itemsNeeded);
		int numOfItems = itemsNeeded.length;
		
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
	}

}
