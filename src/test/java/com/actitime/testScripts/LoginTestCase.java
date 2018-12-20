package com.actitime.testScripts;


import org.testng.annotations.Test;

import com.actitime.generics.BaseLib;
import com.actitime.generics.ExcelUtilitiesLib;
import com.actitime.generics.PropUtilityLib;
import com.actitime.pageObjects.EnterTimeTrackPage;
import com.actitime.pageObjects.LoginPage;

public class LoginTestCase extends BaseLib {

	
	private final LoginPage loginPage = new LoginPage(driver);
	private final EnterTimeTrackPage enterTimeTrackPage = new EnterTimeTrackPage(driver);
	private final String username = PropUtilityLib.readProp("id");
	private final String password = PropUtilityLib.readProp("password");

	@Test(priority=1,enabled=true)
	public void loginTest()  {
		
		loginPage.loginFunction(username, password);		
		enterTimeTrackPage.verifyHomePageLogo();
		enterTimeTrackPage.verifyHomePageTitle();
	}

	@Test(priority=2, enabled=true)
	public void invalidLoginTest() {

		String username = ExcelUtilitiesLib.readData("MyTestDataSheet", 1, 1);
		String password = ExcelUtilitiesLib.readData("myTestDataSheet", 1, 2);
		loginPage.loginFunction(username, password);
		loginPage.invalidLoginFunction();
	}

}
