package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReviewController {
	
	@GetMapping("/reviewInsert")
		public String reviewInsert() {
			return "review/reviewInsert";
	}
	
	@PostMapping("/reviewInsert")
	public String reviewInsert(Model model) {
		return "review/reviewList";
	}
	
	@GetMapping("/reviewList")
	public String reviewList() {
		return "review/reviewList";
	}
	
	@GetMapping("/reviewUpdate")
	public String reviewUpdate() {
		return "review/reviewUpdate";
	}
	
	@PostMapping("/reviewUpdate")
	public String reviewUpdate(Model model) {
		return "review/reviewList";
	}
}
