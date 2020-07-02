package com.cafe24.memory.domain;

public class Staff {
	private String staffCode;
	private String staffName;
	private String staffPart;
	private String staffRank;
	private Member member;
	private String staffInDate;
	private String staffOutDate;
	private Commute commute;
	
	
	public Commute getCommute() {
		return commute;
	}
	public void setCommute(Commute commute) {
		this.commute = commute;
	}
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
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
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
				+ ", staffRank=" + staffRank + ", member=" + member + ", staffInDate=" + staffInDate + ", staffOutDate="
				+ staffOutDate + ", commute=" + commute + "]";
	}
	
}
