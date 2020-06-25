package com.cafe24.memory.domain;

import java.util.Date;

public class CenterReturn {
	private String centerReturnCode;
	private String centerReturnName;
	private int centerReturnAge;
	private String centerReturnAddress;
	private String centerReturnPhone;
	private Date centerReturnDate;
	private String animalType;
	//외래키 
	private Staff staff;
	
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public String getCenterReturnCode() {
		return centerReturnCode;
	}
	public void setCenterReturnCode(String centerReturnCode) {
		this.centerReturnCode = centerReturnCode;
	}
	public String getCenterReturnName() {
		return centerReturnName;
	}
	public void setCenterReturnName(String centerReturnName) {
		this.centerReturnName = centerReturnName;
	}
	public int getCenterReturnAge() {
		return centerReturnAge;
	}
	public void setCenterReturnAge(int centerReturnAge) {
		this.centerReturnAge = centerReturnAge;
	}
	public String getCenterReturnAddress() {
		return centerReturnAddress;
	}
	public void setCenterReturnAddress(String centerReturnAddress) {
		this.centerReturnAddress = centerReturnAddress;
	}
	public String getCenterReturnPhone() {
		return centerReturnPhone;
	}
	public void setCenterReturnPhone(String centerReturnPhone) {
		this.centerReturnPhone = centerReturnPhone;
	}
	public Date getCenterReturnDate() {
		return centerReturnDate;
	}
	public void setCenterReturnDate(Date centerReturnDate) {
		this.centerReturnDate = centerReturnDate;
	}
	public String getAnimalType() {
		return animalType;
	}
	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}
	
	@Override
	public String toString() {
		return "CenterReturn [centerReturnCode=" + centerReturnCode + ", centerReturnName=" + centerReturnName
				+ ", centerReturnAge=" + centerReturnAge + ", centerReturnAddress=" + centerReturnAddress
				+ ", centerReturnPhone=" + centerReturnPhone + ", centerReturnDate=" + centerReturnDate
				+ ", animalType=" + animalType + ", staff=" + staff + "]";
	}
	
	
}
