package com.cafe24.memory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.memory.domain.AnimalType;
import com.cafe24.memory.service.AnimalTypeService;


@Controller
public class AnimalAdoptionController {
	@Autowired private AnimalTypeService animalTypeService;
	
	@GetMapping("/adoptionReview")
	public String adoptionReview(Model model) {
		return "adoption/adoptionReview";
	}
	@GetMapping("/adoptionApply")
	public String adoptionApply(Model model) {
		List<AnimalType>AniList=animalTypeService.selectAnimalType();
		System.out.println(AniList);
		
		
		model.addAttribute("AniList", AniList);
		return "adoption/adoptionApplyForm";
	}
	@PostMapping("/adoptionApply")
	public String adoptionApply() {
		
		return "index";
	}
}
