package com.actitime.testScripts;

import org.testng.annotations.Test;

import com.actitime.generics.BaseLib;
import com.actitime.pageObjects.LoginPage;

public class LoginTestCase extends BaseLib{
	
	@Test
	public void LoginFunction() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.LoginFunction("admin", "manager");
		
		
	}

}
