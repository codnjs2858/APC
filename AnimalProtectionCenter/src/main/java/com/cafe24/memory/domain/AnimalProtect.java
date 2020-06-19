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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((animalInsertCode == null) ? 0 : animalInsertCode.hashCode());
		result = prime * result + ((animalProtectExeDate == null) ? 0 : animalProtectExeDate.hashCode());
		result = prime * result + ((animalProtectNum == null) ? 0 : animalProtectNum.hashCode());
		result = prime * result + ((animalProtectRegDate == null) ? 0 : animalProtectRegDate.hashCode());
		result = prime * result + ((protectSpaceCode == null) ? 0 : protectSpaceCode.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnimalProtect other = (AnimalProtect) obj;
		if (animalInsertCode == null) {
			if (other.animalInsertCode != null)
				return false;
		} else if (!animalInsertCode.equals(other.animalInsertCode))
			return false;
		if (animalProtectExeDate == null) {
			if (other.animalProtectExeDate != null)
				return false;
		} else if (!animalProtectExeDate.equals(other.animalProtectExeDate))
			return false;
		if (animalProtectNum == null) {
			if (other.animalProtectNum != null)
				return false;
		} else if (!animalProtectNum.equals(other.animalProtectNum))
			return false;
		if (animalProtectRegDate == null) {
			if (other.animalProtectRegDate != null)
				return false;
		} else if (!animalProtectRegDate.equals(other.animalProtectRegDate))
			return false;
		if (protectSpaceCode == null) {
			if (other.protectSpaceCode != null)
				return false;
		} else if (!protectSpaceCode.equals(other.protectSpaceCode))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}
	
}
