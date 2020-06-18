package com.cafe24.memory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.memory.domain.CompanionAnimalRegister;
import com.cafe24.memory.domain.ProtectionSpace;
import com.cafe24.memory.service.AnimalCenterService;
import com.cafe24.memory.service.CompanionAnimalRegisterService;
import com.cafe24.memory.service.ProtectionService;

@Controller
public class CompanionAnimalRegisterController {
	
	@Autowired
	CompanionAnimalRegisterService companionAnimalRegisterService;
	
	@Autowired
	ProtectionService protectionService;
	
	@Autowired
	AnimalCenterService animalCenterService;
	
	
	@GetMapping("/companionAnimalRegisterList")
	
		public String companionAnimalRegisterList(Model model) {
			
			model.addAttribute("CARS", companionAnimalRegisterService.selectCompanionAnimalRegisterList());
			return "companionanimalregister/companionAnimalRegisterList";
		
		}
	
	@PostMapping("/companionAnimalRegisterInsert")
	
		public String insertCompanionAnimalRegister(Model model 
													, CompanionAnimalRegister companionAnimalRegister) {
			
			model.addAttribute("mlist" , companionAnimalRegisterList(model));
			companionAnimalRegisterService.insertCompanionAnimalRegister(companionAnimalRegister);
			return "redirect:/companionAnimalRegisterList";
		
		}
	
	@GetMapping("/companionAnimalRegisterInsert")
	
		public String insertCompanionAnimalRegister(Model model) {
			List<String> memberIdList = companionAnimalRegisterService.selectMemberAll();
			List<ProtectionSpace> proList = protectionService.selectProtectionSpace();
			System.out.println(memberIdList);
			
			model.addAttribute("mlist", memberIdList);
			model.addAttribute("prolist" , proList);
			return "companionanimalregister/companionAnimalRegisterInsert";
		
		}
	
	@GetMapping("/companionAnimalRegisterUpdate")
	
		public String companionAnimalRegisterUpdate() {
			return "companionanimalregister/companionAnimalRegisterUpdate";
		
		}
	
	@PostMapping("/companionAnimalRegisterUpdate")
	
		public String companionAnimalRegisterUpdate(Model model) {
			return "redirect:/companionAnimalRegisterList";
			
		
		}
	
}
