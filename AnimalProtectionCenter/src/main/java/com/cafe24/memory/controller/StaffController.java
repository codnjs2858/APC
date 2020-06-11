package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaffController {
	//staff
	@GetMapping("/staffinsert")
	public String insertStaff() {
		return "staff/staffInsert";
	}
	@GetMapping("/stafflist")
	public String listStaff() {
		return "staff/staffList";
	}
	@GetMapping("/staffupdate")
	public String updateStaff() {
		return "staff/staffUpdate";
	}
	@GetMapping("/staffdelete")
	public String deleteStaff() {
		return "staff/staffList";
	}
	
	//staffcommute
	@GetMapping("/staffcommutelist")
	public String listStaffCommute() {
		return "staffcommute/staffCommuteList";
	}
	
	//staffvacation
	@GetMapping("/staffvacationlist")
	public String listStaffVacation() {
		return "staffvacation/staffVacationList";
	}
	@GetMapping("/staffvacationinsert")
	public String insertStaffVacation() {
		return "staffvacation/staffVacationInsert";
	}
	@GetMapping("/staffvacationupdate")
	public String updateStaffVacation() {
		return "staffvacation/staffVacationUpdate";
	}
	@GetMapping("/staffvacationdelete")
	public String deleteStaffVacation() {
		return "staffvacation/staffVacationList";
	}
}
