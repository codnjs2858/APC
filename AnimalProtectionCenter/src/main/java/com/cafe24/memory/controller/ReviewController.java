package com.cafe24.memory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.memory.service.ReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {
	
	@Autowired
	ReviewService reviewServiece;
	
	@GetMapping("/reviewInsert")
		public String reviewInsert() {
			return "review/reviewInsert";
	}
	
	@PostMapping("/reviewInsert")
	public String reviewInsert(Model model) {
		return "review/reviewList";
	}
	
	@GetMapping("/reviewList")
	public String reviewList(Model model) {
		
		model.addAttribute("RVL", reviewServiece.selectReview());
		
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
