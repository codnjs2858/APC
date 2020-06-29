package com.cafe24.memory.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.memory.domain.Deposit;
import com.cafe24.memory.domain.Member;
import com.cafe24.memory.domain.Review;
import com.cafe24.memory.domain.Staff;
import com.cafe24.memory.service.DepositService;
import com.cafe24.memory.service.MemberService;

@Controller
@RequestMapping("/deposit")
public class DepositController {
	
	private final static Logger logger = 
			LoggerFactory.getLogger(SpringBootApplication.class);
	
	@Autowired 
	DepositService depositService;
	
	@Autowired
	MemberService memberService;
	
	@PostMapping("/depositInsert")
	public String depositInsert(Deposit deposit, Staff staff, Member member, Review review) {
		
		deposit.setReview(review);
		deposit.setMember(member);
		deposit.setStaff(staff);
		depositService.insertDeposit(deposit);
		
		return "redirect:/deposit/depositList";
	}
	
	@GetMapping("/depositInsert")
	public String depositInsert(Model model) {
			
		List<Map<String, Object>> reviewCount = depositService.selectReviewCount();
		model.addAttribute("reviewCount", reviewCount);
		
		logger.info("reviewCount << {}", reviewCount);
		return "deposit/depositInsert";
	}
	
	@GetMapping("/depositList")
	public String depositList(Model model) {
			
		model.addAttribute("DP", depositService.selectDeposit());
		
		return "deposit/depositList";
	}
	
	@GetMapping("/depositUpdate")
	public String depositUpdate() {
			
			
		return "deposit/depositUpdate";
	}
	
	@PostMapping("/depositUpdate")
	public String depositUpdate(Model model) {
		
		return "deposit/depositList";
	}
	
	
}
