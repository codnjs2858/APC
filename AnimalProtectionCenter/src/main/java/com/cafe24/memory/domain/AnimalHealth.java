package com.cafe24.memory.domain;

public class AnimalHealth {
	private String animalHealthCode;
	private String animalHealthContents;
	private String animalHealthResult;
	private String animalHealthRegDate;
	private String animalHealthEndDate;
	
	private AnimalCenter animalCenter;
	private Staff staff;
	public String getAnimalHealthCode() {
		return animalHealthCode;
	}
	public void setAnimalHealthCode(String animalHealthCode) {
		this.animalHealthCode = animalHealthCode;
	}
	public String getAnimalHealthContents() {
		return animalHealthContents;
	}
	public void setAnimalHealthContents(String animalHealthContents) {
		this.animalHealthContents = animalHealthContents;
	}
	public String getAnimalHealthResult() {
		return animalHealthResult;
	}
	public void setAnimalHealthResult(String animalHealthResult) {
		this.animalHealthResult = animalHealthResult;
	}
	public String getAnimalHealthRegDate() {
		return animalHealthRegDate;
	}
	public void setAnimalHealthRegDate(String animalHealthRegDate) {
		this.animalHealthRegDate = animalHealthRegDate;
	}
	public String getAnimalHealthEndDate() {
		return animalHealthEndDate;
	}
	public void setAnimalHealthEndDate(String animalHealthEndDate) {
		this.animalHealthEndDate = animalHealthEndDate;
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
		return "AnimalHealth [animalHealthCode=" + animalHealthCode + ", animalHealthContents=" + animalHealthContents
				+ ", animalHealthResult=" + animalHealthResult + ", animalHealthRegDate=" + animalHealthRegDate
				+ ", animalHealthEndDate=" + animalHealthEndDate + ", animalCenter=" + animalCenter + ", staff=" + staff
				+ "]";
	}
}
