package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import page.MainPage;
import utils.Log;

public class MainPageTest extends BaseTest {
	@Test
	public void Registration() {
		
		Log.info("Application launched successfully");
		test.info("Application launched successfully");
		MainPage main = new MainPage(driver);
		Log.info("Clicking Register button");
		test.info("Clicking Register button");
		main.ClickRegisterBtn();
		Log.info("Register button clicked");
		test.info("Register button clicked");
		Log.info("Navigating to Registration page");
		test.info("Navigating to Registration page");
		test.pass("Register button clicked and navigated to Registration page");
		
	}
	
	
	
	
	
	
	

}
