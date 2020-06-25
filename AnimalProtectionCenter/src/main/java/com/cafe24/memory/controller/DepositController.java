package com.cafe24.memory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.memory.service.DepositService;

@Controller
@RequestMapping("/deposit")
public class DepositController {
	
	@Autowired DepositService depositService;
	
	@PostMapping("/depositInsert")
		public String depositInsert(Model model) {
			
			return "deposit/depositList";
		}
	
	@GetMapping("/depositInsert")
		public String depositInsert() {
			return "deposit/depositInsert";
		}
	
	@GetMapping("/depositList")
		public String depositList(Model model) {
			
			model.addAttribute("DP", depositService.selectDeposit());
			
			return "deposit/depositList";
		}
	
	@GetMapping("/depositUpdate")
		public String depositUpdate() {
			
			return "deposit/depositUpdate";
		}
	
	@PostMapping("/depositUpdate")
		public String depositUpdate(Model model) {
			return "deposit/depositList";
		}
	
	
}
