package com.cafe24.memory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.memory.domain.AnimalProtect;
import com.cafe24.memory.domain.ProtectionSpace;
import com.cafe24.memory.service.ProtectionService;

@Controller
public class AnimalProtectionController {
	
	@Autowired
	ProtectionService protectionService;
	
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
