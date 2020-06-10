package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlackListController {
	
	@PostMapping("/blackListInsert")
	public String blackListInsert(Model model) {
		return "blacklist/blackListList";
		
	}
	
	@GetMapping("/blackListInsert")
	public String blackListInsert() {
		return "blacklist/blackListInsert";
		
	}
	
	@GetMapping("/blackListList")
	public String blackListList() {
		return "blacklist/blackListList";
		
	}
	@GetMapping("/blackListUpdate")
	public String blackListUpdate() {
		return "blacklist/blackListUpdate";
		
	}
}
