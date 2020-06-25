package com.cafe24.memory.domain;

public class PetAdoption {
	
	private String petAdoptionCode;
	private String petAdoptionInDate;
	private String petAdoptionManagementDate;
	private String petAdoptionEndDate;
	private String petAdoptionState;
	//외래키
	private Member member;
	private Staff staff;
	
	public String getPetAdoptionCode() {
		return petAdoptionCode;
	}
	public void setPetAdoptionCode(String petAdoptionCode) {
		this.petAdoptionCode = petAdoptionCode;
	}
	public String getPetAdoptionInDate() {
		return petAdoptionInDate;
	}
	public void setPetAdoptionInDate(String petAdoptionInDate) {
		this.petAdoptionInDate = petAdoptionInDate;
	}
	public String getPetAdoptionManagementDate() {
		return petAdoptionManagementDate;
	}
	public void setPetAdoptionManagementDate(String petAdoptionManagementDate) {
		this.petAdoptionManagementDate = petAdoptionManagementDate;
	}
	public String getPetAdoptionEndDate() {
		return petAdoptionEndDate;
	}
	public void setPetAdoptionEndDate(String petAdoptionEndDate) {
		this.petAdoptionEndDate = petAdoptionEndDate;
	}
	public String getPetAdoptionState() {
		return petAdoptionState;
	}
	public void setPetAdoptionState(String petAdoptionState) {
		this.petAdoptionState = petAdoptionState;
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
		return "PetAdoption [petAdoptionCode=" + petAdoptionCode + ", petAdoptionInDate=" + petAdoptionInDate
				+ ", petAdoptionManagementDate=" + petAdoptionManagementDate + ", petAdoptionEndDate="
				+ petAdoptionEndDate + ", petAdoptionState=" + petAdoptionState + ", member=" + member + ", staff="
				+ staff + "]";
	}
	
	
	
}
