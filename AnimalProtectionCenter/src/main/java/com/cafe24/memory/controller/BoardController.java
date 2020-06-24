package com.cafe24.memory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.memory.domain.Board;
import com.cafe24.memory.service.NoticeService;

@Controller
public class BoardController {
	
	@Autowired private NoticeService noticeService;
	
	@GetMapping("/Posts")
	public String Posts(Board notice, Model model) {
		model.addAttribute("selectPosts", noticeService.selectPosts(notice));
		System.out.println(noticeService.selectPosts(notice).toString());
		return "board/Posts";
	}
	
	@PostMapping("/notice")
	public String notice(Board notice, Model model) {
		noticeService.insertNotice(notice);
		System.out.println(notice.toString());
		return "redirect:/notice";
	}

	@GetMapping("/notice")
	public String notice(Model model) {
		model.addAttribute("title", "공고게시판");
		model.addAttribute("selectNotice", noticeService.selectNotice());
		return "board/notice";
	}
	
	@GetMapping("/write")
	public String write(Model model) {
		model.addAttribute("send", "/notice");
		return "board/write";
	}
}
