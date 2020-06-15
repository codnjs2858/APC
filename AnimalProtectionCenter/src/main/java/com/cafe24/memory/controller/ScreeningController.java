package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import groovyjarjarpicocli.CommandLine.Model;

@Controller
public class ScreeningController {

	@GetMapping("/screeningApplication")
	public String screeningApplication(Model model) {
		return "screening/screeningApplication";
	}
	
	@GetMapping("/screeningComplete")
	public String screeningComplete(Model model) {
		return "screening/screeningComplete";
	}
}
