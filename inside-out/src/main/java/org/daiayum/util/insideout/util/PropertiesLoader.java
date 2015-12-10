package org.daiayum.util.insideout.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

	public static Properties PROPERTIES = new Properties();

	static {	
		InputStream input = null;

		try {
			String filename = "config.properties";
			input = PropertiesLoader.class.getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);				
			}else{
				// load a properties file from class path, inside static method
				PROPERTIES.load(input);
				// get the property value and print it out	
				//System.out.println(PROPERTIES.get("attendance.log.filepath"));
			}			

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String args[]){
		
	}

}
