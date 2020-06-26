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

import com.cafe24.memory.domain.AnimalCenter;
import com.cafe24.memory.domain.Member;
import com.cafe24.memory.domain.Staff;
import com.cafe24.memory.domain.WithdrawalPet;
import com.cafe24.memory.service.AnimalCenterService;
import com.cafe24.memory.service.MemberService;
import com.cafe24.memory.service.WithdrawalPetService;



@Controller
@RequestMapping("/withdrawalpet")
public class WithdrawalPetController {
	
	private final static Logger logger = 
			LoggerFactory.getLogger(SpringBootApplication.class);
	
	@Autowired
	WithdrawalPetService withdrawalPetService;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	AnimalCenterService animalCenterService;
	
	@GetMapping("/withdrawalPetDelete")
		
	public String withdrawalPetDelete(@RequestParam(name="withdrawalPetCode" ,required = false)
										String withdrawalPetCode, Model model) {
		withdrawalPetService.deleteWithdrawalPet(withdrawalPetCode);
		
		return "redirect:/withdrawalpet/withdrawalPetList";
		
	}
	
	@PostMapping("/withdrawalPetInsert")
	public String withdrawalPetInsert(WithdrawalPet withdrawalPet, Staff staff, Member member,
											AnimalCenter animalCenter) {
			withdrawalPet.setStaff(staff);
			withdrawalPet.setMember(member);
			withdrawalPet.setAnimalCenter(animalCenter);
			
			withdrawalPetService.insertWithdrawalPet(withdrawalPet);
			logger.info("withdrawalPet<<{}" , withdrawalPet);
			return "redirect:/withdrawalpet/withdrawalPetList";
	}
	
	@GetMapping("/withdrawalPetInsert")
	public String withdrawalPetInsert(Model model) {
			
			List<Member> mList = memberService.getMemberList();
			List<AnimalCenter> aniC = animalCenterService.selectAnimalCenter();
			model.addAttribute("mList", mList);
			model.addAttribute("aniC", aniC);
			
			logger.info("mList << {}", mList);
			logger.info("aniC << {}", aniC);
			return "withdrawalpet/withdrawalPetInsert";
		
	}
	
	@GetMapping("/withdrawalPetList")
	public String withdrawalPetList(Model model) {
		
			model.addAttribute("WPL", withdrawalPetService.selectWithdrawalPet());
			
			return "withdrawalpet/withdrawalPetList";
		
	}
	
	@GetMapping("/withdrawalPetUpdate")
	public String withdrawalPetUpdate(@RequestParam(name="withdrawalPetCode" ,required = false)
										String withdrawalPetCode, Model model) {
			WithdrawalPet withdrawalPet = withdrawalPetService.selectWithdrawalPetCode(withdrawalPetCode);
			model.addAttribute("WPL" , withdrawalPet);
			
			logger.info("withdrawalPet <<{}", withdrawalPet);
			return "withdrawalpet/withdrawalPetUpdate";
	}
	
	@PostMapping("/withdrawalPetUpdate")
	public String withdrawalPetUpdate(WithdrawalPet withdrawalPet) {
		
			withdrawalPetService.updateWithdrawalPet(withdrawalPet);
			
			logger.info("withdrawalPet <<{}", withdrawalPet);
			return "redirect:/withdrawalpet/withdrawalPetList";
	}
}
