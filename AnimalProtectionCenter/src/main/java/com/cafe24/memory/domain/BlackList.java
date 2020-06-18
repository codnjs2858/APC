package com.cafe24.memory.domain;

import java.util.Date;

public class BlackList {
	
	private int blackListNum;
	private String blackListReason;
	private String blackListCancleReason;
	private Date blackListCancleDate;
	private Date blackListDate;
	//외래키
	private Member member;
	private Staff staff;
	
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public int getBlackListNum() {
		return blackListNum;
	}
	public void setBlackListNum(int blackListNum) {
		this.blackListNum = blackListNum;
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
	public Date getBlackListCancleDate() {
		return blackListCancleDate;
	}
	public void setBlackListCancleDate(Date blackListCancleDate) {
		this.blackListCancleDate = blackListCancleDate;
	}
	public Date getBlackListDate() {
		return blackListDate;
	}
	public void setBlackListDate(Date blackListDate) {
		this.blackListDate = blackListDate;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	@Override
	public String toString() {
		return "BlackList [blackListNum=" + blackListNum + ", blackListReason=" + blackListReason
				+ ", blackListCancleReason=" + blackListCancleReason + ", blackListCancleDate=" + blackListCancleDate
				+ ", blackListDate=" + blackListDate + ", member=" + member + ", staff=" + staff + "]";
	}
	
	
}
