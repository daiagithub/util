package org.daiayum.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsideOutPredictorWithWinCommand extends InsideOutPredictor {

	@Override
	public void setElapsedSeconds() {
		try {    		
    		BufferedReader br = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("wmic os get lastbootuptime").getInputStream()));
    		StringBuffer sb = new StringBuffer();
    		String line;
    		while ((line = br.readLine()) != null) {
    		  sb.append(line);
    		}
    		
    		String lastBootUpTime = sb.toString().trim();
    		lastBootUpTime = lastBootUpTime.substring(lastBootUpTime.lastIndexOf(' '), lastBootUpTime.length()).trim();
    		lastBootUpTime = lastBootUpTime.substring(0, lastBootUpTime.indexOf("."));		
    		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");    		
    		inTime = formatter.parse(lastBootUpTime); 
    		now = new Date();
    		elapsedSeconds = (now.getTime() - inTime.getTime())/1000;    		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

}
