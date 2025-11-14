package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.Log;

public class BaseTest {
	
	protected WebDriver driver;
	
	//Setting Up things
	@BeforeMethod
	public void setUp() {
		Log.info("Starting driver");
		driver = new FirefoxDriver();
		Log.info("Maximizing window");
		driver.manage().window().maximize();
		Log.info("fetching url");
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		Log.info("adding implicit wait");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@AfterMethod
	//Tearing down things
	public void tearDown() {
		if (driver!=null) {
			Log.info("closing browser");
			driver.close();
		}
	}

}
