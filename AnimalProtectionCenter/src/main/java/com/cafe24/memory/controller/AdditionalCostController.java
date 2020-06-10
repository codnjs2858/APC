package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdditionalCostController {

	@GetMapping("/addtionalCostUpdate")
	public String addtionalCostUpdate() {
		
		return "addtionalcost/additionCostUpdate";
	}
	
	@PostMapping("/addtionalCost")
	public String addtionalCost(Model model) {
		
		return "addtionalcost/additionalCost";
	}
	
	@GetMapping("/addtionalCost")
	public String addtionalCost() {
		
		return "addtionalcost/additionalCost";
	}
	
	@GetMapping("/addtionalCostInsert")
	public String addtionalCostInsert() {
		
		return "addtionalcost/additionCostInsert";
	}
}
