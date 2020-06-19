package com.cafe24.memory.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.memory.domain.AnimalCenter;
import com.cafe24.memory.domain.AnimalType;
import com.cafe24.memory.domain.SearchReportAnimal;
import com.cafe24.memory.domain.Staff;
import com.cafe24.memory.service.AnimalCenterService;
import com.cafe24.memory.service.AnimalTypeService;

@Controller
public class AnimalCenterController {
	@Autowired private AnimalTypeService animalTypeService;
	@Autowired private AnimalCenterService animalCenterService;
	
	//animal center inset
	@GetMapping("/animalcenterinsert")
	public String insertAnimalCenterForm() {
		return "animalcenter/animalCenterInsert";
	}
	@PostMapping("/animalcenterinsert")
	public String insertAnimalCenter(Model model, AnimalType atype, Staff staff, AnimalCenter animal,SearchReportAnimal searchRe) {
		if(searchRe == null) {
			animal.setAcceptCode(null);
		}else {
			System.out.println(searchRe.getSearchReportCode()+":::accept코드 찾기 메소드??");
			animal.setAcceptCode(null);
		}
		animal.setStaff(staff);
		animal.setAnimalType(atype);
		animalCenterService.insertAnimalCenter(animal);
		return "redirect:/animalcenterlist";
	}
	@PostMapping("/animalcentertype")
	@ResponseBody
	public List<AnimalType> addProtectInsert(@RequestParam(name = "type") String type) {
		return animalTypeService.selectAnimalType(type);
	}
	//신고 내역 조회
	@PostMapping("/animalcenterReport")
	@ResponseBody
	public ArrayList<SearchReportAnimal> animalcenterReport(@RequestParam(name = "memberName") String memberName,
												@RequestParam(name = "memberPhone") String memberPhone) {
		System.out.println(animalCenterService.selectCenterReport(memberName, memberPhone));
		return animalCenterService.selectCenterReport(memberName, memberPhone);
	}
	
	//animal center list 
	@GetMapping("/animalcenterlist")
	public String listAnimalCenter(@RequestParam(name="send_type", required = false) String send_type ,Model model) {
		model.addAttribute("Cnt", animalCenterService.selectCenterCnt());
		if(send_type != null && !"".equals(send_type)) {
			model.addAttribute("AClist", animalCenterService.selectAnimalCenter(send_type));
		}else {
			model.addAttribute("AClist", animalCenterService.selectAnimalCenter());
		}
		return "animalcenter/animalCenterList";
	}
	
	//animal center update
	@GetMapping("/animalcenterupdate")
	public String updateAnimalCenterForm(
			@RequestParam(name="send_code", required = false) String send_code, Model model) {
		model.addAttribute("ac", animalCenterService.selectCenterAnimal(send_code));
		return "animalcenter/animalCenterUpdate";
	}
	@PostMapping("/animalcenterupdate")
	public String updateAnimalCenter(AnimalType atype, Staff staff, AnimalCenter animal,SearchReportAnimal searchRe) {
		if(searchRe == null) {
			animal.setAcceptCode(null);
		}else {
			System.out.println(searchRe.getSearchReportCode()+":::accept코드 찾기 메소드??");
			animal.setAcceptCode(null);
		}
		animal.setStaff(staff);
		animal.setAnimalType(atype);
		
		System.out.println("");
		return "redirect:/animalcenterlist";
	}
	
	//animal center delete
	@GetMapping("/animalcenterdelete")
	public String deleteAnimalCenter(@RequestParam(name="send_code", required = false) String send_code) {
		System.out.println("");
		return "redirect:/animalcenterlist";
	}
	
	//animal page
	@GetMapping("/animalcenterpage")
	public String pageAnimalCenter() {
		return "animalcenter/animalCenterPage";
	}
	
}
