package com.cafe24.memory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.memory.mapper.BlackListMapper;
import com.cafe24.memory.service.BlackListService;

@Controller
@RequestMapping("/blacklist")
public class BlackListController {
	
	@Autowired
		BlackListService blackListService;
	
	@PostMapping("/blackListInsert")
		public String blackListInsert(Model model) {
			return "blacklist/blackListList";
		}
	
	@GetMapping("/blackListInsert")
		public String blackListInsert() {
			return "blacklist/blackListInsert";
		}
	
	@GetMapping("/blackListList")
		public String blackListList(Model model) {
			
			model.addAttribute("BL", blackListService.selectBlackList());
			
			return "blacklist/blackListList";
		}
	
	@GetMapping("/blackListUpdate")
		public String blackListUpdate() {
			return "blacklist/blackListUpdate";
		}
	
	@PostMapping("/blackListUpdate")
		public String blackListUpdate(Model model) {
			return "blacklist/blackListList";
		}
	
}
