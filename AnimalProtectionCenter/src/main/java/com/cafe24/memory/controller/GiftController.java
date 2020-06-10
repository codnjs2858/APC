package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GiftController {
	
	@PostMapping("/giftInsert")
	public String giftInsert(Model model) {
		return "gift/giftList";
	}
	
	@GetMapping("/giftInsert")
	public String giftInsert() {
		return "gift/giftInsert";
	}
	
	@GetMapping("/giftList")
	public String giftList() {
		return "gift/giftList";
	}
	
	@GetMapping("/giftUpdate")
	public String giftUpdate() {
		return "gift/giftUpdate";
	}
}
