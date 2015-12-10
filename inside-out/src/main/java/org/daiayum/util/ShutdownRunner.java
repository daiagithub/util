package org.daiayum.util;

import java.util.Date;

import org.daiayum.util.insideout.core.entity.Attendance;
import org.daiayum.util.insideout.core.service.AttendanceService;
import org.daiayum.util.insideout.core.service.GenericAttendanceService;
import org.daiayum.util.insideout.util.WindowsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShutdownRunner {

	private static final String TAB_CHARACTER = "\t";
	private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static final String FILE_PATH = "F:\\tools\\recorder\\logs.log";
	private static final Logger LOGGER = LoggerFactory.getLogger(ShutdownRunner.class);
	
	public static void main(String[] args) {
		Attendance dummy = new Attendance();
		Date timeIn = WindowsUtil.getLastBootUpTime();
		dummy.setTimeIn(timeIn);		
		AttendanceService attendanceService = new GenericAttendanceService();
		attendanceService.updateAttendance(dummy);
		
		String out = AttendanceService.format(dummy.getTimeOut(), DATETIME_FORMAT);
		WindowsUtil.writeToFile(TAB_CHARACTER + out + TAB_CHARACTER + dummy.getActualTimeSpent(), FILE_PATH);
		
		LOGGER.info("Logged time out {}.", out);
	}

}
