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

	private final LoginPage loginPage = new LoginPage(driver);
	private final EnterTimeTrackPage enterTimeTrackPage = new EnterTimeTrackPage(driver);
	private final OpenTasksPage openTasksPage = new OpenTasksPage(driver);
	private final ActiveProjNCustPage activeProjNCustPage = new ActiveProjNCustPage(driver);
	private final CreateNewCustomerPage createNewCustomerPage = new CreateNewCustomerPage(driver);
	private final EditCustomerInfoPage editCustomerInfoPage = new EditCustomerInfoPage(driver);
	private final String username = PropUtilityLib.readProp("id");
	private final String password = PropUtilityLib.readProp("password");

	@Test(priority=1,enabled=true)
	public void createNewCustomer() {
		
		loginPage.loginFunction(username, password);		
		enterTimeTrackPage.clickOnTasksTab();
		openTasksPage.verifyOpenTaskPageTitle();
		openTasksPage.clickOnProjNCustBtn();
		activeProjNCustPage.clcOnCreateNewCustBtn();
		String customerName = ExcelUtilitiesLib.readData("MyTestDataSheet", 2, 3);
		String description = ExcelUtilitiesLib.readData("myTestDataSheet", 2, 4);
		createNewCustomerPage.createnewCustFunction(customerName, description);
		activeProjNCustPage.verifyNewCust(customerName);
	}
	
	@Test(dependsOnMethods= {"createNewCustomer"},enabled=true)
	public void deleteCustomer() {
		
		loginPage.loginFunction(username, password);
		enterTimeTrackPage.clickOnTasksTab();
		openTasksPage.clickOnProjNCustBtn();
		String customerName = ExcelUtilitiesLib.readData("MyTestDataSheet", 2, 3);
		activeProjNCustPage.selectCustomer(customerName);
		editCustomerInfoPage.verifyCustomerBeforeDelete(customerName);
		editCustomerInfoPage.deleteCustomer();
		activeProjNCustPage.verifyCustomerDeletion(customerName);
		
		
		
		
	}

}
