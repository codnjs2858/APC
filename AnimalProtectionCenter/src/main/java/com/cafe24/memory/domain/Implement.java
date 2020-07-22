package com.cafe24.memory.domain;

public class Implement {
	private String implementCode;
	private String implementType;
	private int implementAmount;
	private int implementReceiptCount;
	private int implementRemain;
	private int implementBreakageAmount;
	private int implementPrice;
	private String staffCode;
	private String staffName;
	private String implementRegDate;
	private int buyAmount;
	public String getImplementCode() {
		return implementCode;
	}
	public void setImplementCode(String implementCode) {
		this.implementCode = implementCode;
	}
	public String getImplementType() {
		return implementType;
	}
	public void setImplementType(String implementType) {
		this.implementType = implementType;
	}
	public int getImplementAmount() {
		return implementAmount;
	}
	public void setImplementAmount(int implementAmount) {
		this.implementAmount = implementAmount;
	}
	public int getImplementReceiptCount() {
		return implementReceiptCount;
	}
	public void setImplementReceiptCount(int implementReceiptCount) {
		this.implementReceiptCount = implementReceiptCount;
	}
	public int getImplementRemain() {
		return implementRemain;
	}
	public void setImplementRemain(int implementRemain) {
		this.implementRemain = implementRemain;
	}
	public int getImplementBreakageAmount() {
		return implementBreakageAmount;
	}
	public void setImplementBreakageAmount(int implementBreakageAmount) {
		this.implementBreakageAmount = implementBreakageAmount;
	}
	public int getImplementPrice() {
		return implementPrice;
	}
	public void setImplementPrice(int implementPrice) {
		this.implementPrice = implementPrice;
	}
	public String getStaffCode() {
		return staffCode;
	}
	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getImplementRegDate() {
		return implementRegDate;
	}
	public void setImplementRegDate(String implementRegDate) {
		this.implementRegDate = implementRegDate;
	}
	public int getBuyAmount() {
		return buyAmount;
	}
	public void setBuyAmount(int buyAmount) {
		this.buyAmount = buyAmount;
	}
	@Override
	public String toString() {
		return "Implement [implementCode=" + implementCode + ", implementType=" + implementType + ", implementAmount="
				+ implementAmount + ", implementReceiptCount=" + implementReceiptCount + ", implementRemain="
				+ implementRemain + ", implementBreakageAmount=" + implementBreakageAmount + ", implementPrice="
				+ implementPrice + ", staffCode=" + staffCode + ", staffName=" + staffName + ", implementRegDate="
				+ implementRegDate + ", buyAmount=" + buyAmount + "]";
	}
}
