package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LogInPage;

public class HomePageTest extends TestBase {
	
	LogInPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	
	public HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void Setup() {
		Initialization();
		loginpage = new LogInPage();
		
		homepage = loginpage.Login(prop.getProperty("Username"), prop.getProperty("Password"));
	}
	
	
	@Test(priority = 1)
	public void PageTitleTest() {
		String title = homepage.VerifyHomePageTitle();
		System.out.println("Tiltele of the Home Page is: "+title);
		Assert.assertEquals(title, "Cogmento CRM", "Home page title not Matched");
	}
	
	@Test(priority = 2)
	public void VerifyTheUsernameOnPage() {
		boolean b = homepage.VerifyMyNameOnHomePage();
		Assert.assertTrue(b, "Name on Page isn't retrieved, login failed");
	}
	
	@Test(priority = 3)
	public void VerifyContactsPage() {
		contactspage = homepage.ClickOnContactsPage();
		System.out.println(driver.getCurrentUrl());
	}
	
	@AfterMethod
	public void CloseBrowser() {
		String title = homepage.LogoutFromHomePage();
		Assert.assertEquals(title, "Cogmento CRM", "Logout PAge Title Didn't Match");
		driver.close();
	}
		
}
