package com.actitime.generics;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseLib {

	public static WebDriver driver;

	@BeforeMethod
	public void setUp() throws IOException {

		String browser= PropUtilityLib.readProp("browser");
		String baseurl= PropUtilityLib.readProp("baseurl");
		
		if(browser.equalsIgnoreCase("chrome")) {
		
		System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(baseurl);
		}
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws InterruptedException, IOException {

		String scriptName = result.getMethod().getMethodName();

		if (result.isSuccess()) {
			Reporter.log("--> " + scriptName + " is Passed Sucessfully");
		} 
		else {
			Reporter.log("--> " + scriptName + " is Failed");
			ScreenshotLib sslib = new ScreenshotLib();
			sslib.captureScreenshot(driver, scriptName);
			Reporter.log("-->Failure Screenshot ahs been Taken", true);
		}

		driver.quit();
		Reporter.log("--> Browser closed",true);
	}

}
