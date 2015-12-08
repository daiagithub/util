package org.daiayum.util;

import java.util.Date;

public class ShutdownRunner {

	private static final String TAB_CHARACTER = "\t";
	private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static final String FILE_PATH = "F:\\tools\\recorder\\logs.log";
	
	public static void main(String[] args) {
		String data = InsideOutPredictor.format(new Date(), DATETIME_FORMAT);		
		WindowsUtil.writeToFile(TAB_CHARACTER + data, FILE_PATH);		
	}

}
