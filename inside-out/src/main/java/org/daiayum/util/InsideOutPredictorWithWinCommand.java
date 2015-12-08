package org.daiayum.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsideOutPredictorWithWinCommand extends InsideOutPredictor {

	@Override
	public void setElapsedSeconds() {			
		inTime = WindowsUtil.getLastBootUpTime();
		now = new Date();
		elapsedSeconds = (now.getTime() - inTime.getTime())/1000; 			
	}
}
