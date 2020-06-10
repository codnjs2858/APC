package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WithdrawalPetController {
	
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
	
}
