package com.cafe24.memory.domain;

import java.util.Date;

public class Review {
	
	private String reviewCode;
	private int reviewCount;
	private int reviewOmissionCount;
	private Date reviewDate;
	private Date reviewManagementPeriod;
	//외래키
	private Staff staff;
	private Member member;
	
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getReviewCode() {
		return reviewCode;
	}
	public void setReviewCode(String reviewCode) {
		this.reviewCode = reviewCode;
	}
	public int getReviewCount() {
		return reviewCount;
	}
	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}
	public int getReviewOmissionCount() {
		return reviewOmissionCount;
	}
	public void setReviewOmissionCount(int reviewOmissionCount) {
		this.reviewOmissionCount = reviewOmissionCount;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public Date getReviewManagementPeriod() {
		return reviewManagementPeriod;
	}
	public void setReviewManagementPeriod(Date reviewManagementPeriod) {
		this.reviewManagementPeriod = reviewManagementPeriod;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
	@Override
	public String toString() {
		return "Review [reviewCode=" + reviewCode + ", reviewCount=" + reviewCount + ", reviewOmissionCount="
				+ reviewOmissionCount + ", reviewDate=" + reviewDate + ", reviewManagementPeriod="
				+ reviewManagementPeriod + ", staff=" + staff + ", member=" + member + "]";
	}
	
}	
