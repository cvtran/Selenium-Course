import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Tutorial on navigating different windows

public class Windows {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chomedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://accounts.google.com/signup"); //navigate to google signup
		
		//click help
		driver.findElement(By.xpath("//*[@id=\"initialView\"]/footer/ul/li[1]/a")).click();
		
		System.out.println("Parent Title: " + driver.getTitle()); //prints parent window's title

		//get and save ids of parent and child windows
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator(); 
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId); //switch to child window
		
		System.out.println("Child Title: " + driver.getTitle()); //prints child window's title
		
		driver.switchTo().window(parentId); //switch to parent window
		
		System.out.println("Parent Title: " + driver.getTitle()); //prints parent window's title
		
		
		TimeUnit.SECONDS.sleep(5); //for testing purposes
		driver.quit();
	}
}
