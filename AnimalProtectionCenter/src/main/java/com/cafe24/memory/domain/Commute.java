package com.cafe24.memory.domain;

public class Commute {
	private String CommuteCode;
	private Staff staff;
	private String commuteDate;
	private String commuteStartTime;
	private String commuteEndTime;
	private String commuteIutingStartTime;
	private String commuteOutingOutTime;
	
	public String getCommuteCode() {
		return CommuteCode;
	}
	public void setCommuteCode(String commuteCode) {
		CommuteCode = commuteCode;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public String getCommuteStartTime() {
		return commuteStartTime;
	}
	public void setCommuteStartTime(String commuteStartTime) {
		this.commuteStartTime = commuteStartTime;
	}
	public String getCommuteEndTime() {
		return commuteEndTime;
	}
	public void setCommuteEndTime(String commuteEndTime) {
		this.commuteEndTime = commuteEndTime;
	}
	public String getCommuteIutingStartTime() {
		return commuteIutingStartTime;
	}
	public void setCommuteIutingStartTime(String commuteIutingStartTime) {
		this.commuteIutingStartTime = commuteIutingStartTime;
	}
	public String getCommuteOutingOutTime() {
		return commuteOutingOutTime;
	}
	public void setCommuteOutingOutTime(String commuteOutingOutTime) {
		this.commuteOutingOutTime = commuteOutingOutTime;
	}
	public String getCommuteDate() {
		return commuteDate;
	}
	public void setCommuteDate(String commuteDate) {
		this.commuteDate = commuteDate;
	}
	@Override
	public String toString() {
		return "Commute [CommuteCode=" + CommuteCode + ", staff=" + staff + ", commuteStartTime=" + commuteStartTime
				+ ", commuteEndTime=" + commuteEndTime + ", commuteIutingStartTime=" + commuteIutingStartTime
				+ ", commuteOutingOutTime=" + commuteOutingOutTime + ", commuteDate=" + commuteDate + "]";
	}
}
