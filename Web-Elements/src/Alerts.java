import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//start webdriver and navigate to southwest.com
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chomedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		TimeUnit.SECONDS.sleep(1);
		
		//enter text into the alert test text field and click alert
		driver.findElement(By.id("name")).sendKeys("text");
		driver.findElement(By.cssSelector("[id='alertbtn']")).click();
		TimeUnit.SECONDS.sleep(1);
		
		//accepts the alert
		driver.switchTo().alert().accept();
		TimeUnit.SECONDS.sleep(1);
		
		//click confirm button
		driver.findElement(By.id("confirmbtm")).click();
		TimeUnit.SECONDS.sleep(1);
		
		//driver.switchTo().alert().accept(); //accept alert
		driver.switchTo().alert().dismiss(); //dismiss alert (no or cancel)
		
		driver.quit();
	}

}
