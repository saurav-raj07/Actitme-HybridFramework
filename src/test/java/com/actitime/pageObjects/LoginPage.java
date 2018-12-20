package com.actitime.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

//import com.actitime.loggers.LoggerLib;

public class LoginPage {

	WebDriver driver;

	@FindBy(name = "username")
	private WebElement userNameTxtBox;

	@FindBy(name = "pwd")
	private WebElement passwordTxtBox;

	@FindBy(id = "loginButton")
	private WebElement loginButton;

	@FindBy(xpath = "//img[contains(@src,'timer.gif')]")
	private WebElement LoginPageActitimeLogo;

	@FindBy(xpath = "//span[contains(text(),'Username or Password is invalid')]")
	private WebElement invalidLoginMessage;

	// Constructor
	public LoginPage(WebDriver driver) {

		this.driver = driver;
		/*
		 * this is to match the driver in the LoginPage class (In line 14) with the
		 * driver instance passed from the invoking class
		 */
		PageFactory.initElements(driver, this);
	}

	public void loginFunction(String username, String password) {
		userNameTxtBox.sendKeys(username);
		Reporter.log("--> Username entered", true);
		passwordTxtBox.sendKeys(password);
		Reporter.log("--> Password entered", true);
		loginButton.click();
		Reporter.log("--> Logged Button Clicked", true);
	}

	public void invalidLoginFunction() {
		String act = invalidLoginMessage.getText();
		String exp = "Username or Password is invalid. Please try again.";
		Assert.assertEquals(act, exp);
		Reporter.log("--> Invalid Login",true);
		Reporter.log(act, true);

	}

}
