package com.cafe24.memory.domain;

import java.util.Date;

public class ProtectionSpace {
	private String protectSpaceCode;
	private String animalInsertCode;
	private String useState;
	private String implementCode;
	private Date protectSpaceRegDate;
	private String animalProtectPeriod;
	private AnimalProtect animalProtect;
	public AnimalProtect getAnimalProtect() {
		return animalProtect;
	}
	public void setAnimalProtect(AnimalProtect animalProtect) {
		this.animalProtect = animalProtect;
	}
	public String getProtectSpaceCode() {
		return protectSpaceCode;
	}
	public void setProtectSpaceCode(String protectSpaceCode) {
		this.protectSpaceCode = protectSpaceCode;
	}
	public String getAnimalInsertCode() {
		return animalInsertCode;
	}
	public void setAnimalInsertCode(String animalInsertCode) {
		this.animalInsertCode = animalInsertCode;
	}
	public String getUseState() {
		return useState;
	}
	public void setUseState(String useState) {
		this.useState = useState;
	}
	public String getImplementCode() {
		return implementCode;
	}
	public void setImplementCode(String implementCode) {
		this.implementCode = implementCode;
	}
	public Date getProtectSpaceRegDate() {
		return protectSpaceRegDate;
	}
	public void setProtectSpaceRegDate(Date protectSpaceRegDate) {
		this.protectSpaceRegDate = protectSpaceRegDate;
	}
	public String getAnimalProtectPeriod() {
		return animalProtectPeriod;
	}
	public void setAnimalProtectPeriod(String animalProtectPeriod) {
		this.animalProtectPeriod = animalProtectPeriod;
	}
	@Override
	public String toString() {
		return "ProtectionSpace [protectSpaceCode=" + protectSpaceCode + ", animalInsertCode=" + animalInsertCode
				+ ", useState=" + useState + ", implementCode=" + implementCode + ", protectSpaceRegDate="
				+ protectSpaceRegDate + ", animalProtectPeriod=" + animalProtectPeriod + ", animalProtect="
				+ animalProtect + "]";
	}
	
}
