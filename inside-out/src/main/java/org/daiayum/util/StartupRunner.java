package org.daiayum.util;

import org.daiayum.util.insideout.core.entity.Attendance;
import org.daiayum.util.insideout.core.service.AttendanceService;
import org.daiayum.util.insideout.core.service.GenericAttendanceService;
import org.daiayum.util.insideout.util.Config;
import org.daiayum.util.insideout.util.WindowsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartupRunner {

	private static final String NEW_LINE = System.getProperty("line.separator");		
	private static final Logger LOGGER = LoggerFactory.getLogger(StartupRunner.class);
	
	public static void main(String[] args) {		
		AttendanceService attendanceService = new GenericAttendanceService();
    	Attendance attendance = attendanceService.registerNewAttendance(WindowsUtil.getLastBootUpTime());
    	
		String in = AttendanceService.format(attendance.getTimeIn(), Config.ATTENDANCE_DATETIME_FORMAT);		
		WindowsUtil.writeToFile(NEW_LINE + in, Config.ATTENDANCE_LOG_FILEPATH);		
		LOGGER.info("Logged time in {}.", in);
	}

}
