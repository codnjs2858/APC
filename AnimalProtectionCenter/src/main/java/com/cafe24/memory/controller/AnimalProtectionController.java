package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnimalProtectionController {
	
	@GetMapping("/animalProtection")
	public String animalProtection() {
		System.out.println("!!!");
		
		return "animalprotect/animalProctectSpace";
	}
}
