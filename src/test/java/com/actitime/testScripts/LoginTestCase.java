package com.actitime.testScripts;


import org.testng.annotations.Test;

import com.actitime.generics.BaseLib;
import com.actitime.generics.ExcelUtilitiesLib;
import com.actitime.generics.PropUtilityLib;
import com.actitime.pageObjects.EnterTimeTrackPage;
import com.actitime.pageObjects.LoginPage;

public class LoginTestCase extends BaseLib {

	LoginPage lp;
	EnterTimeTrackPage etp;

	@Test(priority=1)
	public void loginTest()  {
		String username = PropUtilityLib.readProp("id");
		String password = PropUtilityLib.readProp("password");
		lp = new LoginPage(driver);
		lp.loginFunction(username, password);
		etp = new EnterTimeTrackPage(driver);
		etp.verifyHomePageLogo();
	}

	@Test(priority=2)
	public void invalidLoginTest() {

		String username = ExcelUtilitiesLib.readData("MyTestDataSheet", 1, 1);
		String password = ExcelUtilitiesLib.readData("myTestDataSheet", 1, 2);
		lp= new LoginPage(driver);
		lp.loginFunction(username, password);
		lp.invalidLoginFunction();
	}

}
