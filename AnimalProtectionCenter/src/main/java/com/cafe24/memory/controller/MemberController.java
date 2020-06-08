package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

	@GetMapping("/join")
	public String join(Model model) {
		model.addAttribute("title", "회원가입");
		
		return "join/join_view";
	}
}
