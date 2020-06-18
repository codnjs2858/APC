package com.cafe24.memory.domain;

public class ScreeningApplication {
	private String screening_application_code;
	private String member_id;
	private String screening_application_reg_date;
	private String screening_application_state;
	public String getScreening_application_code() {
		return screening_application_code;
	}
	public void setScreening_application_code(String screening_application_code) {
		this.screening_application_code = screening_application_code;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getScreening_application_reg_date() {
		return screening_application_reg_date;
	}
	public void setScreening_application_reg_date(String screening_application_reg_date) {
		this.screening_application_reg_date = screening_application_reg_date;
	}
	public String getScreening_application_state() {
		return screening_application_state;
	}
	public void setScreening_application_state(String screening_application_state) {
		this.screening_application_state = screening_application_state;
	}
	@Override
	public String toString() {
		return "ScreeningApplication [screening_application_code=" + screening_application_code + ", member_id="
				+ member_id + ", screening_application_reg_date=" + screening_application_reg_date
				+ ", screening_application_state=" + screening_application_state + "]";
	}
	
}
