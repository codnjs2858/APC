package com.cafe24.memory.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.memory.domain.AnimalCenter;
import com.cafe24.memory.domain.AnimalHealth;
import com.cafe24.memory.domain.Staff;
import com.cafe24.memory.service.AnimalCenterService;
import com.cafe24.memory.service.AnimalHealthService;

@Controller
@RequestMapping("/animalhealth")
public class AnimalHealthController {
	@Autowired AnimalHealthService animalHealthService;
	@Autowired AnimalCenterService animalCenterService;
	//animal health
	/*animal health list*/
	@GetMapping("/animalhealthlist")
	public String listAnimalHealth(Model model) {
		model.addAttribute("hlist", animalHealthService.selectAnimalHealth());
		model.addAttribute("subtitle", "치료 미완료 동물 리스트");
		return "animalhealth/animalHealthList";
	}
	
	/*animal health insert*/
	@GetMapping("/animalhealthinsert")
	public String insertAnimalHealthForm(Model model) {
		model.addAttribute("AList", animalCenterService.selectNoDisposal());
		return "animalhealth/animalHealthInsert";
	}
	@PostMapping("/animalhealthinsert")
	public String insertAnimalHealth(AnimalHealth aheal, AnimalCenter ac, Staff staff) {
		try{
			aheal.setAnimalCenter(ac);
			aheal.setStaff(staff);
			animalHealthService.insertAnimalHealth(aheal);
		}catch (Exception e) {
			
		}
		return "redirect:/animalhealth/animalhealthlist";
	}
	
	/*animal health update*/
	@GetMapping("/animalhealthupdate")
	public String updateAnimalHealthForm(
			@RequestParam(name="send_code", required = false) String send_code, Model model) {
		model.addAttribute("hinfo", animalHealthService.searchHealthCode(send_code));
		return "animalhealth/animalHealthUpdate";
	}
	@PostMapping("/animalhealthupdate")
	public String updateAnimalHealth(AnimalHealth aheal) {
		animalHealthService.updateAnimalHealth(aheal);
		return "redirect:/animalhealth/animalhealthlist";
	}
	
	//animal health history
	/*animal health history list*/
	@GetMapping("/animalhealthhistorylist")
	public String listAnimalHealthHistory(Model model) {
		model.addAttribute("hlist", animalHealthService.selectAnimalHealthed());
		return "animalhealth/animalHealthHistoryList";
	}
	
	/*animal health history insert+update*/
	@GetMapping("/animalhealthhistoryinsert")
	public String insertAnimalHealthHistoryForm(
			@RequestParam(name="send_code", required = false) String send_code, Model model) {
		model.addAttribute("hinfo", animalHealthService.searchHealthCode(send_code));
		return "animalhealth/animalHealthHistoryInsert";
	}
	
	/*animal health history delete*/
	@GetMapping("/animalhealthhistorydelete")
	public String deleteAnimalHealthHistory(
			@RequestParam(name="send_code", required = false) String send_code) {
		animalHealthService.deleteAnimalHealthHistory(send_code);
		return "redirect:/animalhealth/animalhealthhistorylist";
	}
	
	/*animal health delete*/
	@GetMapping("/animalhealthdelete")
	public String deleteAnimalHealth(
			@RequestParam(name="send_code", required = false) String send_code) {
		animalHealthService.deleteAnimalHealth(send_code);
		return "redirect:/animalhealth/animalhealthlist";
	}
}
