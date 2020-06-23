package com.cafe24.memory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.memory.domain.Member;
import com.cafe24.memory.service.MemberService;

@Controller
@RequestMapping("/ajax")
public class AjaxSMYController {
	
	@Autowired MemberService memberService;
		
	@PostMapping("/memberType")
	@ResponseBody
		public List<Member> addMember(@RequestParam(name="type") String type){
			
		return memberService.getMemberList();
		
	}
}
