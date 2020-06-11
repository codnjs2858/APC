package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnimalHealthController {
	//animal health
	@GetMapping("/animalhealthinsert")
	public String insertAnimalHealth() {
		return "animalhealth/animalHealthInsert";
	}
	@GetMapping("/animalhealthlist")
	public String listAnimalHealth() {
		return "animalhealth/animalHealthList";
	}
	@GetMapping("/animalhealthupdate")
	public String updateAnimalHealth() {
		return "animalhealth/animalHealthUpdate";
	}
	@GetMapping("/animalhealthdelete")
	public String deleteAnimalHealth() {
		//경로 delete
		return "animalhealth/animalHealthList";
	}

	//animal health history
	@GetMapping("/animalhealthhistoryinsert")
	public String insertAnimalHealthHistory() {
		return "animalhealth/animalHealthHistoryInsert";
	}
	@GetMapping("/animalhealthhistorylist")
	public String listAnimalHealthHistory() {
		return "animalhealth/animalHealthHistoryList";
	}
	@GetMapping("/animalhealthhistoryupdate")
	public String updateAnimalHealthHistory() {
		return "animalhealth/animalHealthHistoryUpdate";
	}
	@GetMapping("/animalhealthhistorydelete")
	public String deleteAnimalHealthHistory() {
		return "animalhealth/animalHealthHistoryList";
	}
}
