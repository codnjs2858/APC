package com.cafe24.memory.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.memory.domain.Member;
import com.cafe24.memory.service.DepositService;
import com.cafe24.memory.service.MemberService;

@Controller
@RequestMapping("/ajax")
public class AjaxSMYController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired 
	DepositService depositService;
	
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
	