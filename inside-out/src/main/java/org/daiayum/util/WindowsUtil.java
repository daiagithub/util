package org.daiayum.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WindowsUtil {
	
	private static final String COMMAND_LASTBOOTUPTIME = "wmic os get lastbootuptime"; 
	
	public static Date getLastBootUpTime(){		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(COMMAND_LASTBOOTUPTIME).getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line;
			
			while ((line = br.readLine()) != null) sb.append(line);
			
			String lastBootUpTime = sb.toString().trim();
			lastBootUpTime = lastBootUpTime.substring(lastBootUpTime.lastIndexOf(' '), lastBootUpTime.length()).trim();
			lastBootUpTime = lastBootUpTime.substring(0, lastBootUpTime.indexOf("."));		
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");    		
			return formatter.parse(lastBootUpTime); 
		} catch (IOException e) {		
			e.printStackTrace();
		} catch (ParseException e) {		
			e.printStackTrace(); 
		}
		return null;		
	}
	
	public static void writeToFile(String data, String filePath){
		try{
    		File file =new File(filePath);    		
    		
    		if(!file.exists()){
    			file.createNewFile();
    		}
    		
    		FileWriter fileWritter = new FileWriter(filePath, true);
	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
	        bufferWritter.write(data);
	        bufferWritter.close();  
	        
    	}catch(IOException e){
    		e.printStackTrace();
    	}	
	}
}
