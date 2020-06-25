package com.cafe24.memory.domain;

public class PetGoods {
	private String petGoodsCode;
	private String implementCode;
	private String animalInsertCode;
	private String staffCode;
	private String petGoodsRegDate;	
	public String getPetGoodsCode() {
		return petGoodsCode;
	}
	public void setPetGoodsCode(String petGoodsCode) {
		this.petGoodsCode = petGoodsCode;
	}
	public String getImplementCode() {
		return implementCode;
	}
	public void setImplementCode(String implementCode) {
		this.implementCode = implementCode;
	}
	public String getAnimalInsertCode() {
		return animalInsertCode;
	}
	public void setAnimalInsertCode(String animalInsertCode) {
		this.animalInsertCode = animalInsertCode;
	}
	public String getStaffCode() {
		return staffCode;
	}
	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}
	public String getPetGoodsRegDate() {
		return petGoodsRegDate;
	}
	public void setPetGoodsRegDate(String petGoodsRegDate) {
		this.petGoodsRegDate = petGoodsRegDate;
	}
	@Override
	public String toString() {
		return "PetGoods [petGoodsCode=" + petGoodsCode + ", implementCode=" + implementCode + ", animalInsertCode="
				+ animalInsertCode + ", staffCode=" + staffCode + ", petGoodsRegDate=" + petGoodsRegDate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((animalInsertCode == null) ? 0 : animalInsertCode.hashCode());
		result = prime * result + ((implementCode == null) ? 0 : implementCode.hashCode());
		result = prime * result + ((petGoodsCode == null) ? 0 : petGoodsCode.hashCode());
		result = prime * result + ((petGoodsRegDate == null) ? 0 : petGoodsRegDate.hashCode());
		result = prime * result + ((staffCode == null) ? 0 : staffCode.hashCode());
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
		PetGoods other = (PetGoods) obj;
		if (animalInsertCode == null) {
			if (other.animalInsertCode != null)
				return false;
		} else if (!animalInsertCode.equals(other.animalInsertCode))
			return false;
		if (implementCode == null) {
			if (other.implementCode != null)
				return false;
		} else if (!implementCode.equals(other.implementCode))
			return false;
		if (petGoodsCode == null) {
			if (other.petGoodsCode != null)
				return false;
		} else if (!petGoodsCode.equals(other.petGoodsCode))
			return false;
		if (petGoodsRegDate == null) {
			if (other.petGoodsRegDate != null)
				return false;
		} else if (!petGoodsRegDate.equals(other.petGoodsRegDate))
			return false;
		if (staffCode == null) {
			if (other.staffCode != null)
				return false;
		} else if (!staffCode.equals(other.staffCode))
			return false;
		return true;
	}
	
}
