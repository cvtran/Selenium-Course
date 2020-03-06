import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tables {

	public static void main (String[] args) throws InterruptedException {
		
		//start chrome driver and navigate to nfl.com
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chomedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //declare implicit wait
		driver.get("https://www.nfl.com/standings");
		
		WebElement table = driver.findElement(By.cssSelector("table[class='css-rhj265']"));
		
		//int rowCount = table.findElements(By.cssSelector("tbody.css-0")).size();
		
		int count = table.findElements(By.cssSelector("tbody.css-0 td:nth-child(2)")).size();
		
		//System.out.println(count);
		
		//gets the number of wins of all teams in the AFC (print the 2nd column)
		for (int i = 0; i < count; i++) {
			System.out.println(table.findElements(By.cssSelector("tbody.css-0 td:nth-child(2)")).get(i).getText());
		}
		
		TimeUnit.SECONDS.sleep(3);
		driver.quit();
		
	}
}
