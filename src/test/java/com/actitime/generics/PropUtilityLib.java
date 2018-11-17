package com.actitime.generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropUtilityLib {
	
	public static String readProp(String key) throws IOException {
	
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream(new File("./src/test/resources/config.properties"));
	prop.load(fis);
	return prop.getProperty(key);
	}
}
