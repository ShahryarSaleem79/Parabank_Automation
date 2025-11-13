package tests;


import org.testng.annotations.Test;

import base.BaseTest;
import page.RegistrationPage;
public class RegistrationPageTest extends BaseTest {
	
	@Test(description="Valid Registration")
	public void RegisterValidUser() {
		RegistrationPage register = new RegistrationPage(driver);
		register.ClickRegisterBtn();
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
		register.ClickSubmitBtn();
		System.out.println(driver.getTitle());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	

	
	
	
	

}
