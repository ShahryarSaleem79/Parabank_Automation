package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
	
	protected WebDriver driver;
	
	@FindBy(linkText="Register")
	WebElement RegisterBtn;
	
	//constructor declaration
	public MainPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}

	//Actions
	public void ClickRegisterBtn() {
		RegisterBtn.click();
	}
	
	
}
