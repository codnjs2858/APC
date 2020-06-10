package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CenterReturnController {
	
	@PostMapping("centerReturnInsert")
		public String centerReturnInsert(Model model) {
			return "centerreturn/centerReturnList";
		
	}
	
	@GetMapping("centerReturnInsert")
		public String centerReturnInsert() {
			return "centerreturn/centerReturnInsert";
	}
	
	@GetMapping("centerReturnList")
		public String centerReturnList() {
			return "centerreturn/centerReturnList";
	}
	
	@GetMapping("centerReturnUpdate")
		public String centerReturnUpdate() {
			return "centerreturn/centerReturnUpdate";
	}
	
	@PostMapping("centerReturnUpdate")
		public String centerReturnUpdate(Model model) {
			return "centerreturn/centerReturnList";
	}	
}
