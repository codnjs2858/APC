package com.cafe24.memory.domain;

import java.util.Date;

public class SearchReportAnimal {
	private String searchReportCode;
	private AnimalType animalType;
	private String animalGender;
	private Member member;
	private String animalDetail;
	private String animalLocation;
	private String animalPicture;
	private String searchReportInDate;
	private String searchReportOutDate;
	
	public String getAnimalDetail() {
		return animalDetail;
	}
	public void setAnimalDetail(String animalDetail) {
		this.animalDetail = animalDetail;
	}
	public String getAnimalLocation() {
		return animalLocation;
	}
	public void setAnimalLocation(String animalLocation) {
		this.animalLocation = animalLocation;
	}
	public String getAnimalPicture() {
		return animalPicture;
	}
	public void setAnimalPicture(String animalPicture) {
		this.animalPicture = animalPicture;
	}
	public String getSearchReportCode() {
		return searchReportCode;
	}
	public void setSearchReportCode(String searchReportCode) {
		this.searchReportCode = searchReportCode;
	}
	public AnimalType getAnimalType() {
		return animalType;
	}
	public void setAnimalType(AnimalType animalType) {
		this.animalType = animalType;
	}
	public String getAnimalGender() {
		return animalGender;
	}
	public void setAnimalGender(String animalGender) {
		this.animalGender = animalGender;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getSearchReportInDate() {
		return searchReportInDate;
	}
	public void setSearchReportInDate(String searchReportInDate) {
		this.searchReportInDate = searchReportInDate;
	}
	public String getSearchReportOutDate() {
		return searchReportOutDate;
	}
	public void setSearchReportOutDate(String searchReportOutDate) {
		this.searchReportOutDate = searchReportOutDate;
	}
	@Override
	public String toString() {
		return "SearchReportAnimal [searchReportCode=" + searchReportCode + ", animalType=" + animalType
				+ ", animalGender=" + animalGender + ", member=" + member + ", animalDetail=" + animalDetail
				+ ", animalLocation=" + animalLocation + ", animalPicture=" + animalPicture + ", searchReportInDate="
				+ searchReportInDate + ", searchReportOutDate=" + searchReportOutDate + "]";
	}
	
	
}
