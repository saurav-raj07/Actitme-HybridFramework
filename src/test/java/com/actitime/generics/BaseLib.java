package com.actitime.generics;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseLib {

	public WebDriver driver;

	@BeforeMethod
	public void setUp() throws IOException {

		String browser = PropUtilityLib.readProp("browser");
		String baseurl = PropUtilityLib.readProp("baseurl");
//		final String waitTime = PropUtilityLib.readProp("WAIT_TIME");

		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
			driver = new ChromeDriver();
//			driver = new RemoteWebDriver(DesiredCapabilities.chrome());
		} 
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./exefiles.geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "./exefiles/IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		}
		
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.get(baseurl);
	}

	@AfterMethod
	public void tearDown(ITestResult testResult) throws InterruptedException, IOException {

		String scriptName = testResult.getMethod().getMethodName();
		

		if (testResult.isSuccess()) {
			Reporter.log("-----> " + scriptName + " is Passed Sucessfully", true);
		} else {
			Reporter.log("-----> " + scriptName + " is Failed", true);
			ScreenshotLib sslib = new ScreenshotLib();
			sslib.captureScreenshot(driver, scriptName);
			Reporter.log("----->Failure Screenshot has been Taken", true);
		}

		driver.quit();
		Reporter.log("-----> Browser closed", true);
	}

}
