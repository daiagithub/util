package org.daiayum.util;

import java.util.Date;

import org.daiayum.util.insideout.core.entity.Attendance;
import org.daiayum.util.insideout.core.service.AttendanceService;
import org.daiayum.util.insideout.core.service.GenericAttendanceService;
import org.daiayum.util.insideout.util.Config;
import org.daiayum.util.insideout.util.WindowsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShutdownRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(ShutdownRunner.class);
	
	public static void main(String[] args) {
		Attendance dummy = new Attendance();
		Date timeIn = WindowsUtil.getLastBootUpTime();
		dummy.setTimeIn(timeIn);		
		AttendanceService attendanceService = new GenericAttendanceService();
		attendanceService.updateAttendance(dummy);
		
		String out = AttendanceService.format(dummy.getTimeOut(), Config.ATTENDANCE_DATETIME_FORMAT);
		WindowsUtil.writeToFile(Config.TAB_CHARACTER + out + Config.TAB_CHARACTER + dummy.getActualTimeSpent(), Config.ATTENDANCE_LOG_FILEPATH);
		
		LOGGER.info("Logged time out {}.", out);
	}

}
