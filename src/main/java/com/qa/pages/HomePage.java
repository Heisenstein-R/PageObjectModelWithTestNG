package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
	@FindBy(xpath = "//span[text()='Raju K']")
	WebElement myNameOnHomePage;
	
	@FindBy(xpath = "//i[@class = 'home icon']")
	WebElement HomeIcon;
	
	@FindBy(xpath = "//span[text() = 'Contacts']")
	WebElement ContactsBtn;
	
	@FindBy(xpath = "//span[text() = 'Deals']")
	WebElement DealsBtn;
	
	@FindBy(xpath = "//span[text() = 'Tasks']")
	WebElement TasksBtn;
	
	@FindBy(xpath = "//div[@role='listbox']")
	WebElement SettingsListbox;
	
	@FindBy(xpath = "//a//span[contains(text(), 'Log Out')]")
	WebElement LogOutBtn;
	
	
	
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean VerifyMyNameOnHomePage() {
		return myNameOnHomePage.isDisplayed();
	}
	
	public ContactsPage ClickOnContactsPage() {
		actions.moveToElement(HomeIcon);
		ContactsBtn.click();
		
		return new ContactsPage();
	}
	
	public DealsPage ClickOnDealsPage() {
		actions.moveToElement(HomeIcon);
		DealsBtn.click();
		
		return new DealsPage();
	}
	
	public TasksPage ClickOnTasksPage() {
		actions.moveToElement(HomeIcon);
		TasksBtn.click();
		
		return new TasksPage();
	}
	
	
//	public ContactsPage ClickOnCreateNewContact() {
//		actions.moveToElement(HomeIcon);
//		ContactsBtn.click();
//		CreateContactButton.click();
//		
//		return new ContactsPage();
//	}
	
	public String LogoutFromHomePage() {
		SettingsListbox.click();
		LogOutBtn.click();
		return driver.getTitle();
	}
	
	
	
	
}
