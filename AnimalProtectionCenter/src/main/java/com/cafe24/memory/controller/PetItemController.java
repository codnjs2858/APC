package com.cafe24.memory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.memory.domain.CompanionAnimalRegister;
import com.cafe24.memory.domain.PetFood;
import com.cafe24.memory.service.CompanionAnimalRegisterService;
import com.cafe24.memory.service.PetItemService;

@Controller
public class PetItemController {
	
	@Autowired
	private PetItemService petItemService;
	
	@Autowired
	private CompanionAnimalRegisterService companionAnimalRegisterService; 
	
	@GetMapping("/petGoodsUpdate")
	public String petGoodsUpdate() {
		
		return "petitem/petGoodsUpdate";
	}
	
	@PostMapping("/petGoodsList")
	public String petGoodsList(Model model) {
		
		return "petitem/petGoodsList";
	}
	
	@GetMapping("/petGoodsList")
	public String petGoodsList() {
		
		return "petitem/petGoodsList";
	}
	
	@GetMapping("/petFoodUpdate")
	public String petFoodUpdate(Model model, 
			@RequestParam(value = "type", required = false) String type) {
		model.addAttribute("type", type);
		
		return "petitem/petFoodUpdate"; 
	}
	
	@PostMapping("/petFoodList")
	public String petFoodList() {
		
		List<CompanionAnimalRegister> lcar = companionAnimalRegisterService.selectCompanionAnimalRegisterList();
		
		return "petitem/petFoodList";
	}
	
	@GetMapping("/petFoodList")
	public String petFoodList(Model model) {
		List<PetFood> petFoodList = petItemService.selectPetFood();
		System.out.println(petFoodList);
		model.addAttribute("petFoodList", petFoodList);
		
		return "petitem/petFoodList";
	}
	
	@GetMapping("/petFoodInsert")
	public String petFoodInsert() {
		
		return "petitem/petFoodInsert";
	}
	
}
