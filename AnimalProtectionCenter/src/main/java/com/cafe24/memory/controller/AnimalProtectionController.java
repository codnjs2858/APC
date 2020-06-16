package com.cafe24.memory.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.memory.domain.AnimalProtect;
import com.cafe24.memory.domain.ProtectionSpace;
import com.cafe24.memory.service.ProtectionService;

@Controller
public class AnimalProtectionController {
	
	@Autowired
	ProtectionService protectionService;

	@PostMapping("/addProtectInsert")
	@ResponseBody
	public String addProtectInsert(@RequestParam(name = "btnNamePet") String petName) {
		System.out.println(petName);
		
		petName = petName + "1213123";
		
		return petName;
	}
	
	@PostMapping("/modifyAnimalProtection")
	@ResponseBody
	public String modifyAnimalProtection(@RequestParam(name = "btnNamePet") String petName) {
		System.out.println(petName);
		String result = "N";
		
		AnimalProtect ap = protectionService.selectAnimalProtect(petName);
		if(ap != null) {
			result = "Y";
		}
		
		return result;
	}
	
	@GetMapping("/animalProtection")
	public String animalProtection(Model model) {
		List<ProtectionSpace> protectSpaceList = protectionService.selectProtectionSpace();
		System.out.println(protectSpaceList);
		model.addAttribute("protectSpaceList", protectSpaceList);
		
		return "animalprotect/animalProctectSpace";
	}
	
	@GetMapping("/modifyAnimalProtection")
	public String modifyAnimalProtection(Model model, 
			@RequestParam(value = "space", required = false) String space) {
		ProtectionSpace ps = protectionService.modifyProtectionSpaceBySpace(space);
		long dDay = 0;
		
		if(ps != null) {
			if(ps.getAnimalProtect() != null) {
				dDay = getDday(ps.getAnimalProtect().getAnimalProtectExeDate());
			}else {
				ps.setAnimalProtect(new AnimalProtect());
			}
			
			System.out.println(dDay);
			
			model.addAttribute("dDay", dDay);
			model.addAttribute("ptSpace", ps);
		}
		
		return "animalprotect/animalProtectUpdate";
	}
	
	@GetMapping("/addAnimalProtection")
	public String addAnimalProtection(Model model) {
		return "animalprotect/animalProtectInsert";
	}
	
	@PostMapping("/animalProtection")
	public String animalProtection(AnimalProtect animalProtect, @RequestParam(name = "protectDate", required = false) String protectDate) {
		
		Date exeDate = null;
		if(protectDate != null) {
			int ptDate = Integer.parseInt(protectDate);
			
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, ptDate+2);
			
			//String exeDate = format.format(new Date(cal.getTimeInMillis()));
			exeDate = new Date(cal.getTimeInMillis());
		}
		
		System.out.println(exeDate);
		animalProtect.setAnimalProtectExeDate(exeDate);
		
		ProtectionSpace proSpace = new ProtectionSpace();
		proSpace.setAnimalProtect(animalProtect);
		
		protectionService.updateAnimalProtectionIn(proSpace);
		
		return "redirect:/animalProtection";
	}
	
	private long getDday(Date date) {
		Calendar today = Calendar.getInstance();
		Calendar exeDate = Calendar.getInstance();
		exeDate.setTime(date);
		
		long result = (exeDate.getTimeInMillis() - today.getTimeInMillis()) / (24 * 60 * 60 * 1000);
		
		return result;
	}
}
