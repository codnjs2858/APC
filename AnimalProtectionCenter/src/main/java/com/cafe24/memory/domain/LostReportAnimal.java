package com.cafe24.memory.domain;

public class LostReportAnimal {
	private String lostReportCode;
	private AnimalType animalType;
	private String animalName;
	private String animalGender;
	private String animaFeature;
	private Member member;
	private String lostReportState;
	private String lostReportLocation;
	private String lostReportInDate;
	private String lostReportOutDate;
	private String lostAnimalPicture;
	
	
	public String getLostAnimalPicture() {
		return lostAnimalPicture;
	}
	public void setLostAnimalPicture(String lostAnimalPicture) {
		this.lostAnimalPicture = lostAnimalPicture;
	}
	public String getLostReportLocation() {
		return lostReportLocation;
	}
	public void setLostReportLocation(String lostReportLocation) {
		this.lostReportLocation = lostReportLocation;
	}
	public String getLostReportCode() {
		return lostReportCode;
	}
	public void setLostReportCode(String lostReportCode) {
		this.lostReportCode = lostReportCode;
	}
	public AnimalType getAnimalType() {
		return animalType;
	}
	public void setAnimalType(AnimalType animalType) {
		this.animalType = animalType;
	}
	public String getAnimalName() {
		return animalName;
	}
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	public String getAnimalGender() {
		return animalGender;
	}
	public void setAnimalGender(String animalGender) {
		this.animalGender = animalGender;
	}
	public String getAnimaFeature() {
		return animaFeature;
	}
	public void setAnimaFeature(String animaFeature) {
		this.animaFeature = animaFeature;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getLostReportState() {
		return lostReportState;
	}
	public void setLostReportState(String lostReportState) {
		this.lostReportState = lostReportState;
	}
	public String getLostReportInDate() {
		return lostReportInDate;
	}
	public void setLostReportInDate(String lostReportInDate) {
		this.lostReportInDate = lostReportInDate;
	}
	public String getLostReportOutDate() {
		return lostReportOutDate;
	}
	public void setLostReportOutDate(String lostReportOutDate) {
		this.lostReportOutDate = lostReportOutDate;
	}
	@Override
	public String toString() {
		return "LostReportAnimal [lostReportCode=" + lostReportCode + ", animalType=" + animalType + ", animalName="
				+ animalName + ", animalGender=" + animalGender + ", animaFeature=" + animaFeature + ", member="
				+ member + ", lostReportState=" + lostReportState + ", lostReportLocation=" + lostReportLocation
				+ ", lostReportInDate=" + lostReportInDate + ", lostReportOutDate=" + lostReportOutDate + "]";
	}
	
	
}
