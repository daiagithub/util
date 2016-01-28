package org.daiayum.util.insideout.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesLoader {

	public static Properties PROPERTIES = new Properties();
	private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesLoader.class);

	static {	
		InputStream input = null;

		try {
			String filename = getConfigFileName();
			input = PropertiesLoader.class.getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);				
			}else{			
				PROPERTIES.load(input);			
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
	
	private static String getEnvironment(){
		if(System.getProperty("env") != null && !System.getProperty("env").isEmpty()){
			return System.getProperty("env");
		}else{
			return "local";
		}		 
	}
	
	private static String getConfigFileName(){
		StringBuffer strBuffer = new StringBuffer(getEnvironment());
		strBuffer.append("/config.properties");
	    LOGGER.info("Configuration file to be used: {}", strBuffer.toString());
	    return strBuffer.toString();	
	}

}
