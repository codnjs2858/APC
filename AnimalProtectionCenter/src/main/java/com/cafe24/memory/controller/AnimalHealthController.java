package com.cafe24.memory.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.memory.domain.AnimalCenter;
import com.cafe24.memory.domain.AnimalHealth;
import com.cafe24.memory.domain.Staff;
import com.cafe24.memory.service.AnimalCenterService;
import com.cafe24.memory.service.AnimalHealthService;

@Controller
public class AnimalHealthController {
	@Autowired AnimalHealthService animalHealthService;
	@Autowired AnimalCenterService animalCenterService;
	//animal health
	
	@GetMapping("/animalhealthlist")
	public String listAnimalHealth(Model model) {
		model.addAttribute("hlist", animalHealthService.selectAnimalHealth());
		return "animalhealth/animalHealthList";
	}
	@GetMapping("/animalhealthinsert")
	public String insertAnimalHealthForm(Model model, HttpSession session) {
		//model.addAttribute("animalNum", );
		session.getAttribute("SID");
		return "animalhealth/animalHealthInsert";
	}
	@PostMapping("/animalhealthinsert")
	public String insertAnimalHealth(AnimalHealth aheal, AnimalCenter ac, Staff staff) {
		//동물 번호로 동물 센터 코드 검색
		aheal.setAnimalCenter(animalCenterService.selectNumCode(ac.getAnimalCenterNumber()));
		aheal.setStaff(staff);
		animalHealthService.insertAnimalHealth(aheal);
		return "redirect:/animalhealthlist";
	}
	@GetMapping("/animalhealthupdate")
	public String updateAnimalHealth() {
		return "animalhealth/animalHealthUpdate";
	}
	@GetMapping("/animalhealthdelete")
	public String deleteAnimalHealth() {
		//경로 delete
		return "animalhealth/animalHealthList";
	}

	
	//animal health history
	@PostMapping("/animalhealthhistoryinsert")
	public String insertAnimalHealthHistory() {
		return "animalhealth/animalHealthHistoryInsert";
	}
	@GetMapping("/animalhealthhistoryinsert")
	public String insertAnimalHealthHistoryForm(
			@RequestParam(name = "send_code") String send_code, Model model) {
		//model.addAttribute("healnum", 건강코드로 동물 검색);
		
		return "animalhealth/animalHealthHistoryInsert";
	}
	@GetMapping("/animalhealthhistorylist")
	public String listAnimalHealthHistory(Model model) {
		model.addAttribute("hlist", animalHealthService.selectAnimalHealthed());
		return "animalhealth/animalHealthHistoryList";
	}
	@GetMapping("/animalhealthhistoryupdate")
	public String updateAnimalHealthHistory() {
		return "animalhealth/animalHealthHistoryUpdate";
	}
	@GetMapping("/animalhealthhistorydelete")
	public String deleteAnimalHealthHistory() {
		return "animalhealth/animalHealthHistoryList";
	}
}
