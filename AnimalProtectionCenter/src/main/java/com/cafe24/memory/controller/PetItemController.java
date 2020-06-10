package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PetItemController {
	
	@GetMapping("/petGoods")
	public String petGoods() {
		
		return "petitem/petGoodsList";
	}
	
	@GetMapping("/petFoodUpdate")
	public String petFoodUpdate(Model model, 
			@RequestParam(value = "type", required = false) String type) {
		model.addAttribute("type", type);
		
		return "petitem/petFoodUpdate"; 
	}
	
	@PostMapping("/petFoodList")
	public String petFoodList(Model model) {
		
		return "petitem/petFoodList";
	}
	
	@GetMapping("/petFoodList")
	public String petFoodList() {
		
		return "petitem/petFoodList";
	}
	
	@GetMapping("/petFoodInsert")
	public String petFoodInsert() {
		
		return "petitem/petFoodInsert";
	}
	
}
