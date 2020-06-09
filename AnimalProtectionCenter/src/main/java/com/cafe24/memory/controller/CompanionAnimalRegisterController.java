package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CompanionAnimalRegisterController {
	
	@GetMapping("/companionAnimalRegisterList")
	public String companionAnimalRegisterList() {
		return "companionanimalregister/companionanimalregisterlist/companionAnimalRegisterList";
		
	}
	
	@PostMapping("/addCompanionAnimalRegister")
	
	public String addCompanionAnimalRegister() {
		return "companionanimalregister/companionanimalregisterlist/companionAnimalRegisterList";
		
	}
	
	@GetMapping("/addCompanionAnimalRegister")
	public String addCompanionAnimalRegister(Model model) {
		
		return "companionanimalregister/companionanimalregisterInsert/addCompanionAnimalRegister";
		
	}
	
}
