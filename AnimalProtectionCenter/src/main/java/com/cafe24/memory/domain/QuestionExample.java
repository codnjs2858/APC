package com.cafe24.memory.domain;

public class QuestionExample {
	private String question_example_code;
	private String question_code;
	private String question_name;
	private String question_example_content;
	private String score_division;
	public String getQuestion_example_code() {
		return question_example_code;
	}
	public void setQuestion_example_code(String question_example_code) {
		this.question_example_code = question_example_code;
	}
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
	public String getQuestion_example_content() {
		return question_example_content;
	}
	public void setQuestion_example_content(String question_example_content) {
		this.question_example_content = question_example_content;
	}
	public String getScore_division() {
		return score_division;
	}
	public void setScore_division(String score_division) {
		this.score_division = score_division;
	}
	@Override
	public String toString() {
		return "QuestionExample [question_example_code=" + question_example_code + ", question_code=" + question_code
				+ ", question_name=" + question_name + ", question_example_content=" + question_example_content
				+ ", score_division=" + score_division + "]";
	}
	
}
