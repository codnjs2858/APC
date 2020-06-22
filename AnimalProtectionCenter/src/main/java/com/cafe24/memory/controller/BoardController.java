package com.cafe24.memory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.memory.domain.Notice;
import com.cafe24.memory.service.NoticeService;

@Controller
public class BoardController {
	
	@Autowired private NoticeService noticeService;
	
	@PostMapping("/notice")
	public String notice(Notice notice, Model model) {
		noticeService.insertNotice(notice);
		System.out.println(notice.toString());
		return "redirect:/notice";
	}

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
