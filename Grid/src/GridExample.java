import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

//Code to start a selenium test using Grid

public class GridExample {

	public static void main (String[] args) throws MalformedURLException {
		
		//set browser and operating system
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WINDOWS);
		
		//create the driver with the setting above using the address of the grid hub
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:PORT/wd/hub"), dc); //port for hub
		driver.get("http://google.com");
		
	}
}
