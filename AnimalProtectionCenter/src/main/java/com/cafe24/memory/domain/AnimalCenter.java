package com.cafe24.memory.domain;

import java.sql.Date;

public class AnimalCenter {
	private String animalInsertCode;
	private int animalCenterNumber;
	private String animalPicture;
	private String animalGender;
	private int animalAge;
	private int animalWeight;
	private String animalCharacter;
	private String animalState;
	private Date animalInsertRegDate;
	//외래키
	private AnimalType animalType; //AnimalType
	private Staff staff;
	private String acceptCode;
	
	
	public String getAnimalInsertCode() {
		return animalInsertCode;
	}
	public void setAnimalInsertCode(String animalInsertCode) {
		this.animalInsertCode = animalInsertCode;
	}
	public int getAnimalCenterNumber() {
		return animalCenterNumber;
	}
	public void setAnimalCenterNumber(int animalCenterNumber) {
		this.animalCenterNumber = animalCenterNumber;
	}
	public String getAnimalPicture() {
		return animalPicture;
	}
	public void setAnimalPicture(String animalPicture) {
		this.animalPicture = animalPicture;
	}
	public String getAnimalGender() {
		return animalGender;
	}
	public void setAnimalGender(String animalGender) {
		this.animalGender = animalGender;
	}
	public int getAnimalAge() {
		return animalAge;
	}
	public void setAnimalAge(int animalAge) {
		this.animalAge = animalAge;
	}
	public int getAnimalWeight() {
		return animalWeight;
	}
	public void setAnimalWeight(int animalWeight) {
		this.animalWeight = animalWeight;
	}
	public String getAnimalCharacter() {
		return animalCharacter;
	}
	public void setAnimalCharacter(String animalCharacter) {
		this.animalCharacter = animalCharacter;
	}
	public String getAnimalState() {
		return animalState;
	}
	public void setAnimalState(String animalState) {
		this.animalState = animalState;
	}
	public Date getAnimalInsertRegDate() {
		return animalInsertRegDate;
	}
	public void setAnimalInsertRegDate(Date animalInsertRegDate) {
		this.animalInsertRegDate = animalInsertRegDate;
	}
	public String getAcceptCode() {
		return acceptCode;
	}
	public void setAcceptCode(String acceptCode) {
		this.acceptCode = acceptCode;
	}
	public AnimalType getAnimalType() {
		return animalType;
	}
	public void setAnimalType(AnimalType animalType) {
		this.animalType = animalType;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	@Override
	public String toString() {
		return "AnimalCenter [animalInsertCode=" + animalInsertCode + ", animalCenterNumber=" + animalCenterNumber
				+ ", animalPicture=" + animalPicture + ", animalGender=" + animalGender + ", animalAge=" + animalAge
				+ ", animalWeight=" + animalWeight + ", animalCharacter=" + animalCharacter + ", animalState="
				+ animalState + ", animalInsertRegDate=" + animalInsertRegDate + ", animalType=" + animalType
				+ ", staff=" + staff + ", acceptCode=" + acceptCode + "]";
	}
	
}
