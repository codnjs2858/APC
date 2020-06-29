package com.cafe24.memory.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.memory.domain.AnimalType;
import com.cafe24.memory.domain.Member;
import com.cafe24.memory.domain.SearchReportAnimal;
import com.cafe24.memory.service.AnimalReportService;

import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping("/reportlist")
public class AnimalReportController {
	private final static Logger logger = 
			(Logger) LoggerFactory.getLogger(SpringBootApplication.class);
	
	@Autowired private AnimalReportService animalReportService;
	@GetMapping("/searchReportList")
	public String searhReport(SearchReportAnimal searchAni) {
		
		
		return "searchreport/searchReportList";
	}
	@PostMapping("/searchReport")
	public String searcReport(AnimalType aType,Member member,SearchReportAnimal searchReportAnimal) {
		searchReportAnimal.setAnimalType(aType);
		searchReportAnimal.setMember(member);
		logger.info("{}"+searchReportAnimal);
		animalReportService.insertAnimalReport(searchReportAnimal);
		return "redirect:/reportlist/searchReportList";
	
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
	/**
	 * 신고 취소,삭제시 db에서 신고 취소버튼 날짜 now()를 가져와서 list에 신고취소날짜로 뿌려줌
	 */
	@PostMapping("/cacelSearchReport")
	public String cacelSearchReport(){
		return "searchreport/searchReportList";
	
	}
}
