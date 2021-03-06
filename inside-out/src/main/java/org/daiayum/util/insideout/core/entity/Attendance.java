package org.daiayum.util.insideout.core.entity;

import java.util.Date;

import org.daiayum.util.insideout.core.service.AttendanceService;

public class Attendance {
	private Date timeIn;
	private Date timeOut;
	private Long elapsedSeconds;
	private String actualTimeSpent;	//Actual time as formatted string
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
	
	/**
	 * Update the actualTimeSpent formatted string as well.
	 * @param elapsedSeconds
	 */
	public void setElapsedSeconds(Long elapsedSeconds) {
		this.elapsedSeconds = elapsedSeconds;
		this.setActualTimeSpent(getElapsedTimeFormattedString(elapsedSeconds));
	}	

	/**
	 * Format the actual elapsed Second to HH:mm:ss format
	 * @param elapsedSeconds
	 * @return
	 */
	private String getElapsedTimeFormattedString(Long elapsedSeconds){
		Long elapsedHours = elapsedSeconds / 3600;
		elapsedSeconds = elapsedSeconds % 3600; // elapsedSeconds reassigned
		Long elapsedMinutes = elapsedSeconds / 60;
		elapsedSeconds = elapsedSeconds % 60;
		String elapsedTime = AttendanceService.format(elapsedHours, null) + ":" + AttendanceService.format(elapsedMinutes, null) + ":" + AttendanceService.format(elapsedSeconds, null);		
		return elapsedTime;		
	}
}
