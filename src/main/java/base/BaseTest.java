package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import utils.ExtentReportManager;
import utils.Log;

public class BaseTest {
	
	protected WebDriver driver;
	protected static ExtentReports extent;
	protected static ExtentTest test;
	//Calling the report instance
	@BeforeSuite
	public void setupReport() {
		extent = ExtentReportManager.getReportInstance();
	}
	@AfterSuite
	public void teardownReport() {
		extent.flush();
	}
	
	
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
	public void tearDown(ITestResult result) {
		if(result.getStatus()== ITestResult.FAILURE) {
			String screenshotPath = ExtentReportManager.captureScreenshot(driver, "Failure");
			test.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		if (driver!=null) {
			Log.info("closing browser");
			driver.close();
		}
	}

}
