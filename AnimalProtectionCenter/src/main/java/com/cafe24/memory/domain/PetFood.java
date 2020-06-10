package com.cafe24.memory.domain;

public class PetFood {
	private String foodCode;
	private String foodCompany;
	private String foodType;
	private int foodPrice;
	private int foodAmount;
	private int foodRemain;
	private String foodName;
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
	@Override
	public String toString() {
		return "PetFood [foodCode=" + foodCode + ", foodCompany=" + foodCompany + ", foodType=" + foodType
				+ ", foodPrice=" + foodPrice + ", foodAmount=" + foodAmount + ", foodRemain=" + foodRemain + ", foodName="
				+ foodName + "]";
	}
}
