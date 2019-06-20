package com.actitime.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitStatementLib {
	
	WebDriver driver;

	// **************constructor*******************
	public WaitStatementLib(WebDriver driver) {
		this.driver = driver; 
/*this is to match the driver in the waitStatementLib class (In line 12)
with the driver instance passed from the invoking class*/
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

	public void  eWait(int secs, WebElement element) {
		WebDriverWait wdw = new WebDriverWait(driver, secs);
		wdw.until(ExpectedConditions.visibilityOf(element));
	}

	public void eRefresh(int secs, WebElement element) {
		WebDriverWait wdw = new WebDriverWait(driver, secs);
		wdw.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
	}

}
