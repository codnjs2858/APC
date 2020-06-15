package com.cafe24.memory.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.memory.domain.AnimalProtect;
import com.cafe24.memory.domain.ProtectionSpace;
import com.cafe24.memory.service.ProtectionService;

@Controller
public class AnimalProtectionController {
	
	@Autowired
	ProtectionService protectionService;
	
	//session 에 있는 id
	String loginId = "id001"; 

	
	/* @RequestMapping(value = "addProtectInsert", method = RequestMethod.POST ) */
	@PostMapping("/addProtectInsert")
	@ResponseBody
	public String addProtectInsert(@RequestParam(name = "btnNamePet") String petName) {
		System.out.println(petName);
		
		petName = petName + "1213123";
		
		return petName;
	}
	
	@GetMapping("/animalProtection")
	public String animalProtection(Model model) {
		List<ProtectionSpace> protectSpaceList = protectionService.selectProtectionSpace();
		System.out.println(protectSpaceList);
		model.addAttribute("protectSpaceList", protectSpaceList);
		
		return "animalprotect/animalProctectSpace";
	}
	
	@GetMapping("/addAnimalProtection")
	public String addAnimalProtection(Model model, 
			@RequestParam(value = "space", required = false) String space) {
		model.addAttribute("space", space);
		
		return "animalprotect/animalProtectInsert";
	}
	
	@PostMapping("/animalProtection")
	public String animalProtection(AnimalProtect animalProtect, @RequestParam(name = "protectDate", required = false) String protectDate) {
		
		System.out.println(protectDate);
		System.out.println(animalProtect.toString());
		
		return "redirect:/animalProtection";
	}
}
