package com.cafe24.memory.domain;

import java.util.Date;

public class CompanionAnimalRegister {
	
	private String companionAnimalRegisterCode;
	private String animalInsertCode;
	private String animalInformation;
	private String memberId;
	private Date companionRegisterDate;
	private Date cancleCompanionInDate;
	private String proSpaceCode;
	private String memberName;
	private int animalAge;
	private String animalGender;
	
	public String getAnimalInformation() {
		return animalInformation;
	}
	public void setAnimalInformation(String animalInformation) {
		this.animalInformation = animalInformation;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getAnimalAge() {
		return animalAge;
	}
	public void setAnimalAge(int animalAge) {
		this.animalAge = animalAge;
	}
	public String getAnimalGender() {
		return animalGender;
	}
	public void setAnimalGender(String animalGender) {
		this.animalGender = animalGender;
	}
	private Member member;
	
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getCompanionAnimalRegisterCode() {
		return companionAnimalRegisterCode;
	}
	public void setCompanionAnimalRegisterCode(String companionAnimalRegisterCode) {
		this.companionAnimalRegisterCode = companionAnimalRegisterCode;
	}
	public String getAnimalInsertCode() {
		return animalInsertCode;
	}
	public void setAnimalInsertCode(String animalInsertCode) {
		this.animalInsertCode = animalInsertCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Date getCompanionRegisterDate() {
		return companionRegisterDate;
	}
	public void setCompanionRegisterDate(Date companionRegisterDate) {
		this.companionRegisterDate = companionRegisterDate;
	}
	public Date getCancleCompanionInDate() {
		return cancleCompanionInDate;
	}
	public void setCancleCompanionInDate(Date cancleCompanionInDate) {
		this.cancleCompanionInDate = cancleCompanionInDate;
	}
	public String getProSpaceCode() {
		return proSpaceCode;
	}
	public void setProSpaceCode(String proSpaceCode) {
		this.proSpaceCode = proSpaceCode;
	}
	@Override
	public String toString() {
		return "CompanionAnimalRegister [companionAnimalRegisterCode=" + companionAnimalRegisterCode
				+ ", animalInsertCode=" + animalInsertCode + ", animalInformationCode=" + animalInformation
				+ ", memberId=" + memberId + ", companionRegisterDate=" + companionRegisterDate
				+ ", cancleCompanionInDate=" + cancleCompanionInDate + ", proSpaceCode=" + proSpaceCode + "]";
	}
	
}
