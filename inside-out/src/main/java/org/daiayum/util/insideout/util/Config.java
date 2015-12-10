package org.daiayum.util.insideout.util;

public class Config {
	
	public static final String TAB_CHARACTER = (String) PropertiesLoader.PROPERTIES.get("tab.character");
	public static final String ATTENDANCE_LOG_FILEPATH = (String) PropertiesLoader.PROPERTIES.get("attendance.log.filepath");
	public static final String ATTENDANCE_DATETIME_FORMAT = (String) PropertiesLoader.PROPERTIES.get("attendance.datetime.format");
	public static final String ATTENDANCE_TIME_FORMAT = (String) PropertiesLoader.PROPERTIES.get("attendance.time.format");
	public static final String WINDOW_COMMAND_LASTBOOTUPTIME = (String) PropertiesLoader.PROPERTIES.get("windows.command.lastbootuptime");
	
}
