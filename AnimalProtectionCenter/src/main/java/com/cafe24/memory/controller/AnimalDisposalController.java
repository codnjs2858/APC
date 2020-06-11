package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnimalDisposalController {
	
	//animal disposal
	@GetMapping("/animaldisposalinsert")
	public String insertAnimalDisposal() {
		return "animaldisposal/animalDisposalInsert";
	}
	@GetMapping("/animaldisposallist")
	public String listAnimalDisposal() {
		return "animaldisposal/animalDisposalList";
	}
	@GetMapping("/animaldisposalupdate")
	public String updateAnimalDisposal() {
		return "animaldisposal/animalDisposalUpdate";
	}
	@GetMapping("/animaldisposaldelete")
	public String deleteAnimalDisposal() {
		return "animaldisposal/animalDisposalList";
	}
	
}
