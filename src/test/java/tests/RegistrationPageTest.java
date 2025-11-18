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
	public void RegisterValidUser(String firstName, String lastName, String Address, String City, String State, String ZipCode,
			String PhoneNo, String SSN, String userName, String Password, String confirmPassword ) {
		//add the test function and then only it will work
		test = ExtentReportManager.createTest("Registration");
		RegistrationPage register = new RegistrationPage(driver);
		Log.info("clicking register button");
		register.ClickRegisterBtn();
		test.info("Register button clicked");
		Log.info("Entering user information");
		register.EnterFirstName(firstName);
		register.EnterLastName(lastName);
		register.EnterAddress(Address);
		register.EnterCity(City);
		register.EnterState(State);
		register.EnterZipCode(ZipCode);
		register.EnterPhoneNo(PhoneNo);
		register.EnterSSN(SSN);
		register.EnterUsername(userName);
		register.EnterPassword(Password);
		register.EnterPasswordRepeat(confirmPassword);
		test.info("Credentials entered");
		Log.info("Clicking submit button");
		register.ClickSubmitBtn();
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(),"ParaBank | About Us" );
		test.pass("Registration Successful");
		
		
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	

	
	
	
	

}
