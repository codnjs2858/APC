package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ImplementController {
	
	@PostMapping("/implementList")
	public String implement(Model model) {
		
		return "implement/implementList";
	}
	
	@GetMapping("/implementList")
	public String implement() {
		
		return "implement/implementList";
	}
	
	@GetMapping("/implementUpdate")
	public String implementUpdate() {
		
		return "implement/implementUpdate";
	}
	
}
