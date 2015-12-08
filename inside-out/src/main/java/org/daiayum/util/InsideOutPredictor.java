package org.daiayum.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class InsideOutPredictor {
	
	static long elapsedSeconds;
	static long elapsedMinutes;
	static long elapsedHours;
	static Date now;
	static Date inTime;
	
	static SimpleDateFormat formatter = new SimpleDateFormat();
	static String TIME_FORMAT = "HH:mm:ss";
	
	public abstract void setElapsedSeconds();
	
	public void setAllTimeComponentsValues() {
		elapsedHours = elapsedSeconds / 3600;
		elapsedSeconds = elapsedSeconds % 3600; // elapsedSeconds reassigned
		elapsedMinutes = elapsedSeconds / 60;
		elapsedSeconds = elapsedSeconds % 60;
	}
	
	public String generateMessage(){
		return "In: " + format(inTime, TIME_FORMAT) 
				+ " Elapsed: " + format(elapsedHours, TIME_FORMAT) + ":" + format(elapsedMinutes, TIME_FORMAT) + ":" + format(elapsedSeconds, TIME_FORMAT)
				+ ". Adviced Out: " + format(new Date(inTime.getTime() + (8 * 60 * 60 * 1000)), TIME_FORMAT);		
	}
	
	public static String format(Object obj, String format){
		formatter.applyPattern(format);
		if(obj instanceof Date){
			return formatter.format(obj);
		}
		
		if(obj instanceof Long){
			return String.format("%02d", obj);
		}	
		return null;
	}
	
	
}
