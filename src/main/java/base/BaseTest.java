package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	protected WebDriver driver;
	
	//Setting Up things
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
//	@AfterMethod
	//Tearing down things
//	public void tearDown() {
//		if (driver!=null) {
//			driver.close();
//		}
//	}

}
