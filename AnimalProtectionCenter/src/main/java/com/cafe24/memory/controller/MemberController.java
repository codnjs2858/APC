package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.memory.domain.Member;

@Controller
public class MemberController {

	@GetMapping("/login")
	public String login() {
	
		
		return "member/login";
	}
	
	@PostMapping("/login")
	public String login(Member member) {
	
		
		return "index";
	}
	
	@GetMapping("/addMember")
	public String addMebmer() {

		return "member/addMember";
	}
	
	@PostMapping("/addMember")
	public String addMebmer(Model model,Member member) {
		model.addAttribute("title", "회원가입");
		return "index";
	}
}
