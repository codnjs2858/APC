package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnimalTypeController {

	@GetMapping("/animaltypelist")
	public String listAnimalType() {
		return "animaltype/animaltypelist";
	}
	@GetMapping("/animaltypeinsert")
	public String insertAnimalType() {
		return "animaltype/animaltypeinsert";
	}
	@GetMapping("/animaltypeupdate")
	public String updateAnimalType() {
		return "animaltype/animaltypeupdate";
	}
	@GetMapping("/animaltypedelete")
	public String deleteAnimalType() {
		return "animaltype/animaltypelist";
	}
	
	
	
	
	//animal center insert
	@GetMapping("/animalcenterinsert")
	public String insertAnimalCenter() {
		return "animalcenter/animalcenterinsert";
	}
	
}
