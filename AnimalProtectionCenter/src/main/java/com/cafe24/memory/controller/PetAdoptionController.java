package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
