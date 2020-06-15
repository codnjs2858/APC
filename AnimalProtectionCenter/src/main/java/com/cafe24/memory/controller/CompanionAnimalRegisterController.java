package com.cafe24.memory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.memory.domain.CompanionAnimalRegister;
import com.cafe24.memory.service.CompanionAnimalRegisterService;

@Controller
public class CompanionAnimalRegisterController {
	
	@Autowired
	CompanionAnimalRegisterService companionAnimalRegisterService;
	
	@GetMapping("/companionAnimalRegisterList")
	
		public String companionAnimalRegisterList(Model model) {
			
			model.addAttribute("companionAnimalRegisterList", companionAnimalRegisterService.selectCompanionAnimalRegisterList());
			return "companionanimalregister/companionAnimalRegisterList";
		
		}
	
	@PostMapping("/companionAnimalRegisterInsert")
	
		public String companionAnimalRegisterInsert(Model model 
													, CompanionAnimalRegister companionAnimalRegister) {
			
			model.addAttribute("mlist" , companionAnimalRegisterList(model));
			
			return "redirect:/companionAnimalRegisterList";
		
		}
	
	@GetMapping("/companionAnimalRegisterInsert")
	
		public String companionAnimalRegisterInsert(Model model) {
			List<String> memberIdList = companionAnimalRegisterService.selectMemberAll();
			System.out.println(memberIdList);
			
			model.addAttribute("mlist", memberIdList);
			
			return "companionanimalregister/companionAnimalRegisterInsert";
		
		}
	
	@GetMapping("/companionAnimalRegisterUpdate")
	
		public String companionAnimalRegisterUpdate() {
			return "companionanimalregister/companionAnimalRegisterUpdate";
		
		}
	
	@PostMapping("/companionAnimalRegisterUpdate")
	
		public String companionAnimalRegisterUpdate(Model model) {
			return "companionanimalregister/companionAnimalRegisterList";
			
		
		}
	
}
