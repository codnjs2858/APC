package com.cafe24.memory.domain;

import java.util.Date;

public class SearchReportAnimal {
	private String searchReportCode;
	private String animalCode;
	private String animalGender;
	private String memberId;
	private Date searchReportInDate;
	private Date searchReportOutDate;
	public String getSearchReportCode() {
		return searchReportCode;
	}
	public void setSearchReportCode(String searchReportCode) {
		this.searchReportCode = searchReportCode;
	}
	public String getAnimalCode() {
		return animalCode;
	}
	public void setAnimalCode(String animalCode) {
		this.animalCode = animalCode;
	}
	public String getAnimalGender() {
		return animalGender;
	}
	public void setAnimalGender(String animalGender) {
		this.animalGender = animalGender;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Date getSearchReportInDate() {
		return searchReportInDate;
	}
	public void setSearchReportInDate(Date searchReportInDate) {
		this.searchReportInDate = searchReportInDate;
	}
	public Date getSearchReportOutDate() {
		return searchReportOutDate;
	}
	public void setSearchReportOutDate(Date searchReportOutDate) {
		this.searchReportOutDate = searchReportOutDate;
	}
	@Override
	public String toString() {
		return "AnimalSearchReport [searchReportCode=" + searchReportCode + ", animalCode=" + animalCode
				+ ", animalGender=" + animalGender + ", memberId=" + memberId + ", searchReportInDate="
				+ searchReportInDate + ", searchReportOutDate=" + searchReportOutDate + "]";
	}
	
	
}
