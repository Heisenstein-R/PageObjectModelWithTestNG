package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LogInPage;

public class LoginPageTest extends TestBase{
	
	public static LogInPage loginpage;
	HomePage Homepage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void Setup() {
		Initialization();
		loginpage = new LogInPage();
	}
	
	@Test(priority = 1)
	public void LoginPageTitleTest() {
		String title = loginpage.ValidateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM Power Up your Entire Business Free Forever");
	}
	
	@Test(priority = 2)
	public void LoginButtonVisibilityTest() {
		boolean b = loginpage.ValidateCRMLOGOImage();
		Assert.assertTrue(b);
		
	}
	
	@Test(priority = 3)
	public void LoginTest() {
		Homepage = loginpage.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		boolean b = Homepage.VerifyMyNameOnHomePage();
		Assert.assertTrue(b);
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	

}
