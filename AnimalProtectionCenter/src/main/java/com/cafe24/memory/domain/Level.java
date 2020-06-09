package com.cafe24.memory.domain;

import java.util.Date;

public class Level {
	private String levelCode;
	private String levelName;
	private int levelNum;
	private Date levelInDate;
	public String getLevelCode() {
		return levelCode;
	}
	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	public int getLevelNum() {
		return levelNum;
	}
	public void setLevelNum(int levelNum) {
		this.levelNum = levelNum;
	}
	public Date getLevelInDate() {
		return levelInDate;
	}
	public void setLevelInDate(Date levelInDate) {
		this.levelInDate = levelInDate;
	}
	@Override
	public String toString() {
		return "Level [levelCode=" + levelCode + ", levelName=" + levelName + ", levelNum=" + levelNum
				+ ", levelInDate=" + levelInDate + "]";
	}
	
}
