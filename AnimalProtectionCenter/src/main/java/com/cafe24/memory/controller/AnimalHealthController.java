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
	/*animal health list*/
	@GetMapping("/animalhealthlist")
	public String listAnimalHealth(Model model) {
		model.addAttribute("hlist", animalHealthService.selectAnimalHealth());
		return "animalhealth/animalHealthList";
	}
	/*animal health insert*/
	@GetMapping("/animalhealthinsert")
	public String insertAnimalHealthForm(Model model, HttpSession session) {
		//model.addAttribute("animalNum", );
		session.getAttribute("SID");
		return "animalhealth/animalHealthInsert";
	}
	@PostMapping("/animalhealthinsert")
	public String insertAnimalHealth(AnimalHealth aheal, AnimalCenter ac, Staff staff) {
		aheal.setAnimalCenter(animalCenterService.selectNumCode(ac.getAnimalCenterNumber()));
		aheal.setStaff(staff);
		animalHealthService.insertAnimalHealth(aheal);
		return "redirect:/animalhealthlist";
	}
	
	/*animal health update*/
	@GetMapping("/animalhealthupdate")
	public String updateAnimalHealthForm(String send_code, Model model) {
		model.addAttribute("hinfo", animalHealthService.searchHealthCode(send_code));
		return "animalhealth/animalHealthUpdate";
	}
	@PostMapping("/animalhealthupdate")
	public String updateAnimalHealth(AnimalHealth aheal) {
		animalHealthService.updateAnimalHealth(aheal);
		return "redirect:/animalhealthlist";
	}
	
	/*animal health delete*/
	@GetMapping("/animalhealthdelete")
	public String deleteAnimalHealth(String send_code) {
		animalHealthService.deleteAnimalHealth(send_code);
		return "redirect:/animalhealthlist";
	}

	
	//animal health history
	/*animal health history list*/
	@GetMapping("/animalhealthhistorylist")
	public String listAnimalHealthHistory(Model model) {
		model.addAttribute("hlist", animalHealthService.selectAnimalHealthed());
		return "animalhealth/animalHealthHistoryList";
	}
	
	/*animal health history insert*/
	@GetMapping("/animalhealthhistoryinsert")
	public String insertAnimalHealthHistoryForm(
			@RequestParam(name = "send_code") String send_code, Model model) {
		model.addAttribute("hinfo", animalHealthService.searchHealthCode(send_code));
		return "animalhealth/animalHealthHistoryInsert";
	}
	
	/*animal health history update*/
	@GetMapping("/animalhealthhistoryupdate")
	public String updateAnimalHealthHistoryForm() {
		return "animalhealth/animalHealthHistoryUpdate";
	}
	@PostMapping("/animalhealthhistoryupdate")
	public String updateAnimalHealthHistory(AnimalHealth aheal) {
		return "redirect:/animalhealthhistorylist";
	}
	
	/*animal health history delete*/
	@GetMapping("/animalhealthhistorydelete")
	public String deleteAnimalHealthHistory() {
		
		return "redirect:/animalhealthhistorylist";
	}
}
