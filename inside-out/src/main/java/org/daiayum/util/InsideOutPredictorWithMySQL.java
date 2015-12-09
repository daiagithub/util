package org.daiayum.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Deprecated
public class InsideOutPredictorWithMySQL extends AttendanceService{
	static Connection con = null;
	static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	static final String CON_URL = "jdbc:mysql://localhost:3306/";
	static final String USERNAME = "root";
	static final String PASSWORD = "password";
	static final String QUERY = "SHOW GLOBAL STATUS LIKE 'Uptime';";
	
	static final Logger LOGGER = LoggerFactory.getLogger(AttendanceService.class);
	
	static {
		try {
			Class.forName(MYSQL_DRIVER);
			con = DriverManager.getConnection(CON_URL, USERNAME, PASSWORD);
			LOGGER.debug("Got MySQL connection.");
		} catch (ClassNotFoundException e) {
			LOGGER.error("Failed to connect MySQL {}", e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			LOGGER.error("Failed to connect MySQL {}", e.getMessage());
			e.printStackTrace();
		}
	}

	/*@Override
	public void setElapsedSeconds() {
		PreparedStatement prSt;
		try {
			prSt = con.prepareStatement(QUERY);
			ResultSet rs = prSt.executeQuery();
			elapsedSeconds = 0;
			while (rs.next()) {
				elapsedSeconds = Long.valueOf(rs.getInt(2));
				now = new Date();								//Set to current time here
				inTime = new Date(now.getTime()	- (long) (elapsedSeconds * 1000));
				break;
			}
			rs.close();	
			return 
		} catch (SQLException e) {
			LOGGER.error("Failed to set elapsed time. {}", e.getMessage());
			e.printStackTrace();						
		}
	}*/

	@Override
	protected Long getElapsedSeconds(Date timeIn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Attendance registerNewAttendance(Date timeIn) {
		// TODO Auto-generated method stub
		return null;
	}

}
