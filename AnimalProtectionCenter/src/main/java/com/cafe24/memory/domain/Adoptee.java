package com.cafe24.memory.domain;

import java.util.Date;

public class Adoptee {
	private String adopteeCode;
	private Date adopteeDate;
	//외래키
	private Member member;
	private Staff staff;
	private ScreeningComplete screeningComplete;
	
	public String getAdopteeCode() {
		return adopteeCode;
	}
	public void setAdopteeCode(String adopteeCode) {
		this.adopteeCode = adopteeCode;
	}
	public Date getAdopteeDate() {
		return adopteeDate;
	}
	public void setAdopteeDate(Date adopteeDate) {
		this.adopteeDate = adopteeDate;
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
	public ScreeningComplete getScreeningComplete() {
		return screeningComplete;
	}
	public void setScreeningComplete(ScreeningComplete screeningComplete) {
		this.screeningComplete = screeningComplete;
	}
	
	@Override
	public String toString() {
		return "Adoptee [adopteeCode=" + adopteeCode + ", adopteeDate=" + adopteeDate + ", member=" + member
				+ ", staff=" + staff + ", screeningComplete=" + screeningComplete + "]";
	}
	
	
}
