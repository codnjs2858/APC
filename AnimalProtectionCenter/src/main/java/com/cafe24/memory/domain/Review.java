package com.cafe24.memory.domain;

public class Review {
	
	private String reviewCode;
	private String reviewCount;
	private String reviewOmissionCount;
	private String reviewDate;
	private String reviewManagementPeriod;
	//외래키
	private Staff staff;
	private Member member;
	
	public String getReviewCode() {
		return reviewCode;
	}
	public void setReviewCode(String reviewCode) {
		this.reviewCode = reviewCode;
	}
	public String getReviewCount() {
		return reviewCount;
	}
	public void setReviewCount(String reviewCount) {
		this.reviewCount = reviewCount;
	}
	public String getReviewOmissionCount() {
		return reviewOmissionCount;
	}
	public void setReviewOmissionCount(String reviewOmissionCount) {
		this.reviewOmissionCount = reviewOmissionCount;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	public String getReviewManagementPeriod() {
		return reviewManagementPeriod;
	}
	public void setReviewManagementPeriod(String reviewManagementPeriod) {
		this.reviewManagementPeriod = reviewManagementPeriod;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	@Override
	public String toString() {
		return "Review [reviewCode=" + reviewCode + ", reviewCount=" + reviewCount + ", reviewOmissionCount="
				+ reviewOmissionCount + ", reviewDate=" + reviewDate + ", reviewManagementPeriod="
				+ reviewManagementPeriod + ", staff=" + staff + ", member=" + member + "]";
	}
	
}	
