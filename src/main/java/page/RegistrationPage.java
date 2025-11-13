package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

	protected WebDriver driver;
	
	//Page Element locators
	@FindBy(linkText="Register")
	WebElement RegisterBtn;
	@FindBy(id="customer.firstName")
	WebElement CustFirstNameTextBox;
	@FindBy(id="customer.lastName")
	WebElement CustLastNameTextBox;
	@FindBy(id="customer.address.street")
	WebElement CustAddressTextBox;
	@FindBy(id="customer.address.city")
	WebElement CustCityTextBox;
	@FindBy(id="customer.address.state")
	WebElement CustStateTextBox;
	@FindBy(id="customer.address.zipCode")
	WebElement CustZipCodeTextBox;
	@FindBy(id="customer.phoneNumber")
	WebElement CustPhoneNumberTextBox;
	@FindBy(id="customer.ssn")
	WebElement CustSSNTextBox;
	@FindBy(id="customer.username")
	WebElement CustUsernameTextBox;
	@FindBy(id="customer.password")
	WebElement CustPasswordTestBox;
	@FindBy(id="repeatedPassword")
	WebElement CustPasswordRepeatTextBox;
	@FindBy(className="button")
	WebElement SubmitButton;
	
	//declaring constructor
	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//Actions on the webelements
	public void ClickRegisterBtn(){
		RegisterBtn.click();
	}
		
	public void EnterFirstName(String FirstName) {
		CustFirstNameTextBox.clear();
		CustFirstNameTextBox.sendKeys(FirstName);
	}
	public void EnterLastName(String LastName) {
		CustLastNameTextBox.clear();
		CustLastNameTextBox.sendKeys(LastName);
	}
	
	public void EnterAddress(String Address) {
		CustAddressTextBox.clear();
		CustAddressTextBox.sendKeys(Address);
	}
	public void EnterCity(String City) {
		CustCityTextBox.clear();
		CustCityTextBox.sendKeys(City);
	}
	
	public void EnterState(String State) {
		CustStateTextBox.clear();
		CustStateTextBox.sendKeys(State);
	}
	public void EnterZipCode(int ZipCode) {
		CustZipCodeTextBox.clear();
		CustZipCodeTextBox.sendKeys(String.valueOf(ZipCode));
	}
	
	public void EnterPhoneNo(int PhoneNo) {
		CustPhoneNumberTextBox.clear();
		CustPhoneNumberTextBox.sendKeys(String.valueOf(PhoneNo));
	}
	public void EnterSSN(int SSN) {
		CustSSNTextBox.clear();
		CustSSNTextBox.sendKeys(String.valueOf(SSN));
	}
	public void EnterUsername(String Username) {
		CustUsernameTextBox.clear();
		CustUsernameTextBox.sendKeys(Username);
	}
	public void EnterPassword(String Password) {
		CustPasswordTestBox.clear();
		CustPasswordTestBox.sendKeys(Password);
	}
	public void EnterPasswordRepeat(String Password) {
		CustPasswordRepeatTextBox.clear();
		CustPasswordRepeatTextBox.sendKeys(Password);
	}
	public void ClickSubmitBtn() {
		SubmitButton.click();
	}
	
	
	
}
