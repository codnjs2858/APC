package com.cafe24.memory.domain;

import java.util.Date;

public class AnimalProtect {
	private String animalProtectNum;
	private String animalInsertCode;
	private String protectSpaceCode;
	private String state;
	private Date animalProtectRegDate;
	private Date animalProtectExeDate;
	public String getAnimalProtectNum() {
		return animalProtectNum;
	}
	public void setAnimalProtectNum(String animalProtectNum) {
		this.animalProtectNum = animalProtectNum;
	}
	public String getAnimalInsertCode() {
		return animalInsertCode;
	}
	public void setAnimalInsertCode(String animalInsertCode) {
		this.animalInsertCode = animalInsertCode;
	}
	public String getProtectSpaceCode() {
		return protectSpaceCode;
	}
	public void setProtectSpaceCode(String protectSpaceCode) {
		this.protectSpaceCode = protectSpaceCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getAnimalProtectRegDate() {
		return animalProtectRegDate;
	}
	public void setAnimalProtectRegDate(Date animalProtectRegDate){
		this.animalProtectRegDate = animalProtectRegDate;
	}
	public Date getAnimalProtectExeDate() {
		return animalProtectExeDate;
	}
	public void setAnimalProtectExeDate(Date animalProtectExeDate) {
		this.animalProtectExeDate = animalProtectExeDate;
	}
	@Override
	public String toString() {
		return "AnimalProtect [animalProtectNum=" + animalProtectNum + ", animalInsertCode=" + animalInsertCode
				+ ", protectSpaceCode=" + protectSpaceCode + ", state=" + state + ", animalProtectRegDate="
				+ animalProtectRegDate + ", animalProtectExeDate=" + animalProtectExeDate + "]";
	}
	
}
