package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

	// creating two instances of the ExtentReportManager class

	private static ExtentReports extent;
	private static ExtentTest test;

	public static ExtentReports getReportInstance() {
		if (extent == null) {
			// adding code to setup the report
			// setting timestamp to get unique report everytime
			String timestamp = new SimpleDateFormat("yyyy-MM-DD_HH_MM_SS").format(new Date());
			// declaring reportpath
			String reportpath = System.getProperty("user.dir")+"/reports/ExtentReport_" + timestamp + ".html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(reportpath);
			// setting document title and report name
			reporter.config().setDocumentTitle("Automation Test Report");
			reporter.config().setReportName("Test Execution Report");
			// using the ExtentReports variable
			extent = new ExtentReports();
			extent.attachReporter(reporter);

		}
		return extent;

	}

	public static ExtentTest createTest(String testName) {
		test = getReportInstance().createTest(testName);
		return test;
	}

	public static String captureScreenshot(WebDriver driver, String screenshotName) {
		try {
			//declaring file where screenshot is stored
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir")+"/screenshot/"+ screenshotName +" .png";
			System.out.println("Path for screenshot is...."+ path);
			FileUtils.copyFile(src, new File(path));
			return path;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
		
		
		
	}
	
	
	
	
	
	
}
