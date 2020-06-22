package com.cafe24.memory.domain;


public class CompanionAnimalRegister {
	
	private String companionAnimalRegisterCode;
	private String animalInsertCode;
	private String animalInformation;
	private String companionRegisterDate;
	private String cancleCompanionInDate;
	//외래키
	private ProtectionSpace protectionSpace;
	private AnimalCenter animalCenter;
	private Staff staff;
	
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
	public String getAnimalInformation() {
		return animalInformation;
	}
	public void setAnimalInformation(String animalInformation) {
		this.animalInformation = animalInformation;
	}
	public String getCompanionRegisterDate() {
		return companionRegisterDate;
	}
	public void setCompanionRegisterDate(String companionRegisterDate) {
		this.companionRegisterDate = companionRegisterDate;
	}
	public String getCancleCompanionInDate() {
		return cancleCompanionInDate;
	}
	public void setCancleCompanionInDate(String cancleCompanionInDate) {
		this.cancleCompanionInDate = cancleCompanionInDate;
	}
	public ProtectionSpace getProtectionSpace() {
		return protectionSpace;
	}
	public void setProtectionSpace(ProtectionSpace protectionSpace) {
		this.protectionSpace = protectionSpace;
	}
	public AnimalCenter getAnimalCenter() {
		return animalCenter;
	}
	public void setAnimalCenter(AnimalCenter animalCenter) {
		this.animalCenter = animalCenter;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
	@Override
	public String toString() {
		return "CompanionAnimalRegister [companionAnimalRegisterCode=" + companionAnimalRegisterCode
				+ ", animalInsertCode=" + animalInsertCode + ", animalInformation=" + animalInformation
				+ ", companionRegisterDate=" + companionRegisterDate + ", cancleCompanionInDate="
				+ cancleCompanionInDate + ", protectionSpace=" + protectionSpace + ", animalCenter=" + animalCenter
				+ ", staff=" + staff + "]";
	}
	
	
	
}
