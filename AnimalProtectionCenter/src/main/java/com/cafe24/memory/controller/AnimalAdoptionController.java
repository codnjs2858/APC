package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import groovyjarjarpicocli.CommandLine.Model;

@Controller
public class AnimalAdoptionController {

	@GetMapping("/adoptionReview")
	public String adoptionReview(Model model) {
		return "adoption/adoptionReview";
	}
}
