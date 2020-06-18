package com.cafe24.memory.domain;

public class Staff {
	private String staffCode;
	private String staffName;
	private String staffPart;
	private String staffRank;
	private String memberId;
	private String staffPhone;
	private String staffEmail;
	private String staffInDate;
	private String staffOutDate;
	public String getStaffCode() {
		return staffCode;
	}
	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffPart() {
		return staffPart;
	}
	public void setStaffPart(String staffPart) {
		this.staffPart = staffPart;
	}
	public String getStaffRank() {
		return staffRank;
	}
	public void setStaffRank(String staffRank) {
		this.staffRank = staffRank;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getStaffPhone() {
		return staffPhone;
	}
	public void setStaffPhone(String staffPhone) {
		this.staffPhone = staffPhone;
	}
	public String getStaffEmail() {
		return staffEmail;
	}
	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}
	public String getStaffInDate() {
		return staffInDate;
	}
	public void setStaffInDate(String staffInDate) {
		this.staffInDate = staffInDate;
	}
	public String getStaffOutDate() {
		return staffOutDate;
	}
	public void setStaffOutDate(String staffOutDate) {
		this.staffOutDate = staffOutDate;
	}
	@Override
	public String toString() {
		return "Staff [staffCode=" + staffCode + ", staffName=" + staffName + ", staffPart=" + staffPart
				+ ", staffRank=" + staffRank + ", memberId=" + memberId + ", staffPhone=" + staffPhone + ", staffEmail="
				+ staffEmail + ", staffInDate=" + staffInDate + ", staffOutDate=" + staffOutDate + "]";
	}
	

}
