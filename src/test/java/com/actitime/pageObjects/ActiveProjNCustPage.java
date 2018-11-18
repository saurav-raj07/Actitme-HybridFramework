package com.actitime.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class ActiveProjNCustPage {

	@FindBy(xpath = "//input[@value='Create New Customer']")
	private WebElement createNewCustBtn;

	@FindBy(className = "successmsg")
	private WebElement NewCustSuccessMsg;

	@FindBy(xpath = "//td[@class='customer-cell'][contains(@id,'customerNameCell')]//a[contains(@href,'customerId')]")
	private List<WebElement> customerList;
	
	@FindBy(xpath="//span[@class='successmsg']")
	private WebElement customerDeletionSucessMsg;

	// Constructor
	public ActiveProjNCustPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clcOnCreateNewCustBtn() {
		createNewCustBtn.click();
	}

	public void verifyNewCust(String customerName) {

		Assert.assertTrue(NewCustSuccessMsg.isDisplayed());
		Assert.assertTrue(NewCustSuccessMsg.getText().contains(customerName));
		Reporter.log(NewCustSuccessMsg.getText(), true);
	}

	public void selectCustomer(String customerName) {

		for (WebElement mylist : customerList) {
			if (mylist.getText().equals(customerName)) {
				mylist.click();
				Reporter.log("--> Customer Selected", true);
				break;
			}
		}
	}
	
	public void verifyCustomerDeletion(String customerName) {
		Assert.assertTrue(customerDeletionSucessMsg.isDisplayed());
		
		for (WebElement mylist : customerList) {
			if (mylist.getText().equals(customerName)) {
				Reporter.log("--> Customer NOT DELETED properly", true);
				Assert.assertFalse(true);
				break;
			}
		}
		Reporter.log(customerDeletionSucessMsg.getText(),true);
		
	}

}
