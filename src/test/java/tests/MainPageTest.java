package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import page.MainPage;

public class MainPageTest extends BaseTest {
	@Test
	public void ClickRegisterBtn() {
		MainPage main = new MainPage(driver);
		main.ClickRegisterBtn();
		
	}
	
	
	
	
	
	
	

}
