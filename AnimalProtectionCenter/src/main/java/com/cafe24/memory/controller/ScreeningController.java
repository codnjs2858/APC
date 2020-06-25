package com.cafe24.memory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.memory.service.ScreeningApplicationService;
import com.cafe24.memory.service.ScreeningCompleteService;

@Controller
@RequestMapping("/screening")
public class ScreeningController {
	@Autowired private ScreeningApplicationService screeningApplicationService;
	@Autowired private ScreeningCompleteService screeningCompleteService;
	
	@GetMapping("/screeningComplete")
	public String screeningComplete(Model model) {
		model.addAttribute("selectScreeningComplete", screeningCompleteService.selectScreeningComplete());
		return "screening/screeningComplete";
	}
	
	@GetMapping("/screeningApplication")
	public String screeningApplication(Model model) {
		model.addAttribute("selectScreeningApplication", screeningApplicationService.selectScreeningApplication());
		return "screening/screeningApplication";
	}
}
