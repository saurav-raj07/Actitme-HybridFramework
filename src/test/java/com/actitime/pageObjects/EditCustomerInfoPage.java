package com.actitime.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class EditCustomerInfoPage {

	@FindBy(xpath = "//span[@class='formsummarytext']")
	private WebElement customerToBeDeleted;
	
	@FindBy(xpath="//input[@value='Delete This Customer']")
	private WebElement deleteThisCustomerBtn;
	
	@FindBy(xpath="//input[@value='Delete Customer']")
	private WebElement deleteCustomerConfirmation;

	// Constructor
	public EditCustomerInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void verifyCustomerBeforeDelete(String customerName) {
		Assert.assertEquals(customerName, customerToBeDeleted.getText());
		Reporter.log("--> Custome verified before deletion",true);
	}
	
	public void deleteCustomer() {
		deleteThisCustomerBtn.click();
		deleteCustomerConfirmation.click();
		Reporter.log("--> Customer Deleted", true);
	}

}
