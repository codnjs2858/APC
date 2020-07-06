package com.cafe24.memory.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.memory.domain.Mail;
import com.cafe24.memory.domain.Member;
import com.cafe24.memory.service.CertSerivce;
import com.cafe24.memory.service.DepositService;
import com.cafe24.memory.service.MailService;
import com.cafe24.memory.service.MemberService;



@Controller
@RequestMapping("/ajax")
public class AjaxSMYController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired 
	DepositService depositService;
	
	@Autowired 
	MailService mailService;
	
	@Autowired
	CertSerivce certSerivce; 
	
	@GetMapping("/certEmail")
	@ResponseBody
	public HashMap<String,String> certEmail(@RequestParam(name="email" ) String email){
		/* 이메일 인증 */
		System.out.println("email>>>>"+email);
		HashMap<String, String> certEmailResult = new HashMap<String,String>();
		HashMap<String, Object> certEmail = certSerivce.certEmail(email); // 보낼 메일 생성, 랜덤코드 생성 
		System.out.println("certEmail>>>" + certEmail);
		mailService.mailSend((Mail) certEmail.get("mail"));//메일 보내기 
		System.out.println("certEmail2>>>" +certEmail);
		certEmailResult.put("randomCode", (String)certEmail.get("randomCode"));
		
		return certEmailResult;
	}
	
	@PostMapping("/memberType")
	@ResponseBody
	public List<Member> addMember(@RequestParam(name="type") String type){
			
		return memberService.getMemberList();
	}
	
	@PostMapping("/reviewType")
	@ResponseBody
	public List<Map<String, Object>> addReviewCount(@RequestParam(name="type") String type){
		
		return depositService.selectReviewCount();
	}
}
	