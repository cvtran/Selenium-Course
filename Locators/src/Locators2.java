import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators2 {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chomedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://login.salesforce.com"); //go to salesforce login webpage
		TimeUnit.SECONDS.sleep(1);
		
		driver.findElement(By.id("username")).sendKeys("hello"); //type "hello" into email text input
		TimeUnit.SECONDS.sleep(1);
		
		driver.findElement(By.cssSelector("#password")).sendKeys("123456"); //type "123456" into password text input
		TimeUnit.SECONDS.sleep(1);
		
		//driver.findElement(By.xpath("//*[@id=\'forgot_password_link\']")).click(); //click forgot password link
		//TimeUnit.SECONDS.sleep(5);
		
		driver.findElement(By.xpath("//*[@id=\'Login\']")).click(); //click login button
		TimeUnit.SECONDS.sleep(1);
		
		System.out.println(driver.findElement(By.cssSelector("div#error.loginError")).getText()); //display login error message in console
		
		TimeUnit.SECONDS.sleep(2);
		driver.quit();
	}
	
}
