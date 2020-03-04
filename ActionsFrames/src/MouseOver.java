import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//Tutorial on actions in Selenium

public class MouseOver {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chomedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.com"); //navigate to amazon.com
		Actions a = new Actions(driver);
		WebElement account = driver.findElement(By.id("nav-link-accountList"));
		
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		//mouse over account button and left click
		a.moveToElement(account).contextClick().build().perform();

		
		TimeUnit.SECONDS.sleep(5); //for testing purposes
		driver.quit();
	}

}
