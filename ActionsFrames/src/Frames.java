import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//Tutorial on frames

public class Frames {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chomedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/"); //navigate to google signup
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame"))); //switch to frame
		
		//drag and drop elements
		Actions a = new Actions(driver);
		a.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.cssSelector("div#droppable"))).build().perform();
		
		driver.switchTo().defaultContent(); //switch back to the page
		
		TimeUnit.SECONDS.sleep(5); //for testing purposes
		driver.quit();
	}
}
