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

import com.cafe24.memory.domain.BlackList;
import com.cafe24.memory.domain.Member;
import com.cafe24.memory.domain.Staff;
import com.cafe24.memory.service.BlackListService;
import com.cafe24.memory.service.MemberService;

@Controller
@RequestMapping("/blacklist")
public class BlackListController {
	
	private final static Logger logger = 
			LoggerFactory.getLogger(SpringBootApplication.class);
	
	@Autowired
	BlackListService blackListService;
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/blackListDelete")
	public String blackListDelete(@RequestParam(name="blackListCode" ,required = false)
									String blackListCode) {
		
		blackListService.deleteBlackList(blackListCode);	
		
		return "redirect:/blacklist/blackListList";
		
	}
	
	@PostMapping("/blackListInsert")
	public String blackListInsert(BlackList blackList ,Member member, Staff staff) {
		
		blackList.setMember(member);
		blackList.setStaff(staff);
		blackListService.insertBlackList(blackList);
		
		logger.info("member <<{}", blackList);
		
		return "redirect:/blacklist/blackListList";
	}
	
	@GetMapping("/blackListInsert")
	public String blackListInsert(Model model) {
		
		List<Member> mList = memberService.getMemberList();
		model.addAttribute("mList", mList);
		
		logger.info("mList << {}", mList);
		
		return "blacklist/blackListInsert";
	}
	
	@GetMapping("/blackListList")
	public String blackListList(Model model) {
		
		model.addAttribute("BL", blackListService.selectBlackList());
		
		return "blacklist/blackListList";
	}
	
	@GetMapping("/blackListUpdate")
	public String blackListUpdate(@RequestParam(name="blackListCode" ,required = false)
									String blackListCode, Model model) {
		
		BlackList blackList = blackListService.selectBlackListCode(blackListCode);
		
		model.addAttribute("BL" ,blackList);
		
		logger.info("blackList <<{}", blackList);
		return "blacklist/blackListUpdate";
	}
	
	@PostMapping("/blackListUpdate")
	public String blackListUpdate(BlackList blackList) {
		
		blackListService.updateBlackList(blackList);
		
		return "redirect:/blacklist/blackListList";
	}
	
}
