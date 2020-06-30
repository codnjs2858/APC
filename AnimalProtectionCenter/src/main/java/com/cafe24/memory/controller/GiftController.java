package com.cafe24.memory.controller;

import java.util.List;

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

import com.cafe24.memory.domain.Gift;
import com.cafe24.memory.domain.Member;
import com.cafe24.memory.domain.Staff;
import com.cafe24.memory.service.GiftService;
import com.cafe24.memory.service.MemberService;

@Controller
@RequestMapping("/gift")
public class GiftController {
	
	private final static Logger logger = 
			LoggerFactory.getLogger(SpringBootApplication.class);
	
	@Autowired 
	GiftService giftService;
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/giftDelete")
	public String giftDelete(@RequestParam(name="giftCode" , required = false)
											String giftCode, Model model) {
		giftService.deleteGift(giftCode);
		
		return "redirect:/gift/giftList";
	}
	
	@PostMapping("/giftInsert")
	public String giftInsert(Gift gift, Member member, Staff staff) {
		
		gift.setMember(member);
		gift.setStaff(staff);
		
		giftService.insertGift(gift);
		
		return "redirect:/gift/giftList";
	}
	
	@GetMapping("/giftInsert")
	public String giftInsert(Model model) {
		
		List<Member> mList = memberService.getMemberList();
		model.addAttribute("mList", mList);
		
		logger.info("mList << {}", mList);
		return "gift/giftInsert";
	}
	
	@GetMapping("/giftList")
	public String giftList(Model model) {
		
		model.addAttribute("GL", giftService.selectGift());
		return "gift/giftList";
	}
	
	@GetMapping("/giftUpdate")
	public String giftUpdate(@RequestParam(name="giftCode" , required = false)
											String giftCode, Model model) {
		
		Gift gift = giftService.selectGiftCode(giftCode);
		model.addAttribute("GL", gift);
		
		return "gift/giftUpdate";
	}
	
	@PostMapping("/giftUpdate")
	public String giftUpdate(Gift gift) {
		
		giftService.updateGift(gift);
		
		return "redirect:/gift/giftList";
	}
}
