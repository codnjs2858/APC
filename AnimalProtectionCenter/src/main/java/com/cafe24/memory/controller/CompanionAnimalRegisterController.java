package com.cafe24.memory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/companionAnimalRegisterDelete")
	
		public String companionAnimalRegisterDelete(@RequestParam(name="companionAnimalRegisterCode", required = false) String companionAnimalRegisterCode) {
			companionAnimalRegisterService.deleteCompanionAnimalRegister(companionAnimalRegisterCode);
			
			return "redirect:/companionAnimalRegisterList";
		
		}
	
	@GetMapping("/companionAnimalRegisterList")
	
		public String companionAnimalRegisterList(Model model) {
			List<CompanionAnimalRegister> cars = companionAnimalRegisterService.selectCompanionAnimalRegisterList();
			System.out.println(cars);
			model.addAttribute("CARS", cars);
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
	
		public String companionAnimalRegisterUpdate(
				@RequestParam(name="send_code", required = false) String send_code,
				@RequestParam(name="companionAnimalRegisterCode", required = false) String companionAnimalRegisterCode,
				Model model){
			CompanionAnimalRegister companionAnimalRegister = companionAnimalRegisterService.selectCompanionAnimalRegister(companionAnimalRegisterCode);
			AnimalCenter ac = animalCenterService.selectCenterAnimal(send_code);
			model.addAttribute("CARC", ac);
			model.addAttribute("CAREG", companionAnimalRegister);
			
			System.out.println(send_code + " <-- send_code companionAnimalRegisterUpdate()");
			System.out.println(ac + " <-- ac companionAnimalRegisterUpdate()" );
			System.out.println(companionAnimalRegister + " <-- companionAnimalRegister companionAnimalRegisterUpdate()" );
			System.out.println(companionAnimalRegister + "<== cAniReg");
			return "companionanimalregister/companionAnimalRegisterUpdate";
		
		}
	
	@PostMapping("/companionAnimalRegisterUpdate")
		public String companionAnimalRegisterUpdate(CompanionAnimalRegister cAniReg) {
		
			System.out.println(cAniReg + " <-- cAniReg companionAnimalRegisterUpdate()");
			companionAnimalRegisterService.updateCompanionAnimalRegister(cAniReg);
			
			return "redirect:/companionAnimalRegisterList";
		
		}
	
}
