package com.cafe24.memory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.memory.domain.Member;
import com.cafe24.memory.service.MemberService;
import com.cafe24.memory.service.PetAdoptionService;

@Controller
public class PetAdoptionController {
	
	@Autowired
	PetAdoptionService petAdoptionService;
	
	@Autowired
	MemberService memberService;
	
	@PostMapping("/petAdoptionUpdate")
		public String petAdoptionUpdate(Model model) {
			return "petadoption/petAdoptionList";
		}
	
	@GetMapping("/petAdoptionUpdate")
		public String petAdoptionUpdate() {
			return "petadoption/petAdoptionUpdate";
		
		}
	
	@GetMapping("/petAdoptionList")
		public String petAdoptionList(Model model) {
			
			model.addAttribute("PAL", petAdoptionService.seletectPetAdoption());
		
			return "petadoption/petAdoptionList";
		}
	
	@GetMapping("/petAdoptionInsert")
		public String petAdoptionInsert(Model model) {
		
		List<Member> mList = memberService.getMemberList();
		model.addAttribute("mList", mList);
			
			return "petadoption/petAdoptionInsert";
		}
	
	@PostMapping("/petAdoptionInsert")
		public String petAdoptionInsert() {
			return "petadoption/petAdoptionList";
		
		}
	
}
