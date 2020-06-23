package com.cafe24.memory.domain;

public class Implement {
	private String implementCode;
	private String implementType;
	private int implementAmount;
	private int implementReceiptCount;
	private int implementRemain;
	private int implementBreakageAmount;
	private int implementPrice;
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
	@Override
	public String toString() {
		return "Implement [implementCode=" + implementCode + ", implementType=" + implementType + ", implementAmount="
				+ implementAmount + ", implementReceiptCount=" + implementReceiptCount + ", implementRemain="
				+ implementRemain + ", implementBreakageAmount=" + implementBreakageAmount + ", implementPrice="
				+ implementPrice + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + implementAmount;
		result = prime * result + implementBreakageAmount;
		result = prime * result + ((implementCode == null) ? 0 : implementCode.hashCode());
		result = prime * result + implementPrice;
		result = prime * result + implementReceiptCount;
		result = prime * result + implementRemain;
		result = prime * result + ((implementType == null) ? 0 : implementType.hashCode());
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
		Implement other = (Implement) obj;
		if (implementAmount != other.implementAmount)
			return false;
		if (implementBreakageAmount != other.implementBreakageAmount)
			return false;
		if (implementCode == null) {
			if (other.implementCode != null)
				return false;
		} else if (!implementCode.equals(other.implementCode))
			return false;
		if (implementPrice != other.implementPrice)
			return false;
		if (implementReceiptCount != other.implementReceiptCount)
			return false;
		if (implementRemain != other.implementRemain)
			return false;
		if (implementType == null) {
			if (other.implementType != null)
				return false;
		} else if (!implementType.equals(other.implementType))
			return false;
		return true;
	}
}
