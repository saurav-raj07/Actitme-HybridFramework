package com.actitime.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;


public class EnterTimeTrackPage extends BasePage{
	
	WebDriver driver;
	
	//Constructor
	public EnterTimeTrackPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);

	}
	
	
	public void verifyHomePageTitle() {
		String exp="actiTIME - Enter Time-Track";
		String act=driver.getTitle();
		Assert.assertEquals(act, exp);
		Reporter.log("--> Home Page Title is Verified", true);
	}
	

}
