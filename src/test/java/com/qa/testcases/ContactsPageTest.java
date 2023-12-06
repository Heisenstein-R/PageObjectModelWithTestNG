package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LogInPage;
import com.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	ContactsPage contactspage;
	LogInPage loginpage;
	HomePage homepage;

	String sheet = "Sheet1";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void Setup() {
		Initialization();
		contactspage = new ContactsPage();
		loginpage = new LogInPage();

		homepage = loginpage.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		homepage.ClickOnContactsPage();
	}

	@Test(priority = 1)
	public void vefiryContactsPageTitle() {
		boolean b = contactspage.VerifyContactsPageTitle();
		Assert.assertTrue(b, "Contacts label is missing on the page");
	}

	@Test(priority = 2)
	public void SelectContactByName() {
		contactspage.SelectContactsOnContactsPageByName("Momma K");
	}

	@Test(priority = 3)
	public void SelectContactByAllName() {
		contactspage.SelectContactsOnContactsPageByName("Momma K");
		contactspage.SelectContactsOnContactsPageByName("Raju  K");
	}

	@DataProvider
	public Object[][] getTestDataFromXL() {
		Object data[][] = TestUtil.getTestData(sheet);
		return data;
	}

	@Test(priority = 4, dataProvider = "getTestDataFromXL")
	public void CreatingNewContactOnContactPage(String firstname, String lastname, String emailAddress,
			String streetAddress, String city, String state, String postcode, String Country) {
		homepage.ClickOnContactsPage();
//		contactspage.FillingContactsPageForm("Raja", "K", "Rajak@mail.com", "Kukatpally", "Hyderabad", "Telangana",
//				"500072", "India");
		contactspage.FillingContactsPageForm(firstname, lastname, emailAddress, streetAddress, city, state, postcode,
				Country);
	}

	@AfterMethod
	public void closetheBrowser() {
		String title = homepage.LogoutFromHomePage();
		Assert.assertEquals(title, "Cogmento CRM", "Logout PAge Title Didn't Match");
		driver.quit();
	}

}
