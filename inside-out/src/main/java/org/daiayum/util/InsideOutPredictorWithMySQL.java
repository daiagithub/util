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
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "password");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setElapsedSeconds() {
		String query = "SHOW GLOBAL STATUS LIKE 'Uptime';";
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
