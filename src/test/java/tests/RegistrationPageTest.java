package tests;


import org.testng.annotations.Test;

import base.BaseTest;
import page.RegistrationPage;
import utils.Log;
public class RegistrationPageTest extends BaseTest {
	
	@Test(description="Valid Registration")
	public void RegisterValidUser() {
		RegistrationPage register = new RegistrationPage(driver);
		Log.info("clicking register button");
		register.ClickRegisterBtn();
		Log.info("Entering user information");
		register.EnterFirstName("TestFirstName");
		register.EnterLastName("TestLastName");
		register.EnterAddress("1127 Textile Pl");
		register.EnterCity("TestPoint");
		register.EnterState("NC");
		register.EnterZipCode(12345);
		register.EnterPhoneNo(980258741);
		register.EnterSSN(987654321);
		register.EnterPassword("Pass123");
		register.EnterPasswordRepeat("Pass123");
		Log.info("Clicking submit button");
		register.ClickSubmitBtn();
		System.out.println(driver.getTitle());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	

	
	
	
	

}
