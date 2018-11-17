package com.actitime.testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.actitime.generics.BaseLib;
import com.actitime.generics.PropUtilityLib;
import com.actitime.pageObjects.LoginPage;

public class LoginTestCase extends BaseLib {

	@Test
	public void LoginFunction() throws InterruptedException, IOException {
		String username = PropUtilityLib.readProp("id");
		String password = PropUtilityLib.readProp("password");
		LoginPage lp = new LoginPage(driver);
		lp.LoginFunction(username, password);

	}

}
