package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cafe24.memory.domain.SearchReportAnimal;

@Controller
public class AnimalReportController {
	
	@GetMapping("/searhReportList")
	public String searhReport(SearchReportAnimal searchAni) {
		
		
		return "search_report/search_report_list";
	}
	
	@GetMapping("/addSearchAnimal")
	public String searhReport() {
		
		
		return "search_report/search_report";
	}
	
}
