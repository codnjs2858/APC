package com.cafe24.memory.domain;

import java.util.Date;

public class PetAdoption {
	
	private String petAdoptionCode;
	private Date petAdoptionInDate;
	private Date petAdoptionManagementDate;
	private Date petAdoptionEndDate;
	private String petAdoptionState;
	//외래키
	private Member member;
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	private Adoptee adoptee;
	private Staff staff;
	
	
	public String getPetAdoptionState() {
		return petAdoptionState;
	}
	public void setPetAdoptionState(String petAdoptionState) {
		this.petAdoptionState = petAdoptionState;
	}
	public String getPetAdoptionCode() {
		return petAdoptionCode;
	}
	public void setPetAdoptionCode(String petAdoptionCode) {
		this.petAdoptionCode = petAdoptionCode;
	}
	public Date getPetAdoptionInDate() {
		return petAdoptionInDate;
	}
	public void setPetAdoptionInDate(Date petAdoptionInDate) {
		this.petAdoptionInDate = petAdoptionInDate;
	}
	public Date getPetAdoptionManagementDate() {
		return petAdoptionManagementDate;
	}
	public void setPetAdoptionManagementDate(Date petAdoptionManagementDate) {
		this.petAdoptionManagementDate = petAdoptionManagementDate;
	}
	public Date getPetAdoptionEndDate() {
		return petAdoptionEndDate;
	}
	public void setPetAdoptionEndDate(Date petAdoptionEndDate) {
		this.petAdoptionEndDate = petAdoptionEndDate;
	}
	public Adoptee getAdoptee() {
		return adoptee;
	}
	public void setAdoptee(Adoptee adoptee) {
		this.adoptee = adoptee;
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
				+ petAdoptionEndDate + ", petAdoptionState=" + petAdoptionState + ", member=" + member + ", adoptee="
				+ adoptee + ", staff=" + staff + "]";
	}
	
}
