import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
	
	public static void main(String[] args) throws InterruptedException {
		
		//start webdriver
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chomedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://facebook.com");
		
		driver.findElement(By.id("email")).sendKeys("hello"); //type "hello" into email text input
		TimeUnit.SECONDS.sleep(5);
		
		driver.findElement(By.name("pass")).sendKeys("123456"); //type "123456" into password text input
		TimeUnit.SECONDS.sleep(5);
		
		driver.findElement(By.id("loginbutton")).click(); //click login button
		TimeUnit.SECONDS.sleep(10);
		

		driver.quit();
	}
}
