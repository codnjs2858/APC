package com.cafe24.memory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.memory.service.AdopteeService;

@Controller
public class AdopteeController {
	
	@Autowired
		AdopteeService adopteeService;
	
	@PostMapping("adopteeUpdate")
		public String adopteeUpdate(Model model) {
			
			return "adoptee/adopteeList";
		}
	
	@GetMapping("adopteeUpdate")
		public String adopteeUpdate() {
			return "adoptee/adopteeUpdate";
		}
	
	@GetMapping("adopteeList")
		public String adopteeList(Model model) {
			
			model.addAttribute("ADTL", adopteeService.selectAdoptee());
			
			return "adoptee/adopteeList";
		}
	
	@GetMapping("adopteeInsert")
		public String adopteeInsert() {
			return "adoptee/adopteeInsert";
		
		}
	
	@PostMapping("adopteeInsert")
		public String adopteeInsert(Model model) {
			return "adoptee/adopteeList";
		}
}
