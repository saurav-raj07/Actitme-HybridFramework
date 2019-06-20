package com.actitime.testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;  

public class AuthenticationPopUp {

	@Test
	public void authentationPopUptesting() {
		
		
		System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
//		WebDriver driver = new InternetExplorerDriver();
//		WebDriver driver = new FirefoxDriver();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		String innertextOfElement = driver.findElement(By.xpath("//h3[text()='Basic Auth']")).getAttribute("innerText");
		System.out.println(innertextOfElement);
		driver.close();
		
		
		
	}
}
