package com.cafe24.memory.mapper;

public interface MailMapper {
	
	public boolean send(String subject, String text, String from, String to, String filePath);
}
