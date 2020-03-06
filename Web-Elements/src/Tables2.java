import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

//check if first column is sorted alphabetically

public class Tables2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//start chrome driver and navigate to sorting columns tutorial page
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chomedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//sorts the column by ascending order(2 clicks) or descending order (1 click)
		//driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();
		driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();
		
		
		List<WebElement> firstColList = driver.findElements(By.cssSelector("tr td:nth-child(2)"));
		
		ArrayList<String> originalList = new ArrayList<String>();
		
		//get first column
		for(int i = 0; i < firstColList.size(); i++) {
			originalList.add(firstColList.get(i).getText());
		}
		
		//copies the list
		ArrayList<String> copiedList = new ArrayList<String>();
		for(int i = 0; i < originalList.size(); i++) {
			copiedList.add(originalList.get(i));
		}
		
		Collections.sort(copiedList); //sorts copied list ascending order
		Collections.reverse(copiedList); //reverses the copied list for descending order
		
		Assert.assertTrue(originalList.equals(copiedList)); //checks to see if the sorted list is the same as the original list
		
		TimeUnit.SECONDS.sleep(3);
		driver.quit();
		
	}

}
