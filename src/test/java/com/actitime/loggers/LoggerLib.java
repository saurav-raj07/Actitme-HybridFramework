package com.actitime.loggers;

import org.apache.log4j.Logger;

public class LoggerLib {

	static Logger customLogs = Logger.getLogger(LoggerLib.class);

	public static void main(String[] args) {

		customLogs.info("***Starting Test case***");
	}

}
