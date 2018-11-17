package com.actitime.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseLib {

	public static WebDriver driver;

	@BeforeMethod
	//@Parameters({ "browser", "WAIT_TIME", "baseUrl" })
	public void setUp() {

			System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.get("http://127.0.0.1/login.do");
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(6000);
		driver.quit();
	}

}
