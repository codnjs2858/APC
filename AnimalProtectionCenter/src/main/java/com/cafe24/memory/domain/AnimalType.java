package com.cafe24.memory.domain;

import java.util.Date;

public class AnimalType {
	private String animalTypeCode;
	private String animalType;
	private String animalTypeSub;
	private Date animalTypeRegDate;

	public String getAnimalTypeCode() {
		return animalTypeCode;
	}
	public void setAnimalTypeCode(String animalTypeCode) {
		this.animalTypeCode = animalTypeCode;
	}
	public String getAnimalType() {
		return animalType;
	}
	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}
	public String getAnimalTypeSub() {
		return animalTypeSub;
	}
	public void setAnimalTypeSub(String animalTypeSub) {
		this.animalTypeSub = animalTypeSub;
	}
	public Date getAnimalTypeRegDate() {
		return animalTypeRegDate;
	}
	public void setAnimalTypeRegDate(Date animalTypeRegDate) {
		this.animalTypeRegDate = animalTypeRegDate;
	}
	@Override
	public String toString() {
		return "AnimalType [animalTypeCode=" + animalTypeCode + ", animalType=" + animalType + ", animalTypeSub="
				+ animalTypeSub + ", animalTypeRegDate=" + animalTypeRegDate + "]";
	}
}
