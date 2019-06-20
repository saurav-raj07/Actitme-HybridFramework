package com.actitime.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.actitime.generics.WaitStatementLib;

public abstract class BasePage {
	
	WebDriver driver;

	@FindBy(xpath = "//img[contains(@src,'logo.png')]")
	private WebElement homePageActiTimeLogo;
	
	@FindBy(xpath = "//div[text()='Tasks']")
	private WebElement tasksLink;

	// Constructor
	public BasePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyHomePageLogo() {
		WaitStatementLib ws = new WaitStatementLib(driver);
		ws.eWait(3, homePageActiTimeLogo);
		Reporter.log("--> Home page logo Verified", true);
	}

	public void clickOnTasksTab() {
		tasksLink.click();
		Reporter.log("--> Navigated to Tasks Tab",true);
	}
	
	abstract public void absMethod();
}
