package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WithdrawalPetController {
	
	@PostMapping("/withdrawalPetInsert")
		public String withdrawalPetInsert(Model model) {
			return "withdrawalpet/withdrawalPetList";
	}
	
	@GetMapping("/withdrawalPetInsert")
		public String withdrawalPetInsert() {
			return "withdrawalpet/withdrawalPetInsert";
		
	}
	
	@GetMapping("/withdrawalPetList")
		public String withdrawalPetList() {
			return "withdrawalpet/withdrawalPetList";
		
	}
	
	@GetMapping("/withdrawalPetUpdate")
		public String withdrawalPetUpdate() {
			return "withdrawalpet/withdrawalPetUpdate";
	}
	
	@PostMapping("/withdrawalPetUpdate")
		public String withdrawalPetUpdate(Model model) {
			return "withdrawalpet/withdrawalPetList";
}
}
