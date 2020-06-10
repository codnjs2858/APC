package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.memory.domain.AnimalType;
import com.cafe24.memory.domain.SearchReportAnimal;

@Controller
public class AnimalReportController {
	
	@GetMapping("/searhReportList")
	public String searhReport(SearchReportAnimal searchAni) {
		
		
		return "search_report/searchReportList";
	}
	@PostMapping("/searcReport")
	public String searcReport(AnimalType animalType) {
	
		return "index";
	
	}
	
	@GetMapping("/searcReport")
	public String searhReport() {
		
		
		return "search_report/searchReport";
	}
	
}
