package tests;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import base.BaseTest;
import page.RegistrationPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.Log;
public class RegistrationPageTest extends BaseTest {
	
	@DataProvider(name="RegistrationData")
	public Object[][] getRegistrationData() throws IOException{
		String filepath = System.getProperty("user.dir")+"/Testdata/Test_data_Registration.xlsx";
		ExcelUtils.loadExcel(filepath, "Sheet1");
		int rowCount = ExcelUtils.getRowCount();
		Object[][] data = new Object[rowCount-1][11];
		
		for(int i=1; i<rowCount; i++) {
			data[i-1][0]=ExcelUtils.getCellData(i, 0);
			data[i-1][1]=ExcelUtils.getCellData(i, 1);
			data[i-1][2]=ExcelUtils.getCellData(i, 2);
			data[i-1][3]=ExcelUtils.getCellData(i, 3);
			data[i-1][4]=ExcelUtils.getCellData(i, 4);
			data[i-1][5]=ExcelUtils.getCellData(i, 5);
			data[i-1][6]=ExcelUtils.getCellData(i, 6);
			data[i-1][7]=ExcelUtils.getCellData(i, 7);
			data[i-1][8]=ExcelUtils.getCellData(i, 8);
			data[i-1][9]=ExcelUtils.getCellData(i, 9);
			data[i-1][10]=ExcelUtils.getCellData(i,10);
			//data[i-1][11]=ExcelUtils.getCellData(i, 11);
		}
		ExcelUtils.closeExcel();
		return data;
	}
	
		
	@Test(dataProvider = "RegistrationData", description = "Valid Registration")
	public void RegisterUser(String firstName, String lastName, String Address, String City, String State, String ZipCode,
			String PhoneNo, String SSN, String userName, String Password, String confirmPassword ) {
		//add the test function and then only it will work
		
		Log.info("Application launched successfully");
		test.info("Application launched successfully");
		RegistrationPage register = new RegistrationPage(driver);
		Log.info("clicking register button");
		test.info("clicking register button");
		register.ClickRegisterBtn();
		Log.info("Navigated to Registration page");
		test.info("Navigated to Registration page");
		Log.info("Entering user information");
		test.info("Entering user information");
		register.EnterFirstName(firstName);
		Log.info("Entering last name");
		test.info("Entering last name");
		register.EnterLastName(lastName);
		Log.info("Entering address");
		test.info("Entering address");
		register.EnterAddress(Address);
		Log.info("Entering city");
		test.info("Entering city");
		register.EnterCity(City);
		Log.info("Entering state");
		test.info("Entering state");
		register.EnterState(State);
		Log.info("Entering zip code");
		test.info("Entering zip code");
		register.EnterZipCode(ZipCode);
		Log.info("Entering phone number");
		test.info("Entering phone number");
		register.EnterPhoneNo(PhoneNo);
		Log.info("Entering SSN");
		test.info("Entering SSN");
		register.EnterSSN(SSN);
		Log.info("Entering username");
		test.info("Entering username");
		register.EnterUsername(userName);
		Log.info("Entering password");
		test.info("Entering password");
		register.EnterPassword(Password);
		Log.info("Entering confirm password");
		test.info("Entering confirm password");
		register.EnterPasswordRepeat(confirmPassword);
		
		Log.info("Registration form submitted");
		test.info("Registration form submitted");
		register.ClickSubmitBtn();
		Log.info("Registration successful");
		test.info("Registration successful");
		System.out.println(driver.getTitle());
		Log.info("Dashoard displayed");
		test.info("Dashoard displayed");
		Assert.assertEquals(driver.getTitle(),"ParaBank | About Us" );
		test.pass("User Created Successfully");
		
		
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	

	
	
	
	

}
