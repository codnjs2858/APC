package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CenterReturnController {
	
	@GetMapping("centerReturnInsert")
	public String centerReturnInsert() {
		return "centerreturn/centerReturnInsert";
	}
	
	@GetMapping("centerReturnList")
	public String centerReturnList() {
		return "centerreturn/centerReturnList";
	}
	
	@GetMapping("centerReturnUpdate")
	public String centerReturnUpdate() {
		return "centerreturn/centerReturnUpdate";
	}
}
