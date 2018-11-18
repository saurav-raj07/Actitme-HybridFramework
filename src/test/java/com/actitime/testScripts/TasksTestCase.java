package com.actitime.testScripts;

import org.testng.annotations.Test;

import com.actitime.generics.BaseLib;
import com.actitime.generics.ExcelUtilitiesLib;
import com.actitime.generics.PropUtilityLib;
import com.actitime.pageObjects.ActiveProjNCustPage;
import com.actitime.pageObjects.CreateNewCustomerPage;
import com.actitime.pageObjects.EditCustomerInfoPage;
import com.actitime.pageObjects.EnterTimeTrackPage;
import com.actitime.pageObjects.LoginPage;
import com.actitime.pageObjects.OpenTasksPage;

public class TasksTestCase extends BaseLib {

	LoginPage lp;
	EnterTimeTrackPage etp;
	OpenTasksPage otp;
	ActiveProjNCustPage apc;
	CreateNewCustomerPage ccf;
	EditCustomerInfoPage eci;

	@Test(priority=1,enabled=true)
	public void createNewCustomer() {

		String username = PropUtilityLib.readProp("id");
		String password = PropUtilityLib.readProp("password");
		lp = new LoginPage(driver);
		lp.loginFunction(username, password);
		etp = new EnterTimeTrackPage(driver);
		etp.clickOnTasksTab();
		otp = new OpenTasksPage(driver);
		otp.verifyOpenTaskPageTitle();
		otp.clickOnProjNCustBtn();
		apc = new ActiveProjNCustPage(driver);
		apc.clcOnCreateNewCustBtn();
		String customerName = ExcelUtilitiesLib.readData("MyTestDataSheet", 2, 3);
		String description = ExcelUtilitiesLib.readData("myTestDataSheet", 2, 4);
		ccf= new CreateNewCustomerPage(driver);
		ccf.createnewCustFunction(customerName, description);
		apc.verifyNewCust(customerName);
	}
	
	@Test(dependsOnMethods= {"createNewCustomer"},enabled=true)
	public void deleteCustomer() {
		
		String username = PropUtilityLib.readProp("id");
		String password = PropUtilityLib.readProp("password");
		lp = new LoginPage(driver);
		lp.loginFunction(username, password);
		etp = new EnterTimeTrackPage(driver);
		etp.clickOnTasksTab();
		otp = new OpenTasksPage(driver);
		otp.clickOnProjNCustBtn();
		String customerName = ExcelUtilitiesLib.readData("MyTestDataSheet", 2, 3);
		apc= new ActiveProjNCustPage(driver);
		apc.selectCustomer(customerName);
		eci = new EditCustomerInfoPage(driver);
		eci.verifyCustomerBeforeDelete(customerName);
		eci.deleteCustomer();
		apc.verifyCustomerDeletion(customerName);
		
		
		
		
	}

}
