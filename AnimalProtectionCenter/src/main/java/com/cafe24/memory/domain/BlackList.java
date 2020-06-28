package com.cafe24.memory.domain;

public class BlackList {
	
	private String blackListCode;
	private String blackListReason;
	private String blackListCancleReason;
	private String blackListCancleDate;
	private String blackListDate;
	//외래키
	private Member member;
	private Staff staff;
	public String getBlackListCode() {
		return blackListCode;
	}
	public void setBlackListCode(String blackListCode) {
		this.blackListCode = blackListCode;
	}
	public String getBlackListReason() {
		return blackListReason;
	}
	public void setBlackListReason(String blackListReason) {
		this.blackListReason = blackListReason;
	}
	public String getBlackListCancleReason() {
		return blackListCancleReason;
	}
	public void setBlackListCancleReason(String blackListCancleReason) {
		this.blackListCancleReason = blackListCancleReason;
	}
	public String getBlackListCancleDate() {
		return blackListCancleDate;
	}
	public void setBlackListCancleDate(String blackListCancleDate) {
		this.blackListCancleDate = blackListCancleDate;
	}
	public String getBlackListDate() {
		return blackListDate;
	}
	public void setBlackListDate(String blackListDate) {
		this.blackListDate = blackListDate;
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
		return "BlackList [blackListCode=" + blackListCode + ", blackListReason=" + blackListReason
				+ ", blackListCancleReason=" + blackListCancleReason + ", blackListCancleDate=" + blackListCancleDate
				+ ", blackListDate=" + blackListDate + ", member=" + member + ", staff=" + staff + "]";
	}
}
