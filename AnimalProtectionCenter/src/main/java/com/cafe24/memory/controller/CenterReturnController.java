package com.cafe24.memory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.memory.service.CenterReturnService;

@Controller
public class CenterReturnController {
	
	@Autowired
	CenterReturnService centerReturnService;
	
	@PostMapping("centerReturnInsert")
		public String centerReturnInsert(Model model) {
			return "centerreturn/centerReturnList";
		
		}
	
	@GetMapping("centerReturnInsert")
		public String centerReturnInsert() {
			return "centerreturn/centerReturnInsert";
		}
	
	@GetMapping("centerReturnList")
		public String centerReturnList(Model model) {
		
			model.addAttribute("CRL", centerReturnService.selectCenterReturn());
		
			return "centerreturn/centerReturnList";
		}
	
	@GetMapping("centerReturnUpdate")
		public String centerReturnUpdate() {
			return "centerreturn/centerReturnUpdate";
		}
	
	@PostMapping("centerReturnUpdate")
		public String centerReturnUpdate(Model model) {
			return "centerreturn/centerReturnList";
		}	
}
