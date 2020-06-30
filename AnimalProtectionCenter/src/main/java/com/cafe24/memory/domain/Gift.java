package com.cafe24.memory.domain;

public class Gift {
	
	private String giftCode;
	private String giftType;
	private String giftCost;
	private String giftDate;
	private String giftReason;
	//외래키
	private Member member;
	private Staff staff;
	
	public String getGiftCode() {
		return giftCode;
	}
	public void setGiftCode(String giftCode) {
		this.giftCode = giftCode;
	}
	public String getGiftType() {
		return giftType;
	}
	public void setGiftType(String giftType) {
		this.giftType = giftType;
	}
	public String getGiftCost() {
		return giftCost;
	}
	public void setGiftCost(String giftCost) {
		this.giftCost = giftCost;
	}
	public String getGiftDate() {
		return giftDate;
	}
	public void setGiftDate(String giftDate) {
		this.giftDate = giftDate;
	}
	public String getGiftReason() {
		return giftReason;
	}
	public void setGiftReason(String giftReason) {
		this.giftReason = giftReason;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
	@Override
	public String toString() {
		return "Gift [giftCode=" + giftCode + ", giftType=" + giftType + ", giftCost=" + giftCost + ", giftDate="
				+ giftDate + ", giftReason=" + giftReason + ", member=" + member + ", staff=" + staff + "]";
	}
}
