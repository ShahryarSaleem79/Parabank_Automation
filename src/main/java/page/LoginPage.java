package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	protected WebDriver driver;

	@FindBy(name = "username")
	WebElement UsernameTextBox;

	@FindBy(name = "password")
	WebElement PasswordTextBox;

	@FindBy(xpath = "//input[@value='Log In']")
	WebElement LoginBtn;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void EnterUsername() {
		UsernameTextBox.clear();
		UsernameTextBox.sendKeys("john");
	}

	public void EnterPassword() {
		PasswordTextBox.clear();
		PasswordTextBox.sendKeys("demo");
	}

	public void ClickLoginBtn() {
		LoginBtn.click();
	}
	
	public void EnterInvalidPassword() {
		UsernameTextBox.clear();
		UsernameTextBox.sendKeys("test");
	}
	
}
