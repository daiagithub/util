package org.daiayum.util;

import java.util.Date;

public class Attendance {
	private Date timeIn;
	private Date timeOut;
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

}
