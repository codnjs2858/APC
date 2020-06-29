package com.cafe24.memory.domain;

public class Deposit {

	private String depositCode;
	private int depositAmount;
	private String depositState;
	private String depositDate;
	private String depositReturnDate;
	//외래키
	private PetAdoption petAdoption;
	private Review review;
	private Staff staff;
	private Member member;
	
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
	public String getDepositDate() {
		return depositDate;
	}
	public void setDepositDate(String depositDate) {
		this.depositDate = depositDate;
	}
	public String getDepositReturnDate() {
		return depositReturnDate;
	}
	public void setDepositReturnDate(String depositReturnDate) {
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
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	@Override
	public String toString() {
		return "Deposit [depositCode=" + depositCode + ", depositAmount=" + depositAmount + ", depositState="
				+ depositState + ", depositDate=" + depositDate + ", depositReturnDate=" + depositReturnDate
				+ ", petAdoption=" + petAdoption + ", review=" + review + ", staff=" + staff + ", member=" + member
				+ "]";
	}
	
	
}
