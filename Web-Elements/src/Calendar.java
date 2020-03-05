import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {
		
		//start chrome driver and navigate to southwest.com
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chomedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //declare implicit wait
		driver.get("http://southwest.com");
		
		//Open departure date
		driver.findElement(By.cssSelector("#LandingAirBookingSearchForm_departureDate")).click();
		
		//Navigate to July
		while(!driver.findElement(By.cssSelector("div.calendar-month--title")).getText().contains("July")) {
			
			driver.findElement(By.cssSelector("button[aria-label = 'Next Month'")).click();
		}
		
		driver.findElement(By.id("calendar-112-2020-07-13")).click(); //select July 13, 2020
		
		TimeUnit.SECONDS.sleep(5);
		driver.quit();
		
	}
}
