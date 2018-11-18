package com.actitime.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class OpenTasksPage {

	WebDriver driver;

	@FindBy(xpath = "//a[text()='Projects & Customers']")
	private WebElement projNCustLink;

	public OpenTasksPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyOpenTaskPageTitle() {

		String act = "actiTIME - Open Tasks";
		String exp = driver.getTitle();
		Assert.assertEquals(act, exp);
	}

	public void clickOnProjNCustBtn() {
		projNCustLink.click();
		Reporter.log("--> Navigated to Active Project & Customer", true);
	}

}
