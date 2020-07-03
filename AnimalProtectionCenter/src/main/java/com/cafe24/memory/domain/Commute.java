package com.cafe24.memory.domain;

public class Commute {
	private String commuteCode;
	private Staff staff;
	private String commuteDate;
	private String commuteStartTime;
	private String commuteEndTime;
	private int commuteWorkingHour;
	public String getCommuteCode() {
		return commuteCode;
	}
	public void setCommuteCode(String commuteCode) {
		this.commuteCode = commuteCode;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public String getCommuteDate() {
		return commuteDate;
	}
	public void setCommuteDate(String commuteDate) {
		this.commuteDate = commuteDate;
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
	public int getCommuteWorkingHour() {
		return commuteWorkingHour;
	}
	public void setCommuteWorkingHour(int commuteWorkingHour) {
		this.commuteWorkingHour = commuteWorkingHour;
	}
	@Override
	public String toString() {
		return "Commute [commuteCode=" + commuteCode + ", staff=" + staff + ", commuteDate=" + commuteDate
				+ ", commuteStartTime=" + commuteStartTime + ", commuteEndTime=" + commuteEndTime
				+ ", commuteWorkingHour=" + commuteWorkingHour + "]";
	}
	
	
}
