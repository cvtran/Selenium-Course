import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {
		
//selenium code-
		//Create Driver object for chrome browser
		
		//invoke .exe file
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chomedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://google.com"); //hit url on the browser
		System.out.println(driver.getTitle()); //validate if page title is correct
		System.out.println(driver.getCurrentUrl()); //validate if landed on correct url
		
		//System.out.println(driver.getPageSource()); //print page source
		
		driver.get("http://yahoo.com");
		driver.navigate().back();
		driver.navigate().forward();
		driver.close(); //closes current browser
		//driver.quit(); //closes all browsers opened by selenium script
		
	}
}
