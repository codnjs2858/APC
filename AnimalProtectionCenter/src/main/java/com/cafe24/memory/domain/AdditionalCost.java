package com.cafe24.memory.domain;

import java.util.Date;

public class AdditionalCost {
	private String additionalCostCode;
	private String companionAnimalRegisterCode;
	private String additionalCostType;
	private int additionalCostAmount;
	private Date additionalCostDate;
	public String getAdditionalCostCode() {
		return additionalCostCode;
	}
	public void setAdditionalCostCode(String additionalCostCode) {
		this.additionalCostCode = additionalCostCode;
	}
	public String getCompanionAnimalRegisterCode() {
		return companionAnimalRegisterCode;
	}
	public void setCompanionAnimalRegisterCode(String companionAnimalRegisterCode) {
		this.companionAnimalRegisterCode = companionAnimalRegisterCode;
	}
	public String getAdditionalCostType() {
		return additionalCostType;
	}
	public void setAdditionalCostType(String additionalCostType) {
		this.additionalCostType = additionalCostType;
	}
	public int getAdditionalCostAmount() {
		return additionalCostAmount;
	}
	public void setAdditionalCostAmount(int additionalCostAmount) {
		this.additionalCostAmount = additionalCostAmount;
	}
	public Date getAdditionalCostDate() {
		return additionalCostDate;
	}
	public void setAdditionalCostDate(Date additionalCostDate) {
		this.additionalCostDate = additionalCostDate;
	}
	@Override
	public String toString() {
		return "AdditionalCost [additionalCostCode=" + additionalCostCode + ", companionAnimalRegisterCode="
				+ companionAnimalRegisterCode + ", additionalCostType=" + additionalCostType + ", additionalCostAmount="
				+ additionalCostAmount + ", additionalCostDate=" + additionalCostDate + "]";
	}
	
}
