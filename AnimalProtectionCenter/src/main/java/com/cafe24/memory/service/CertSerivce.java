package com.cafe24.memory.service;

import java.util.*;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.memory.config.MailHandler;
import com.cafe24.memory.domain.Mail;



@Service
public class CertSerivce {
	
	
	private Mail mail = new Mail();
	
	public String setRandomCodeNum() {
		Random random = new Random();
		return String.format("%06d", random.nextInt(999999));
	}
	
	/* 회원가입시 본인인증 코드 포함하여 메일 보내기 */
	public HashMap<String,Object> certEmail(String mailAddr) {
		HashMap <String,Object> emailCert = new HashMap<String,Object>();
		String randomCode = setRandomCodeNum();
		mail.setAddress(mailAddr); 
		mail.setTitle("유기동물 보호센터 이메일 인증 코드입니다");
		mail.setMessage("인증번호는 "+randomCode+" 입니다");
		emailCert.put("randomCode",randomCode);
		emailCert.put("mail", mail);
		System.out.println(randomCode+"<---호출후");

		return emailCert;
	}
}
