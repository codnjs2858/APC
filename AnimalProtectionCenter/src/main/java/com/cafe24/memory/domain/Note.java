package com.cafe24.memory.domain;

public class Note {
	private String note_code;
	private String send_member;
	private String recipient_member;
	private String note_title;
	private String note_content;
	private String note_date;
	public String getNote_code() {
		return note_code;
	}
	public void setNote_code(String note_code) {
		this.note_code = note_code;
	}
	public String getSend_member() {
		return send_member;
	}
	public void setSend_member(String send_member) {
		this.send_member = send_member;
	}
	public String getRecipient_member() {
		return recipient_member;
	}
	public void setRecipient_member(String recipient_member) {
		this.recipient_member = recipient_member;
	}
	public String getNote_title() {
		return note_title;
	}
	public void setNote_title(String note_title) {
		this.note_title = note_title;
	}
	public String getNote_content() {
		return note_content;
	}
	public void setNote_content(String note_content) {
		this.note_content = note_content;
	}
	public String getNote_date() {
		return note_date;
	}
	public void setNote_date(String note_date) {
		this.note_date = note_date;
	}
	@Override
	public String toString() {
		return "Note [note_code=" + note_code + ", send_member=" + send_member + ", recipient_member="
				+ recipient_member + ", note_title=" + note_title + ", note_content=" + note_content + ", note_date="
				+ note_date + "]";
	}
	
}
