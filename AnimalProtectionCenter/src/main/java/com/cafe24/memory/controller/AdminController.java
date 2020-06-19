package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
	
	@GetMapping("/")
	public String intro() {
		return "intro/intro";
	}
	@GetMapping("/index")
	public String index(Model model) {
		return "index";
	}
	
	@PostMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin/admin";
	}
	@GetMapping("/blacklistMemberAlert")
	public String blacklistMemberAlert() {
		return "member/blacklistMemberAlert";
	}
}
