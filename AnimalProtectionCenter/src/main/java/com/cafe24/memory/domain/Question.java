package com.cafe24.memory.domain;

public class Question {
	private String question_code;
	private String question_name;
	private String question_desc;
	private String question_score;
	private String question_reg_date;
	private String question_modify_date;
	public String getQuestion_code() {
		return question_code;
	}
	public void setQuestion_code(String question_code) {
		this.question_code = question_code;
	}
	public String getQuestion_name() {
		return question_name;
	}
	public void setQuestion_name(String question_name) {
		this.question_name = question_name;
	}
	public String getQuestion_desc() {
		return question_desc;
	}
	public void setQuestion_desc(String question_desc) {
		this.question_desc = question_desc;
	}
	public String getQuestion_score() {
		return question_score;
	}
	public void setQuestion_score(String question_score) {
		this.question_score = question_score;
	}
	public String getQuestion_reg_date() {
		return question_reg_date;
	}
	public void setQuestion_reg_date(String question_reg_date) {
		this.question_reg_date = question_reg_date;
	}
	public String getQuestion_modify_date() {
		return question_modify_date;
	}
	public void setQuestion_modify_date(String question_modify_date) {
		this.question_modify_date = question_modify_date;
	}
	@Override
	public String toString() {
		return "Question [question_code=" + question_code + ", question_name=" + question_name + ", question_desc="
				+ question_desc + ", question_score=" + question_score + ", question_reg_date=" + question_reg_date
				+ ", question_modify_date=" + question_modify_date + "]";
	}
	
}
