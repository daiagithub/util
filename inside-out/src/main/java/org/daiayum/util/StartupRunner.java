package org.daiayum.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartupRunner {

	private static final String NEW_LINE = System.getProperty("line.separator");
	private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static final String FILE_PATH = "F:\\tools\\recorder\\logs.log";
	
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(StartupRunner.class);
		AttendanceService attendanceService = new GenericAttendanceService();
    	Attendance attendance = attendanceService.registerNewAttendance(WindowsUtil.getLastBootUpTime());
    	
		String in = AttendanceService.format(attendance.getTimeIn(), DATETIME_FORMAT);		
		WindowsUtil.writeToFile(NEW_LINE + in, FILE_PATH);		
		logger.info("Logged time in {}.", in);
	}

}
