package com.cafe24.memory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.memory.service.WithdrawalPetService;

@Controller
@RequestMapping("/withdrawalpet")
public class WithdrawalPetController {
	
	@Autowired
	WithdrawalPetService withdrawalPetService;
	
	@PostMapping("/withdrawalPetInsert")
		public String withdrawalPetInsert(Model model) {
			return "withdrawalpet/withdrawalPetList";
	}
	
	@GetMapping("/withdrawalPetInsert")
		public String withdrawalPetInsert() {
			return "withdrawalpet/withdrawalPetInsert";
		
	}
	
	@GetMapping("/withdrawalPetList")
		public String withdrawalPetList(Model model) {
		
			model.addAttribute("WPL", withdrawalPetService.selectWithdrawalPet());
			
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
