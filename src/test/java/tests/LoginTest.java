package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import page.LoginPage;
import utils.Log;

public class LoginTest extends BaseTest {

	@Test
	public void ValidLogin() {
		
		Log.info("Application launched successfully");
		test.info("Application launched successfully");
		LoginPage login = new LoginPage(driver);
		Log.info("Entering valid username");
		test.info("Entering valid username");
		login.EnterUsername();
		Log.info("Entering valid password");
		test.info("Entering valid password");
		login.EnterPassword();
		Log.info("Clicking login button");
		test.info("Clicking login button");
		login.ClickLoginBtn();

		Assert.assertEquals(driver.getTitle(), "ParaBank | Accounts Overview");
		test.pass("Login Successful");
	}

	@Test
	public void InvalidLogin() {
		
		Log.info("Application launched successfully");
		test.info("Application launched successfully");
		LoginPage login = new LoginPage(driver);
		Log.info("Entering valid username");
		test.info("Entering Valid username");
		login.EnterUsername();
		Log.info("Entering invalid password");
		test.info("Entering invalid password");
		login.EnterInvalidPassword();
		Log.info("Clicking login button");
		test.info("Clicking login button");
		login.ClickLoginBtn();

		Assert.assertEquals(driver.getTitle(), "ParaBank | Error");
		test.pass("Login Failed as expected");
	}
}
