package org.daiayum.util;

import java.util.Date;

public class ShutdownRunner {

	private static final String TAB_CHARACTER = "\t";
	private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static final String FILE_PATH = "F:\\tools\\recorder\\logs.log";
	
	public static void main(String[] args) {
		Attendance dummy = new Attendance();
		Date timeIn = WindowsUtil.getLastBootUpTime();
		dummy.setTimeIn(timeIn);		
		AttendanceService attendanceService = new GenericAttendanceService();
		attendanceService.updateAttendance(dummy);
		
		String out = AttendanceService.format(dummy.getTimeOut(), DATETIME_FORMAT);
		WindowsUtil.writeToFile(TAB_CHARACTER + out + TAB_CHARACTER + dummy.getActualTimeSpent(), FILE_PATH);		
	}

}
