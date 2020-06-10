package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CompanionAnimalRegisterController {
	
	@GetMapping("/companionAnimalRegisterList")
	public String companionAnimalRegisterList() {
		return "companionanimalregister/companionAnimalRegisterList";
		
	}
	
	@PostMapping("/companionAnimalRegisterInsert")
	
	public String companionAnimalRegisterInsert() {
		return "companionanimalregister/companionAnimalRegisterList";
		
	}
	
	@GetMapping("/companionAnimalRegisterInsert")
	public String companionAnimalRegisterInsert(Model model) {
		
		return "companionanimalregister/companionAnimalRegisterInsert";
		
	}
	
}
