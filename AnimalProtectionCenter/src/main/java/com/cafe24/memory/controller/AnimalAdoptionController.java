package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import groovyjarjarpicocli.CommandLine.Model;

@Controller
public class AnimalAdoptionController {

	@GetMapping("/adoptionReview")
	public String adoptionReview(Model model) {
		return "adoption/adoptionReview";
	}
	@GetMapping("/adoptionApply")
	public String adoptionApply(Model model) {
	
		return "adoption/adoptionApplyForm";
	}
	@PostMapping("/adoptionApply")
	public String adoptionApply() {
		
		return "index";
	}
}
