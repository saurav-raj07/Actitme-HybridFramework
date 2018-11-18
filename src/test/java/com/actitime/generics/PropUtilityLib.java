package com.actitime.generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropUtilityLib {
	
	public static String readProp(String key)  {
	
	Properties prop = null;
	try {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(new File("./src/test/resources/TestData/config.properties"));
		prop.load(fis);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return prop.getProperty(key);
	}
	
}
