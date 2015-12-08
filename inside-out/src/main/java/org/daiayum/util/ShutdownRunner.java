package org.daiayum.util;

import java.util.Date;

public class ShutdownRunner {

	private static final String tab = "\t";
	
	public static void main(String[] args) {
		String data = InsideOutPredictor.format(new Date(), "yyyy-MM-dd HH:mm:ss");		
		WindowsUtil.writeToFile(tab + data, "F:\\tools\\recorder\\logs.log");		
	}

}
