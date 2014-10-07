package org.daiayum.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class InsideOut {
	static Connection con = null;
	static long elapsedSeconds;
	static long elapsedMinutes;
	static long elapsedHours;
	static Date now;
	static Date inTime;
	
	static DateFormat formatter = new SimpleDateFormat("HH:mm:s");
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/",
					"root", "password");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void setElapsedSeconds() {
		String query = "SHOW GLOBAL STATUS LIKE 'Uptime';";
		PreparedStatement prSt;
		try {
			prSt = con.prepareStatement(query);
			ResultSet rs = prSt.executeQuery();
			elapsedSeconds = 0;
			while (rs.next()) {
				elapsedSeconds = Long.valueOf(rs.getInt(2));
				now = new Date();								//Set current time here
				inTime = new Date(now.getTime()	- (long) (elapsedSeconds * 1000));
				break;
			}
			rs.close();			
		} catch (SQLException e) {
			e.printStackTrace();						
		}
	}
	
	private static void setAllTimeComponentsValues(){	
		elapsedHours = elapsedSeconds / 3600;
		elapsedSeconds = elapsedSeconds % 3600; // elapsedSeconds reassigned
		elapsedMinutes = elapsedSeconds / 60;
		elapsedSeconds = elapsedSeconds % 60;
	}

	private static String generateMessage(){
		return "In: " + formatter.format(inTime) 
				+ " Elapsed: " + String.format("%02d", elapsedHours) + ":" + String.format("%02d", elapsedMinutes) + ":" + String.format("%02d", elapsedSeconds)
				+ ". Adviced Out: " + formatter.format(new Date(inTime.getTime() + (8 * 60 * 60 * 1000)));		
	}
	
	public static void main(String args[]) {
		setElapsedSeconds();
		setAllTimeComponentsValues();			
		JOptionPane.showMessageDialog(null, generateMessage());		
	}

}
