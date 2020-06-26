package com.cafe24.memory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.cafe24.memory.domain.Member;
import com.cafe24.memory.domain.PetAdoption;
import com.cafe24.memory.domain.Staff;
import com.cafe24.memory.service.MemberService;
import com.cafe24.memory.service.PetAdoptionService;

@Controller
@RequestMapping("/petadoption")
public class PetAdoptionController {
	
	@Autowired
	PetAdoptionService petAdoptionService;
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/petAdoptionDelete")
	public String petAdoptionDelete(@RequestParam(name="petAdoptionCode" ,required = false)
										String petAdoptionCode) {
			
		petAdoptionService.deletePetAdoption(petAdoptionCode);
			
		return "redirect:/petadoption/petAdoptionList";
		
	}
	
	@PostMapping("/petAdoptionUpdate")
	public String petAdoptionUpdate(PetAdoption petAdoption) {
		
		petAdoptionService.updatePetAdoption(petAdoption);
		
		return "redirect:/petadoption/petAdoptionList";
	}
	
	@GetMapping("/petAdoptionUpdate")
	public String petAdoptionUpdate(@RequestParam(name="petAdoptionCode" ,required = false)
									String petAdoptionCode, Model model) {
		
		PetAdoption petAdoption = petAdoptionService.selectPetAdoption(petAdoptionCode);
		model.addAttribute("PA", petAdoption);
		
		System.out.println(petAdoption +"<-- petAdoption");
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
	public String petAdoptionInsert(PetAdoption petAdoption, Staff staff, Member member) {
		
		petAdoption.setMember(member);
		petAdoption.setStaff(staff);
		
		petAdoptionService.insertPetAdoption(petAdoption);
		System.out.println(petAdoption + "<petAdoption");
		return "redirect:/petadoption/petAdoptionList";
	
	}
	
}
