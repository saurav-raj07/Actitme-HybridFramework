package com.actitime.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.actitime.generics.WaitStatementLib;

public class EnterTimeTrackPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//img[contains(@src,'logo.png')]")
	private WebElement homePageActiTimeLogo;
	

	public EnterTimeTrackPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);

	}
	
	public void verifyHomePageLogo() {
		WaitStatementLib ws = new WaitStatementLib(driver);
		ws.eWait(3, homePageActiTimeLogo);
		Reporter.log("--> Home page displayed", true);
	}

}
