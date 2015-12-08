package org.daiayum.util;

public class StartupRunner {

	private static final String newLine = System.getProperty("line.separator");
	
	public static void main(String[] args) {		
		String data = InsideOutPredictor.format(WindowsUtil.getLastBootUpTime(), "yyyy-MM-dd HH:mm:ss");		
		WindowsUtil.writeToFile(newLine + data, "F:\\tools\\recorder\\logs.log");		
	}

}
