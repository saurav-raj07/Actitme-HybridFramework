package com.actitime.generics;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;

public class ScreenshotLib {

	public void captureScreenshot(WebDriver driver, String scriptName) {

		EventFiringWebDriver efw = new EventFiringWebDriver(driver);
		File src = efw.getScreenshotAs(OutputType.FILE);
		File dest = new File("./FailureScreenshots/" + scriptName + ".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			Reporter.log("--> Failure while taking screenshot", true);
			e.printStackTrace();
		}

	}

}
