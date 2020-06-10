package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PetAdoptionController {
	
	@GetMapping("/petAdoptionUpdate")
		public String petAdoptionUpdate() {
		return "petadoption/petAdoptionUpdate";
		
	}
	
	@GetMapping("/petAdoptionList")
		public String petAdoptionList() {
		return "petadoption/petAdoptionList";
		
	}
	
	@GetMapping("/petAdoptionInsert")
		public String petAdoptionInsert() {
		return "petadoption/petAdoptionInsert";
	}
	
	@PostMapping("/petAdoptionInsert")
		public String petAdoptionInsert(Model model) {
			return "petadoption/petAdoptionList";
		
	}
}
