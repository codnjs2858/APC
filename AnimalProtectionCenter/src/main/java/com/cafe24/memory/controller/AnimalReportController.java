package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.memory.domain.AnimalType;
import com.cafe24.memory.domain.SearchReportAnimal;

@Controller
public class AnimalReportController {
	
	@GetMapping("/searchReportList")
	public String searhReport(SearchReportAnimal searchAni) {
		
		
		return "searchreport/searchReportList";
	}
	@PostMapping("/searchReport")
	public String searcReport(AnimalType animalType) {
	
		return "index";
	
	}
	
	@GetMapping("/searchReport")
	public String searhReport() {
		
		
		return "searchreport/searchReport";
	}
	@GetMapping("/lostreport")
	public String lostReport() {
		
		
		return "lostreport/lostReportForm";
	}
	@PostMapping("/lostReport")
	public String lostReport(AnimalType animalType) {
		
		
		return "index";
	}
	
	@GetMapping("/reportManager")
	public String reportManager() {
		
		
		return "reportlist/reportManager";
	}
	
	
}
