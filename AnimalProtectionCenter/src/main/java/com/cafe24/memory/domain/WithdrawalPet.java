package com.cafe24.memory.domain;

import java.util.Date;

public class WithdrawalPet {
	
	private String withdrawalPetCode;
	private String withdrawalPetReason;
	private Date withdrawalPetDate;
	//외래키
	private Staff staff;
	private AnimalCenter animalCenter;
	private Member member;
	
	public String getWithdrawalPetCode() {
		return withdrawalPetCode;
	}
	public void setWithdrawalPetCode(String withdrawalPetCode) {
		this.withdrawalPetCode = withdrawalPetCode;
	}
	public String getWithdrawalPetReason() {
		return withdrawalPetReason;
	}
	public void setWithdrawalPetReason(String withdrawalPetReason) {
		this.withdrawalPetReason = withdrawalPetReason;
	}
	public Date getWithdrawalPetDate() {
		return withdrawalPetDate;
	}
	public void setWithdrawalPetDate(Date withdrawalPetDate) {
		this.withdrawalPetDate = withdrawalPetDate;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public AnimalCenter getAnimalCenter() {
		return animalCenter;
	}
	public void setAnimalCenter(AnimalCenter animalCenter) {
		this.animalCenter = animalCenter;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	@Override
	public String toString() {
		return "WithdrawalPet [withdrawalPetCode=" + withdrawalPetCode + ", withdrawalPetReason=" + withdrawalPetReason
				+ ", withdrawalPetDate=" + withdrawalPetDate + ", staff=" + staff + ", animalCenter=" + animalCenter
				+ ", member=" + member + "]";
	}
	
	
	
}
