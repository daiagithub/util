package org.daiayum.util;

public class StartupRunner {

	private static final String NEW_LINE = System.getProperty("line.separator");
	private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static final String FILE_PATH = "F:\\tools\\recorder\\logs.log";
	
	public static void main(String[] args) {		
		String data = InsideOutPredictor.format(WindowsUtil.getLastBootUpTime(), DATETIME_FORMAT);		
		WindowsUtil.writeToFile(NEW_LINE + data, FILE_PATH);		
	}

}
