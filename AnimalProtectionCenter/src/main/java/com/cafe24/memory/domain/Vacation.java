package com.cafe24.memory.domain;

public class Vacation {
	private String vacationCode;
	private String vacationAdmissionState;
	private String vacationStartDate;
	private String vacationRegDate;
	private String vacationEndDate;
	private Staff staff;
	
	public String getVacationCode() {
		return vacationCode;
	}
	public void setVacationCode(String vacationCode) {
		this.vacationCode = vacationCode;
	}
	public String getVacationAdmissionState() {
		return vacationAdmissionState;
	}
	public void setVacationAdmissionState(String vacationAdmissionState) {
		this.vacationAdmissionState = vacationAdmissionState;
	}
	public String getVacationStartDate() {
		return vacationStartDate;
	}
	public void setVacationStartDate(String vacationStartDate) {
		this.vacationStartDate = vacationStartDate;
	}
	public String getVacationRegDate() {
		return vacationRegDate;
	}
	public void setVacationRegDate(String vacationRegDate) {
		this.vacationRegDate = vacationRegDate;
	}
	public String getVacationEndDate() {
		return vacationEndDate;
	}
	public void setVacationEndDate(String vacationEndDate) {
		this.vacationEndDate = vacationEndDate;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	@Override
	public String toString() {
		return "Vacation [vacationCode=" + vacationCode + ", vacationAdmissionState=" + vacationAdmissionState
				+ ", vacationStartDate=" + vacationStartDate + ", vacationRegDate=" + vacationRegDate
				+ ", vacationEndDate=" + vacationEndDate + ", staff=" + staff + "]";
	}
	
}
