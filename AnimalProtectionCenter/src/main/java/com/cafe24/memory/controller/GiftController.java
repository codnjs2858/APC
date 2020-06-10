package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GiftController {
	
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
