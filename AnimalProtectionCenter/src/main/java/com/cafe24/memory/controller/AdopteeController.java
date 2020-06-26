package com.cafe24.memory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.memory.domain.Adoptee;
import com.cafe24.memory.domain.Member;
import com.cafe24.memory.domain.ScreeningComplete;
import com.cafe24.memory.domain.Staff;
import com.cafe24.memory.service.AdopteeService;
import com.cafe24.memory.service.MemberService;
import com.cafe24.memory.service.ScreeningCompleteService;

@Controller
@RequestMapping("/adoptee")
public class AdopteeController {
	
	@Autowired
		AdopteeService adopteeService;
	
	@Autowired
		MemberService memberService;
	
	@Autowired
		ScreeningCompleteService screeningCompleteService;
	
	@GetMapping("/adopteeList")
	public String adopteeList(Model model) {
		
		model.addAttribute("ADTL", adopteeService.selectAdoptee());
		
		
		return "adoptee/adopteeList";
	}
	
	@GetMapping("/adopteeInsert")
	public String adopteeInsert(Model model) {
		
		List<Member> mList = memberService.getMemberList();
		List<ScreeningComplete> scList = screeningCompleteService.selectScreeningComplete();
		model.addAttribute("mList", mList);
		model.addAttribute("scList" , scList);
		
		System.out.println(mList + "<<mList");
		System.out.println(scList + "<<scList");
		return "adoptee/adopteeInsert";
	
	}
	
	@PostMapping("/adopteeInsert")
	public String adopteeInsert(Model model, Staff staff, Member member, Adoptee adoptee
								,ScreeningComplete screeningComplete) {
		
		adoptee.setMember(member);
		adoptee.setStaff(staff);
		adoptee.setScreeningComplete(screeningComplete);
		
		adopteeService.insertAdoptee(adoptee);
		return "redirect:/adoptee/adopteeList";
	}
}
