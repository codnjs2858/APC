package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlackListController {
	
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
