package org.daiayum.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AttendanceService {
	
	static SimpleDateFormat formatter = new SimpleDateFormat();
	static final String TIME_FORMAT = "HH:mm:ss";
	
	static final Logger LOGGER = LoggerFactory.getLogger(AttendanceService.class);	

	protected Long getElapsedSeconds(Date timeIn) {			
		Date now = new Date();
		return (now.getTime() - timeIn.getTime())/1000; 			
	}

	public Attendance registerNewAttendance(Date timeIn) {
		Attendance attendance = new Attendance();
		attendance.setTimeIn(timeIn);
		attendance.setElapsedSeconds(getElapsedSeconds(timeIn));
		Date now = new Date();
		attendance.setDateCreated(now);
		attendance.setLastUpdated(null);
		attendance.setRecordDate(now);
		attendance.setTimeZone(null);		
		return attendance;
	}	
	
	public Attendance updateAttendance(Attendance attendance) {		
		attendance.setElapsedSeconds(getElapsedSeconds(attendance.getTimeIn()));
		Date now = new Date();
		attendance.setTimeOut(now);
		attendance.setLastUpdated(now);
		return attendance;
	}	
	
	public String generateMessage(Attendance attendance){
		String message = "In: " + format(attendance.getTimeIn(), TIME_FORMAT) 
				+ " Elapsed: " + attendance.getActualTimeSpent()
				+ ". Adviced Out: " + format(new Date(attendance.getTimeIn().getTime() + (8 * 60 * 60 * 1000)), TIME_FORMAT);	
		LOGGER.info("Message: {}", message);		
		return message;		
	}
	
	public static String format(Object obj, String format){
		if(obj instanceof Date){
			formatter.applyPattern(format);
			LOGGER.debug("Formatting Date {} to {}...", obj, format);
			return formatter.format(obj);
		}
		
		if(obj instanceof Long){
			LOGGER.debug("Formatting Long {} to {}...", obj, "%02d");
			return String.format("%02d", obj);
		}	
		return null;
	}
	
}
