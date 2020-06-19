package com.cafe24.memory.domain;

public class Notice {
	private String board_code;
	private String member_id;
	private String board_title;
	private String board_content;
	private String board_addfile;
	private String board_date;
	private String board_delete_date;
	private String board_ip;
	public String getBoard_code() {
		return board_code;
	}
	public void setBoard_code(String board_code) {
		this.board_code = board_code;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getBoard_addfile() {
		return board_addfile;
	}
	public void setBoard_addfile(String board_addfile) {
		this.board_addfile = board_addfile;
	}
	public String getBoard_date() {
		return board_date;
	}
	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	}
	public String getBoard_delete_date() {
		return board_delete_date;
	}
	public void setBoard_delete_date(String board_delete_date) {
		this.board_delete_date = board_delete_date;
	}
	public String getBoard_ip() {
		return board_ip;
	}
	public void setBoard_ip(String board_ip) {
		this.board_ip = board_ip;
	}
	@Override
	public String toString() {
		return "Notice [board_code=" + board_code + ", member_id=" + member_id + ", board_title=" + board_title
				+ ", board_content=" + board_content + ", board_addfile=" + board_addfile + ", board_date=" + board_date
				+ ", board_delete_date=" + board_delete_date + ", board_ip=" + board_ip + "]";
	}
	
}
