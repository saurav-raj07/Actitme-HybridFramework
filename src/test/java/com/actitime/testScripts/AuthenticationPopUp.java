package com.actitime.testScripts;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.actitime.generics.BaseLib;

public class AuthenticationPopUp extends BaseLib {

	@Test(enabled=false)
	public void authentationPopUptesting() {
		
		
		String innertextOfElement = driver.findElement(By.xpath("//h3[text()='Basic Auth']")).getAttribute("innerText");
		System.out.println(innertextOfElement);
		
	}
	
	@Test(enabled=false)
	public void hiddenDivPopup() throws Throwable {
		
		driver.findElement(By.xpath("//div[@class='fsw_inputBox dates inactiveWidget ']//span")).click();
		String currentDt = getTodaysDate();
		
		Thread.sleep(3000);		
	}
	
	
	@Test(enabled=true)
	public void sikuliFileDownload() throws Throwable {
		System.out.println(" >>>> hello world <<<<");
//		Screen screen = new Screen();
//		
//		Pattern pattern = new Pattern("abc");
//		
//		screen.click();
	}
	
	
	public String getTodaysDate() throws Throwable {
		
		Date date = new Date();
		System.out.println(date.getHours()); //deprecated methods
		System.out.println(date.getMonth()); //deprecated methods
		System.out.println(date.getDate());  //deprecated methods
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		String dt = sdf.format(date);
		System.out.println("-----> Current date is: " + dt);
		return dt;
		
		
	}
}
