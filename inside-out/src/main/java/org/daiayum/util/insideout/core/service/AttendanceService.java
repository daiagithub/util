package org.daiayum.util.insideout.core.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.daiayum.util.insideout.core.entity.Attendance;
import org.daiayum.util.insideout.util.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AttendanceService {
	
	static SimpleDateFormat formatter = new SimpleDateFormat();	
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
		LOGGER.info("New attendance created.");
		return attendance;
	}	
	
	public void updateAttendance(Attendance attendance) {		
		attendance.setElapsedSeconds(getElapsedSeconds(attendance.getTimeIn()));
		Date now = new Date();
		attendance.setTimeOut(now);
		attendance.setLastUpdated(now);
		LOGGER.info("Attendance updated.");
	}	
	
	public String generateMessage(Attendance attendance){
		String message = "In: " + format(attendance.getTimeIn(), Config.ATTENDANCE_TIME_FORMAT) 
				+ " Elapsed: " + attendance.getActualTimeSpent()
				+ ". Adviced Out: " + format(new Date(attendance.getTimeIn().getTime() + (8 * 60 * 60 * 1000)), Config.ATTENDANCE_TIME_FORMAT);	
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
