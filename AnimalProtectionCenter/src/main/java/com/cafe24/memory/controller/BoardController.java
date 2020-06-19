package com.cafe24.memory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cafe24.memory.service.NoticeService;

@Controller
public class BoardController {
	
	@Autowired private NoticeService noticeService;

	@GetMapping("/notice")
	public String notice(Model model) {
		model.addAttribute("selectNotice", noticeService.selectQuestion());
		return "board/notice";
	}
	
	@GetMapping("/write")
	public String write(Model model) {
		return "board/write";
	}
}
