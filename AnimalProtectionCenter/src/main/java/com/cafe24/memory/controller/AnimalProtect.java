package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnimalProtect {
	
	@GetMapping("/animalProtect")
	public String animalProtect(Model model) {
		
		
		return "animalprotect/animalProctectSpace";
	}
}
