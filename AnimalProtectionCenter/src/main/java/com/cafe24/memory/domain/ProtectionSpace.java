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
	private AnimalCenter animalCenter;
	public AnimalCenter getAnimalCenter() {
		return animalCenter;
	}
	public void setAnimalCenter(AnimalCenter animalCenter) {
		this.animalCenter = animalCenter;
	}
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
				+ animalProtect + ", animalCenter=" + animalCenter + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((animalCenter == null) ? 0 : animalCenter.hashCode());
		result = prime * result + ((animalInsertCode == null) ? 0 : animalInsertCode.hashCode());
		result = prime * result + ((animalProtect == null) ? 0 : animalProtect.hashCode());
		result = prime * result + ((animalProtectPeriod == null) ? 0 : animalProtectPeriod.hashCode());
		result = prime * result + ((implementCode == null) ? 0 : implementCode.hashCode());
		result = prime * result + ((protectSpaceCode == null) ? 0 : protectSpaceCode.hashCode());
		result = prime * result + ((protectSpaceRegDate == null) ? 0 : protectSpaceRegDate.hashCode());
		result = prime * result + ((useState == null) ? 0 : useState.hashCode());
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
		ProtectionSpace other = (ProtectionSpace) obj;
		if (animalCenter == null) {
			if (other.animalCenter != null)
				return false;
		} else if (!animalCenter.equals(other.animalCenter))
			return false;
		if (animalInsertCode == null) {
			if (other.animalInsertCode != null)
				return false;
		} else if (!animalInsertCode.equals(other.animalInsertCode))
			return false;
		if (animalProtect == null) {
			if (other.animalProtect != null)
				return false;
		} else if (!animalProtect.equals(other.animalProtect))
			return false;
		if (animalProtectPeriod == null) {
			if (other.animalProtectPeriod != null)
				return false;
		} else if (!animalProtectPeriod.equals(other.animalProtectPeriod))
			return false;
		if (implementCode == null) {
			if (other.implementCode != null)
				return false;
		} else if (!implementCode.equals(other.implementCode))
			return false;
		if (protectSpaceCode == null) {
			if (other.protectSpaceCode != null)
				return false;
		} else if (!protectSpaceCode.equals(other.protectSpaceCode))
			return false;
		if (protectSpaceRegDate == null) {
			if (other.protectSpaceRegDate != null)
				return false;
		} else if (!protectSpaceRegDate.equals(other.protectSpaceRegDate))
			return false;
		if (useState == null) {
			if (other.useState != null)
				return false;
		} else if (!useState.equals(other.useState))
			return false;
		return true;
	}
	
}
