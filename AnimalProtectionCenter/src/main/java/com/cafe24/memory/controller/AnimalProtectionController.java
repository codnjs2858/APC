package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AnimalProtectionController {
	
	@GetMapping("/animalProtection")
	public String animalProtection(Model model) {
		
		return "animalprotect/animalProctectSpace";
	}
	
	@GetMapping("/addAnimalProtection")
	public String addAnimalProtection(Model model, 
			@RequestParam(value = "space", required = false) String space) {
		model.addAttribute("space", space);
		
		return "animalprotect/animalProtectInsert";
	}
	
	@PostMapping("/animalProtection")
	public String animalProtection() {
		
		return "animalprotect/animalProctectSpace";
	}
}
