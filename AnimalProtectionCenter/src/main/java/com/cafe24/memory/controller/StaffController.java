package com.cafe24.memory.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.memory.domain.Commute;
import com.cafe24.memory.domain.Member;
import com.cafe24.memory.domain.Staff;
import com.cafe24.memory.domain.Vacation;
import com.cafe24.memory.service.StaffService;

@Controller
@RequestMapping("/staff")
public class StaffController {
	
	@Autowired private StaffService staffService;
	
	private final static Logger logger = 
	LoggerFactory.getLogger(SpringBootApplication.class);
	
	//staff list
	@GetMapping("/stafflist")
	public String listStaff(Model model, HttpSession session) {
		String send_code = (String) session.getAttribute("STAFFCODE");
		model.addAttribute("staff", staffService.selectStaffList());
		model.addAttribute("com", staffService.selectStaffList(send_code));
		return "staff/staffList";
	}
	//staff insert
	@GetMapping("/staffinsert")
	public String insertStaffForm() {
		return "staff/staffInsert";
	}
	@PostMapping("/staffinsert")
	public String insertStaff(Staff staff, Member member) {
		staff.setMember(member);
		staffService.insertStaffMember(staff);
		return "redirect:/staff/stafflist";
	}
	//staff update
	@GetMapping("/staffupdate")
	public String updateStaffForm(@RequestParam(name="send_id", required = false) String send_id, Model model) {
		model.addAttribute("sInfo", staffService.selectStaffMember(send_id));
		return "staff/staffUpdate";
	}
	@PostMapping("/staffupdate")
	public String updateStaff(Staff staff,Member member) {
		staff.setMember(member);
		staffService.updateStaffInfo(staff);
		return "redirect:/staff/stafflist";
	}
	//staff delete
	@GetMapping("/staffdelete")
	public String deleteStaff(@RequestParam(name="send_code", required = false) String send_code) {
		try {
			staffService.deleteStaff(send_code);
		}catch (Exception e) {
			System.out.println("직원 삭제 실패");
		}
		return "redirect:/staff/stafflist";
	}
	//staff retire - 직원 퇴사
	@GetMapping("/staffretire")
	public String retireStaff(@RequestParam(name="send_code", required = false) String send_code) {
		staffService.retireStaff(send_code);
		return "redirect:/staff/stafflist";
	}
	
	//staffcommute insert - 출근 (send_code = 직원코드 )
	@GetMapping("/startWork")
	public String startWork(String send_code) {
		Commute com = new Commute();
		Staff staff = new Staff();
		staff.setStaffCode(send_code);
		com.setStaff(staff);
		staffService.startWork(com);
		return "redirect:/admin";
	}
	//staffcommute end - 퇴근 (send_code = 근태코드 )
	@GetMapping("/endWork")
	public String endWork(String send_code) {
		Commute com = new Commute();
		com.setCommuteCode(send_code);
		com.setCommuteWorkingHour(staffService.selectWorkTime(send_code));
		staffService.endWork(com);
		return "redirect:/admin";
	}
	//staffcommute list
	@GetMapping("/staffcommutelist")
	public String listStaffCommute(Model model) {
		List<Commute> clist = staffService.commuteList();
		model.addAttribute("clist", clist);
		return "staffcommute/staffCommuteList";
	}
	
	
	//staffvacation list
	@GetMapping("/staffvacationlist")
	public String listStaffVacation(Model model, @RequestParam(name="send_code", required = false) String send_code) {
		List<Vacation> vacation = null;
		System.out.println(send_code);
		if(send_code != null || !"".equals(send_code)) {
			vacation = staffService.selectStaffVacation(send_code);
		}else {
			vacation = staffService.selectStaffVacation();
		}
		model.addAttribute("vacation", vacation);
		model.addAttribute("vList", staffService.selectCompleteVacation());
		return "staffvacation/staffVacationList";
	}

	//staffvacation insert
	@GetMapping("/staffvacationinsert")
	public String insertStaffVacationForm() {
		return "staffvacation/staffVacationInsert";
	}
	@PostMapping("/staffvacationinsert")
	public String insertStaffVacation(Staff staff, Vacation vacation) {
		vacation.setStaff(staff);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		try {
			Date sDate = format.parse(vacation.getVacationStartDate());
			Date eDate = format.parse(vacation.getVacationEndDate());
			int calDate = (int) (sDate.getTime() - eDate.getTime()); 
			int calDateDays = calDate / ( 24*60*60*1000); 
			calDateDays = Math.abs(calDateDays);
			vacation.setVacationTerm(calDateDays);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		staffService.insertStaffVacation(vacation);
		return "redirect:/staff/staffvacationlist";
	}

	//staffvacation delete
	@GetMapping("/staffvacationdelete")
	public String deleteStaffVacation(@RequestParam(name="send_code", required = false) String send_code) {
		staffService.deleteStaffVacation(send_code);
		return "redirect:/staff/staffvacationlist";
	}
}
