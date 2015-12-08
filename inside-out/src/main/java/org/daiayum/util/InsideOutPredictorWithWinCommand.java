package org.daiayum.util;

import java.util.Date;

public class InsideOutPredictorWithWinCommand extends InsideOutPredictor {

	@Override
	public void setElapsedSeconds() {			
		inTime = WindowsUtil.getLastBootUpTime();
		now = new Date();
		elapsedSeconds = (now.getTime() - inTime.getTime())/1000; 			
	}
}
