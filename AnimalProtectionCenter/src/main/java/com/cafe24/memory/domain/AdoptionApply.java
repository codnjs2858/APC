package com.cafe24.memory.domain;

public class AdoptionApply {
	private String adoptionCode;
	private String adoptionState;
	private String adoptionPoint;
	private String adoptionInDate;
	private String adoptionAdopted;
	//외래키
	private AnimalType animalType;
	private Member member;
	private ScreeningComplete screeningComplete;
	
	public String getAdoptionCode() {
		return adoptionCode;
	}
	public void setAdoptionCode(String adoptionCode) {
		this.adoptionCode = adoptionCode;
	}
	public AnimalType getAnimalCode() {
		return animalType;
	}
	public void setAnimalCode(AnimalType animalType) {
		this.animalType = animalType;
	}
	public String getAdoptionState() {
		return adoptionState;
	}
	public void setAdoptionState(String adoptionState) {
		this.adoptionState = adoptionState;
	}
	public String getAdoptionPoint() {
		return adoptionPoint;
	}
	public void setAdoptionPoint(String adoptionPoint) {
		this.adoptionPoint = adoptionPoint;
	}
	public String getAdoptionInDate() {
		return adoptionInDate;
	}
	public void setAdoptionInDate(String adoptionInDate) {
		this.adoptionInDate = adoptionInDate;
	}
	public String getAdoptionAdopted() {
		return adoptionAdopted;
	}
	public void setAdoptionAdopted(String adoptionAdopted) {
		this.adoptionAdopted = adoptionAdopted;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public ScreeningComplete getScreeningComplete() {
		return screeningComplete;
	}
	public void setScreeningComplete(ScreeningComplete screeningComplete) {
		this.screeningComplete = screeningComplete;
	}
	@Override
	public String toString() {
		return "AdoptionApply [adoptionCode=" + adoptionCode + ", animalType=" + animalType + ", adoptionState="
				+ adoptionState + ", adoptionPoint=" + adoptionPoint + ", adoptionInDate=" + adoptionInDate
				+ ", adoptionAdopted=" + adoptionAdopted + ", member=" + member + ", screeningComplete="
				+ screeningComplete + "]";
	}
	
} 
