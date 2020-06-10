package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdopteeController {
	
	@GetMapping("adopteeUpdate")
	public String adopteeUpdate() {
		return "adoptee/adopteeUpdate";
	}
	
	@GetMapping("adopteeList")
	public String adopteeList() {
		return "adoptee/adopteeList";
	}
	
	@GetMapping("adopteeInsert")
	public String adopteeInsert() {
		return "adoptee/adopteeInsert";
		
	}
}
