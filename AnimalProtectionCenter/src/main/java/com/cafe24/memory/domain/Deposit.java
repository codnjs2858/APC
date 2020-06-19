package com.cafe24.memory.domain;

import java.util.Date;

public class Deposit {

	private String depositCode;
	private int depositAmount;
	private String depositState;
	private Date depositDate;
	private Date depositReturnDate;
	//외래키
	private PetAdoption petAdoption;
	private Review review;
	private Staff staff;
	private Member member;
	
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getDepositCode() {
		return depositCode;
	}
	public void setDepositCode(String depositCode) {
		this.depositCode = depositCode;
	}
	public int getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(int depositAmount) {
		this.depositAmount = depositAmount;
	}
	public String getDepositState() {
		return depositState;
	}
	public void setDepositState(String depositState) {
		this.depositState = depositState;
	}
	public Date getDepositDate() {
		return depositDate;
	}
	public void setDepositDate(Date depositDate) {
		this.depositDate = depositDate;
	}
	public Date getDepositReturnDate() {
		return depositReturnDate;
	}
	public void setDepositReturnDate(Date depositReturnDate) {
		this.depositReturnDate = depositReturnDate;
	}
	public PetAdoption getPetAdoption() {
		return petAdoption;
	}
	public void setPetAdoption(PetAdoption petAdoption) {
		this.petAdoption = petAdoption;
	}
	public Review getReview() {
		return review;
	}
	public void setReview(Review review) {
		this.review = review;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	@Override
	public String toString() {
		return "Deposit [depositCode=" + depositCode + ", depositAmount=" + depositAmount + ", depositState="
				+ depositState + ", depositDate=" + depositDate + ", depositReturnDate=" + depositReturnDate
				+ ", petAdoption=" + petAdoption + ", review=" + review + ", staff=" + staff + ", member=" + member
				+ "]";
	}
	
	
	
}
