package org.daiayum.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsideOutPredictorWithMySQL extends InsideOutPredictor{
	static Connection con = null;
	static final String mysqlDriver = "com.mysql.jdbc.Driver";
	static final String conURL = "jdbc:mysql://localhost:3306/";
	static final String username = "root";
	static final String password = "password";
	static final String query = "SHOW GLOBAL STATUS LIKE 'Uptime';";
	
	static {
		try {
			Class.forName(mysqlDriver);
			con = DriverManager.getConnection(conURL, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setElapsedSeconds() {
		PreparedStatement prSt;
		try {
			prSt = con.prepareStatement(query);
			ResultSet rs = prSt.executeQuery();
			elapsedSeconds = 0;
			while (rs.next()) {
				elapsedSeconds = Long.valueOf(rs.getInt(2));
				now = new Date();								//Set to current time here
				inTime = new Date(now.getTime()	- (long) (elapsedSeconds * 1000));
				break;
			}
			rs.close();			
		} catch (SQLException e) {
			e.printStackTrace();						
		}
	}

}
