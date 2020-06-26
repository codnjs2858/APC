package com.cafe24.memory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.memory.service.GiftService;

@Controller
@RequestMapping("/gift")
public class GiftController {
	
	@Autowired GiftService giftService;
	
	
	@PostMapping("/giftInsert")
	public String giftInsert(Model model) {
		return "gift/giftList";
	}
	
	@GetMapping("/giftInsert")
	public String giftInsert() {
		return "gift/giftInsert";
	}
	
	@GetMapping("/giftList")
	public String giftList(Model model) {
		
		model.addAttribute("GL", giftService.selectGift());
		return "gift/giftList";
	}
	
	@GetMapping("/giftUpdate")
	public String giftUpdate() {
		return "gift/giftUpdate";
	}
	
	@PostMapping("/giftUpdate")
	public String giftUpdate(Model model) {
		return "gift/giftList";
	}
}
