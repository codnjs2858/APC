package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DepositController {
	
	@GetMapping("/depositInsert")
	public String depositInsert() {
		return "deposit/depositInsert";
		
	}
	
	@GetMapping("/depositList")
	public String depositList() {
		return "deposit/depositList";
		
	}
	
	@GetMapping("/depositUpdate")
	public String depositUpdate() {
		return "deposit/depositUpdate";
		
	}
	
}
