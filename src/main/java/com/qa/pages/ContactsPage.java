package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//span[@class = 'selectable ' and text() = 'Contacts']")
	WebElement ContactsTitleonPage;

	@FindBy(xpath = "//a[text() = 'Momma K']//parent::td//preceding-sibling::td//input")
	WebElement MommaCheeckBox;

	@FindBy(xpath = "//a//button[text() = 'Create']")
	WebElement CreateContactsButton;

	@FindBy(xpath = "//input[@name = 'first_name']")
	WebElement enterFirstName;

	@FindBy(xpath = "//input[@name = 'last_name']")
	WebElement enterLastName;

	@FindBy(xpath = "//input[@placeholder = 'Email address']")
	WebElement enterEmailAddress;

	@FindBy(xpath = "//input[@placeholder='Street Address']")
	WebElement StreetAddress;

	@FindBy(xpath = "//input[@placeholder='City']")
	WebElement City;

	@FindBy(xpath = "//input[@placeholder='State / County']")
	WebElement State;

	@FindBy(xpath = "//input[@placeholder='Post Code']")
	WebElement postCode;

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean VerifyContactsPageTitle() {
		return ContactsTitleonPage.isDisplayed();
	}

	public void SelectContactsOnContactsPageByName(String name) {
		actions.moveToElement(driver.findElement(By.xpath("//button[text()='Show Filters']"))).perform();
		driver.findElement(By.xpath("//a[text() = '" + name + "']//parent::td//preceding-sibling::td//div")).click();
	}

	public void FillingContactsPageForm(String firstname, String lastname, String emailAddress, String streetAddress,
			String city, String state, String postcode, String Country) {

		CreateContactsButton.click();
		enterFirstName.sendKeys(firstname);
		enterLastName.sendKeys(lastname);
		enterEmailAddress.sendKeys(emailAddress);
		StreetAddress.sendKeys(streetAddress);
		City.sendKeys(city);
		State.sendKeys(state);
		postCode.sendKeys(postcode);

		driver.findElement(By.xpath("//input[@type = 'text']/parent::div[@name = 'country']/child::i")).click();

		List<WebElement> countrieslist = driver.findElements(
				By.xpath("//div[@name = 'country']//div[@role = 'listbox']//div[@role = 'option']/child::span"));

		for (int i = 0; i < countrieslist.size(); i++) {
			String country = countrieslist.get(i).getText();
//			System.out.println(countrieslist.get(i));
//			System.out.println("    ========>    " + country);
			if (country.equalsIgnoreCase(Country)) {
				
				countrieslist.get(i).click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//button[text() = 'Save']")).click();
		driver.findElement(By.xpath("//div//span[text() = '"+firstname+" "+lastname+"']")).isDisplayed();
	}

}
