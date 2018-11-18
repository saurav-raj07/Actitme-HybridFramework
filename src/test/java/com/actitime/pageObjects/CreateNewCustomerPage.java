package com.actitime.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CreateNewCustomerPage {
	
	@FindBy(xpath = "//input[@name='name']")
	private WebElement custNameTxtBx;
	
	@FindBy(name="description")
	private WebElement custDescTxtBx;
	
	@FindBy(name="createCustomerSubmit")
	private WebElement createCustBtn;
	

	//Constructor
	public CreateNewCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void createnewCustFunction(String customerName,String description) {
		custNameTxtBx.sendKeys(customerName);
		custDescTxtBx.sendKeys(description);
		createCustBtn.click();
		Reporter.log("--> New Customer Created", true);
	}
}
