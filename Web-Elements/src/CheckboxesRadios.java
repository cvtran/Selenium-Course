import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckboxesRadios {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//start webdriver and navigate to southwest.com
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chomedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://southwest.com");
		TimeUnit.SECONDS.sleep(1);
		
		
		
		//select one-way trip radio
		driver.findElement(By.cssSelector("input[value='oneway']")).click();
		TimeUnit.SECONDS.sleep(1);
		
		//Using the WebElements.size() function, you can count the number of web elements based on the criteria of your choice
		//Counts the number of radio buttons
		System.out.println(driver.findElements(By.cssSelector("input[type='radio']")).size());
		TimeUnit.SECONDS.sleep(1);
		
		/*
		 * Assert is useful to see if WebElements are working properly
		 * Assert.assertFalse(WebElement.isSelected()); //checks if the value is false, if true, the test will stop here and throw an exception
		 * Assert.assertTrue(WebElement.isSelected()); //checks if the value is true, if false, the test will stop here and throw an exception
		 * Assert.assertEquals(WebElement.getText(), "sfddsa"): //checks if the text is equal, if they are not equal the test will stop here and throw an exception
		 * 
		 * 
		 * If it was a checkbox instead, you can use the following code to make sure you are selecting it and not deselecting it
		 * if (!driver.findElement(By.cssSelector("input[value='oneway']")).isSelected());
		 * 		driver.findElement(By.cssSelector("input[value='oneway']")).click();
		 */
		
		driver.quit();
	}

}
