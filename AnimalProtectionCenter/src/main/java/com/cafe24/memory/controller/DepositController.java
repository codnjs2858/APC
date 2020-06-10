package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DepositController {
	
	@PostMapping("/depositInsert")
		public String depositInsert(Model model) {
			return "deposit/depositList";
	}
	
	@GetMapping("/depositInsert")
		public String depositInsert() {
			return "deposit/depositInsert";
	}
	
	@GetMapping("/depositList")
		public String depositList() {
			return "deposit/depositList";
	}
	
	@GetMapping("/depositUpdate")
		public String depositUpdate() {
			return "deposit/depositUpdate";
	}
	
	@PostMapping("/depositUpdate")
		public String depositUpdate(Model model) {
			return "deposit/depositList";
	}
	
	
}
