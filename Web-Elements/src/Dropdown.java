import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dropdown {
	
	public static void main(String[] args) throws InterruptedException {
		
		//start webdriver and navigate to southwest.com
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chomedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://southwest.com");
		TimeUnit.SECONDS.sleep(1);
		
		/*
		 * For a dropdown menu using the select tag
		 * Select s = new Select(driver.findElement(element)); //the dropdown element
		 * s.selectByValue("2");
		 * s.selectByIndex(6);
		 * s.selectByVisibleText("4");
		*/
		
		
		//drop down menu using a list with buttons
		//select 3 passengers
		driver.findElement(By.xpath("//*[@id=\'LandingAirBookingSearchForm_adultPassengersCount\']")).click(); //open dropdown
		TimeUnit.SECONDS.sleep(1);
		driver.findElement(By.cssSelector("#LandingAirBookingSearchForm_adultPassengersCount--item-2 > button")).click(); //select 3 passengers
		TimeUnit.SECONDS.sleep(1);
		
		/*
		 * For a dynamic dropdown menu with indexes
		 * driver.findElement(element1).click()
		 * driver.findElement((element2)[2]).click() //if the element is also found in the first dropdown then you must specify the second element if they have the same locator you are using
		 */
		
		
		//Auto suggestive dropdown menus for departure and arrival airport codes
		//deletes current departure airport code and enters in SAN
		WebElement depart = driver.findElement(By.id("LandingAirBookingSearchForm_originationAirportCode")); //save web element for departure airport code as a variable
		depart.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		TimeUnit.SECONDS.sleep(1);
		depart.sendKeys("SAN");
		TimeUnit.SECONDS.sleep(1);
		depart.sendKeys(Keys.ENTER);
		TimeUnit.SECONDS.sleep(1);
		
		//deletes current arrival airport code and enters in SFO
		WebElement arrival = driver.findElement(By.id("LandingAirBookingSearchForm_destinationAirportCode")); //save web element for arrival airport code as a variable
		arrival.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		TimeUnit.SECONDS.sleep(1);
		arrival.sendKeys("SFO");
		TimeUnit.SECONDS.sleep(1);
		arrival.sendKeys(Keys.ENTER);
		TimeUnit.SECONDS.sleep(1);
	}
}
