package com.actitime.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPage {

	@FindBy(name = "username")
	private WebElement userNameTxtBox;

	@FindBy(name = "pwd")
	private WebElement passwordTxtBox;

	@FindBy(id = "loginButton")
	private WebElement loginButton;

	@FindBy(xpath = "//img[contains(@src,'timer.gif')]")
	private WebElement ActitimeLogo;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void LoginFunction(String userName,String password) throws InterruptedException {
		userNameTxtBox.sendKeys(userName);
		Reporter.log("--> username entered",true);
		passwordTxtBox.sendKeys(password);
		Reporter.log("--> password entered",true);
		Thread.sleep(2000);
		loginButton.click();
		Reporter.log("--> Login button clicked",true);
		Thread.sleep(5000);
	}

}
