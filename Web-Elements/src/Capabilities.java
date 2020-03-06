import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Capabilities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//allow capabilities for a chrome profile
		DesiredCapabilities ch = DesiredCapabilities.chrome();
		//ch.acceptInsecureCerts(); //works similiar to as below
		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		
		//set local browser setting and start the driver
		ChromeOptions c = new ChromeOptions();
		c.merge(ch);
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chomedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(c);
	}

}
