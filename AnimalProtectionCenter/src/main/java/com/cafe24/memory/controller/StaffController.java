package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/staff")
public class StaffController {
	//staff list
	@GetMapping("/stafflist")
	public String listStaff() {
		return "staff/staffList";
	}
	
	//staff insert
	@GetMapping("/staffinsert")
	public String insertStaffForm() {
		return "staff/staffInsert";
	}
	@PostMapping("/staffinsert")
	public String insertStaff() {
		return "redirect:/staff/stafflist";
	}

	//staff update
	@GetMapping("/staffupdate")
	public String updateStaffForm() {
		return "staff/staffUpdate";
	}
	@PostMapping("/staffupdate")
	public String updateStaff() {
		return "redirect:/staff/stafflist";
	}

	@GetMapping("/staffdelete")
	public String deleteStaff() {
		return "redirect:/staff/stafflist";
	}
	
	
	//staffcommute list
	@GetMapping("/staffcommutelist")
	public String listStaffCommute() {
		return "staffcommute/staffCommuteList";
	}
	
	
	//staffvacation list
	@GetMapping("/staffvacationlist")
	public String listStaffVacation() {
		return "staffvacation/staffVacationList";
	}

	//staffvacation insert
	@GetMapping("/staffvacationinsert")
	public String insertStaffVacationForm() {
		return "staffvacation/staffVacationInsert";
	}
	@PostMapping("/staffvacationinsert")
	public String insertStaffVacation() {
		return "redirect:/staff/staffvacationlist";
	}

	//staffvacation update
	@GetMapping("/staffvacationupdate")
	public String updateStaffVacationForm() {
		return "staffvacation/staffVacationUpdate";
	}
	@PostMapping("/staffvacationupdate")
	public String updateStaffVacation() {
		return "redirect:/staff/staffvacationlist";
	}

	//staffvacation delete
	@GetMapping("/staffvacationdelete")
	public String deleteStaffVacation() {
		return "redirect:/staff/staffvacationlist";
	}
}
