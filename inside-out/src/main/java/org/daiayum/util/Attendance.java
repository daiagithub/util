package org.daiayum.util;

import java.util.Date;

public class Attendance {
	private Date timeIn;
	private Date timeOut;
	private Long elapsedSeconds;
	private String actualTimeSpent;
	private Date recordDate;
	private String timeZone;
	
	private Date dateCreated;
	private Date lastUpdated;
	
	public Date getTimeIn() {
		return timeIn;
	}
	public void setTimeIn(Date timeIn) {
		this.timeIn = timeIn;
	}
	public Date getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(Date timeOut) {
		this.timeOut = timeOut;
	}
	public String getActualTimeSpent() {
		return actualTimeSpent;
	}
	public void setActualTimeSpent(String actualTimeSpent) {
		this.actualTimeSpent = actualTimeSpent;
	}
	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public Long getElapsedSeconds() {
		return elapsedSeconds;
	}
	public void setElapsedSeconds(Long elapsedSeconds) {
		this.elapsedSeconds = elapsedSeconds;
		this.setActualTimeSpent(getElapsedTimeFormattedString(elapsedSeconds));
	}	

	private String getElapsedTimeFormattedString(Long elapsedSeconds){
		Long elapsedHours = elapsedSeconds / 3600;
		elapsedSeconds = elapsedSeconds % 3600; // elapsedSeconds reassigned
		Long elapsedMinutes = elapsedSeconds / 60;
		elapsedSeconds = elapsedSeconds % 60;
		String elapsedTime = AttendanceService.format(elapsedHours, null) + ":" + AttendanceService.format(elapsedMinutes, null) + ":" + AttendanceService.format(elapsedSeconds, null);		
		return elapsedTime;		
	}
}
