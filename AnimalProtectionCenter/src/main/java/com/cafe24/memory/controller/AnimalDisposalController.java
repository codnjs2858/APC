package com.cafe24.memory.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.memory.domain.AnimalDisposal;
import com.cafe24.memory.service.AnimalDisposalService;

@Controller
@RequestMapping("/animaldisposal")
public class AnimalDisposalController {
	
	private final static Logger logger = 
			LoggerFactory.getLogger(SpringBootApplication.class);
	
	@Autowired private AnimalDisposalService animalDisposalService;
	
	//animal disposal list
	@GetMapping("/animaldisposallist")
	public String listAnimalDisposal(Model model) {
		model.addAttribute("dList", animalDisposalService.selectResultTest());
		return "animaldisposal/animalDisposalList";
	}
	
	//animal disposal insert
	@GetMapping("/animaldisposalinsert")
	public String insertAnimalDisposalForm() {
		return "animaldisposal/animalDisposalInsert";
	}
	@PostMapping("/animaldisposalinsert")
	public String insertAnimalDisposal() {
		return "redirect:/animaldisposal/animaldisposallist";
	}
	
	
	//animal disposal update
	@GetMapping("/animaldisposalupdate")
	public String updateAnimalDisposalForm() {
		return "animaldisposal/animalDisposalUpdate";
	}
	@PostMapping("/animaldisposalupdate")
	public String updateAnimalDisposal() {
		return "redirect:/animaldisposal/animaldisposallist";
	}

	
	//animal disposal delete
	@GetMapping("/animaldisposaldelete")
	public String deleteAnimalDisposal() {
		return "redirect:/animaldisposal/animaldisposallist";
	}
	
}
