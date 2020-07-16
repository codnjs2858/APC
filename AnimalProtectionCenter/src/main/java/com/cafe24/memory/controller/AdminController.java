package com.cafe24.memory.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.memory.service.StaffService;

@Controller
public class AdminController {
	@Autowired private StaffService staffService;
	
	@GetMapping("/")
	public String intro(HttpSession session) {
		String send_code = (String) session.getAttribute("STAFFCODE");
		if(send_code != null) {
			session.setAttribute("com", staffService.selectStaffList(send_code));
		}
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
	
	@PostMapping("/admin")
	public String admin(Model model) {
		return "admin/admin";
	}
	
	@GetMapping("/admin")
	public String admin(HttpSession session) {
		String send_code = (String) session.getAttribute("STAFFCODE");
		if(send_code != null) {
			session.setAttribute("com", staffService.selectStaffList(send_code));
		}
		return "admin/admin";
	}
	@GetMapping("/member/blacklistMemberAlert")
	public String blacklistMemberAlert() {
		return "member/blacklistMemberAlert";
	}
}
