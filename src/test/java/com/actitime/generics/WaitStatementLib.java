package com.actitime.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitStatementLib {
	
	WebDriver driver;

	public WaitStatementLib(WebDriver driver) {
		this.driver = driver;
	}

	public void iSleep(int secs) {
		try {
			Thread.sleep(secs * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void iWait(int secs) {
		driver.manage().timeouts().implicitlyWait(secs, TimeUnit.SECONDS);
	}

	public void eWait(int secs, WebElement element) {
		WebDriverWait wdw = new WebDriverWait(driver, secs);
		wdw.until(ExpectedConditions.visibilityOf(element));
	}

	public void eRefresh(int secs, WebElement element) {
		WebDriverWait wdw = new WebDriverWait(driver, secs);
		wdw.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
	}

}
