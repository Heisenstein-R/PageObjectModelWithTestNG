package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LogInPage extends TestBase{
	
	//Page Factory - OR
	@FindBy(xpath = "//span[text() = 'Log In']")
	WebElement logInButtonOnMainPage;
	
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//div[text()='Login']")
	WebElement LoginBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement SignUpBtn;
	
	@FindBy(xpath = "//div[@class='rd-navbar-brand']//a[@title='free crm home']")
	WebElement freeCRMLogo;
	
	//Initializing the Page Objects
	public LogInPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String ValidateLoginPageTitle() {
		return driver.getTitle();
	}   
	
	public boolean ValidateCRMLOGOImage() {
		return freeCRMLogo.isDisplayed();
	}
	
	public HomePage Login(String un, String pw) {
		logInButtonOnMainPage.click();
		email.sendKeys(un);
		password.sendKeys(pw);
		LoginBtn.click();
		
		return new HomePage();
	}

}
