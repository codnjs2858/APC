package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnimalCenterController {
	//animal center
	@GetMapping("/animalcenterinsert")
	public String insertAnimalCenter() {
		return "animalcenter/animalCenterInsert";
	}
	@GetMapping("/animalcenterlist")
	public String listAnimalCenter() {
		return "animalcenter/animalCenterList";
	}
	@GetMapping("/animalcenterupdate")
	public String updateAnimalCenter() {
		return "animalcenter/animalCenterUpdate";
	}
	@GetMapping("/animalcenterdelete")
	public String deleteAnimalCenter() {
		//경로 delete
		return "animalcenter/animalCenterList";
	}
	
	
	@GetMapping("/animalcenterpage")
	public String pageAnimalCenter() {
		return "animalcenter/animalCenterPage";
	}
	
}
