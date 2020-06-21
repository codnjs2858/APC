package com.cafe24.memory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.memory.domain.AnimalCenter;
import com.cafe24.memory.domain.CompanionAnimalRegister;
import com.cafe24.memory.domain.ProtectionSpace;
import com.cafe24.memory.domain.Staff;
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
	
		public String insertCompanionAnimalRegister(Model model, Staff staff, AnimalCenter animal, ProtectionSpace aniPro
													, CompanionAnimalRegister cAniReg) {
			
			cAniReg.setAnimalCenter(animal);
			cAniReg.setStaff(staff);
			cAniReg.setProtectionSpace(aniPro);
			companionAnimalRegisterService.insertCompanionAnimalRegister(cAniReg);
			return "redirect:/companionAnimalRegisterList";
		
		}
	
	@GetMapping("/companionAnimalRegisterInsert")
	
		public String insertCompanionAnimalRegister(Model model) {
		
		 List<ProtectionSpace> proList = protectionService.selectProtectionSpace();
		 List<AnimalCenter> anicenter = animalCenterService.selectAnimalCenter();
		 model.addAttribute("prolist" ,proList);
		 model.addAttribute("aniCenNum", anicenter);
			return "companionanimalregister/companionAnimalRegisterInsert";
		
		}
	
	@GetMapping("/companionAnimalRegisterUpdate")
	
		public String companionAnimalRegisterUpdate(Model model, CompanionAnimalRegister companionAnimalRegister) {
		
		model.addAttribute("CARS", companionAnimalRegisterService.selectCompanionAnimalRegisterList());	
		model.addAttribute("CARS", animalCenterService.selectAnimalCenter());
			
			return "companionanimalregister/companionAnimalRegisterUpdate";
		
		}
	
	@PostMapping("/companionAnimalRegisterUpdate")
	
		public String companionAnimalRegisterUpdate() {
			return "redirect:/companionAnimalRegisterList";
			
		
		}
	
}
