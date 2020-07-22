package com.cafe24.memory.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.memory.domain.AnimalCenter;
import com.cafe24.memory.domain.AnimalProtect;
import com.cafe24.memory.domain.CompanionAnimalRegister;
import com.cafe24.memory.domain.ProtectionSpace;
import com.cafe24.memory.domain.Staff;
import com.cafe24.memory.service.AnimalCenterService;
import com.cafe24.memory.service.CompanionAnimalRegisterService;
import com.cafe24.memory.service.ProtectionService;

@Controller
@RequestMapping("/companionanimalregister")
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
		
		return "redirect:/companionanimalregister/companionAnimalRegisterList";
	
	}
	
	@GetMapping("/companionAnimalRegisterList")
	
	public String companionAnimalRegisterList(Model model, @RequestParam(name="sendType", required = false)
															String sendType) {
		List<CompanionAnimalRegister> cars = companionAnimalRegisterService.selectCompanionAnimalRegisterList();
		List<Map<String, Object>> selectComAniRegCount = companionAnimalRegisterService.selectComAniRegCount();
		List<ProtectionSpace> proSpace = protectionService.selectProtectionSpace();
		
		System.out.println(proSpace);
		
		//분양 현황 검색
		int totalCount = 0;
		totalCount = cars.size();
		
		if(sendType != null) {
			if("분양 가능".equals(sendType)) {
				cars = companionAnimalRegisterService.selectComAniRegList("분양 가능");
			}else if("분양 완료".equals(sendType)) {
				cars = companionAnimalRegisterService.selectComAniRegList("분양 완료");
			}else {
				cars = companionAnimalRegisterService.selectComAniRegList("기타");
			}
		}else {
			
		}
		model.addAttribute("CARS", cars);
		model.addAttribute("CRC", selectComAniRegCount);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("proSpace", proSpace);
		
		System.out.println(cars);
		System.out.println("selectComAniRegCount");
		
		return "companionanimalregister/companionAnimalRegisterList";
	
	}
	
	@PostMapping("/companionAnimalRegisterInsert")
	
	public String insertCompanionAnimalRegister(Model model, Staff staff, AnimalCenter animal, ProtectionSpace aniPro
												, CompanionAnimalRegister cAniReg) {
		
		cAniReg.setAnimalCenter(animal);
		cAniReg.setStaff(staff);
		cAniReg.setProtectionSpace(aniPro);
		companionAnimalRegisterService.insertCompanionAnimalRegister(cAniReg);
		return "redirect:/companionanimalregister/companionAnimalRegisterList";
	
	}
	
	@GetMapping("/companionAnimalRegisterInsert")

	public String companionAnimalRegisterInsert(Model model) {
	
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
		
		return "redirect:/companionanimalregister/companionAnimalRegisterList";
	
	}

	//동물 분양 가능 목록 리스트 페이지
	@GetMapping("/companionAnimalListPage")
	public String companionAnimalRegisterList(Model model){
		model.addAttribute("CARS", companionAnimalRegisterService.selectComAniRegList("분양 가능"));
		return "companionanimalregister/companionAnimalListPage";
	}
}
