package base;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
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
	public void setUp(Method method) {

	    test = ExtentReportManager.createTest(method.getName());

	    Log.info("Starting driver");

	    WebDriverManager.chromedriver().setup();

	    ChromeOptions options = new ChromeOptions();

	    if (System.getenv("GITHUB_ACTIONS") != null) {
	        options.addArguments("--headless=new");
	        options.addArguments("--no-sandbox");
	        options.addArguments("--disable-dev-shm-usage");
	    }

	    driver = new ChromeDriver(options);

	    driver.manage().window().maximize();

	    driver.get("https://parabank.parasoft.com/parabank/index.htm");

	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {

	    if (result.getStatus() == ITestResult.SUCCESS) {
	        test.pass("Test Passed");
	    }
	    else if (result.getStatus() == ITestResult.FAILURE) {

	        String screenshotPath =
	                ExtentReportManager.captureScreenshot(driver, result.getName());

	        test.fail(result.getThrowable(),
	                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    else if (result.getStatus() == ITestResult.SKIP) {
	        test.skip("Test Skipped");
	    }

	    driver.quit();
	}

}
