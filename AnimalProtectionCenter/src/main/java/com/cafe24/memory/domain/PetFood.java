package com.cafe24.memory.domain;

import java.util.Date;

public class PetFood {
	private String foodCode;
	private String foodCompany;
	private String foodType;
	private int foodPrice;
	private int foodAmount;
	private int foodRemain;
	private String foodName;
	private String foodBuyer;
	private Date foodPurchaseDate;
	public String getFoodCode() {
		return foodCode;
	}
	public void setFoodCode(String foodCode) {
		this.foodCode = foodCode;
	}
	public String getFoodCompany() {
		return foodCompany;
	}
	public void setFoodCompany(String foodCompany) {
		this.foodCompany = foodCompany;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public int getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}
	public int getFoodAmount() {
		return foodAmount;
	}
	public void setFoodAmount(int foodAmount) {
		this.foodAmount = foodAmount;
	}
	public int getFoodRemain() {
		return foodRemain;
	}
	public void setFoodRemain(int foodRemain) {
		this.foodRemain = foodRemain;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodBuyer() {
		return foodBuyer;
	}
	public void setFoodBuyer(String foodBuyer) {
		this.foodBuyer = foodBuyer;
	}
	public Date getFoodPurchaseDate() {
		return foodPurchaseDate;
	}
	public void setFoodPurchaseDate(Date foodPurchaseDate) {
		this.foodPurchaseDate = foodPurchaseDate;
	}
	@Override
	public String toString() {
		return "PetFood [foodCode=" + foodCode + ", foodCompany=" + foodCompany + ", foodType=" + foodType
				+ ", foodPrice=" + foodPrice + ", foodAmount=" + foodAmount + ", foodRemain=" + foodRemain
				+ ", foodName=" + foodName + ", foodBuyer=" + foodBuyer + ", foodPurchaseDate=" + foodPurchaseDate
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + foodAmount;
		result = prime * result + ((foodBuyer == null) ? 0 : foodBuyer.hashCode());
		result = prime * result + ((foodCode == null) ? 0 : foodCode.hashCode());
		result = prime * result + ((foodCompany == null) ? 0 : foodCompany.hashCode());
		result = prime * result + ((foodName == null) ? 0 : foodName.hashCode());
		result = prime * result + foodPrice;
		result = prime * result + ((foodPurchaseDate == null) ? 0 : foodPurchaseDate.hashCode());
		result = prime * result + foodRemain;
		result = prime * result + ((foodType == null) ? 0 : foodType.hashCode());
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
		PetFood other = (PetFood) obj;
		if (foodAmount != other.foodAmount)
			return false;
		if (foodBuyer == null) {
			if (other.foodBuyer != null)
				return false;
		} else if (!foodBuyer.equals(other.foodBuyer))
			return false;
		if (foodCode == null) {
			if (other.foodCode != null)
				return false;
		} else if (!foodCode.equals(other.foodCode))
			return false;
		if (foodCompany == null) {
			if (other.foodCompany != null)
				return false;
		} else if (!foodCompany.equals(other.foodCompany))
			return false;
		if (foodName == null) {
			if (other.foodName != null)
				return false;
		} else if (!foodName.equals(other.foodName))
			return false;
		if (foodPrice != other.foodPrice)
			return false;
		if (foodPurchaseDate == null) {
			if (other.foodPurchaseDate != null)
				return false;
		} else if (!foodPurchaseDate.equals(other.foodPurchaseDate))
			return false;
		if (foodRemain != other.foodRemain)
			return false;
		if (foodType == null) {
			if (other.foodType != null)
				return false;
		} else if (!foodType.equals(other.foodType))
			return false;
		return true;
	}
	
}
