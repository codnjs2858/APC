package com.cafe24.memory.domain;

import java.util.Date;

public class CompanionAnimalRegister {
	
	private String companionAnimalRegisterCode;
	private String animalInsertCode;
	private String animalInformationCode;
	private String memberId;
	private Date companionRegisterDate;
	private Date cancleCompanionInDate;
	private String proSpaceCode;
	
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
	public String getAnimalInformationCode() {
		return animalInformationCode;
	}
	public void setAnimalInformationCode(String animalInformationCode) {
		this.animalInformationCode = animalInformationCode;
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
				+ ", animalInsertCode=" + animalInsertCode + ", animalInformationCode=" + animalInformationCode
				+ ", memberId=" + memberId + ", companionRegisterDate=" + companionRegisterDate
				+ ", cancleCompanionInDate=" + cancleCompanionInDate + ", proSpaceCode=" + proSpaceCode + "]";
	}
	
}
