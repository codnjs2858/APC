package com.cafe24.memory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.memory.domain.Board;
import com.cafe24.memory.service.ReviewBoardService;

@Controller
public class ReviewBoardController {
	
	@Autowired private ReviewBoardService reviewBoardService;
	
	@GetMapping("/PostsReviewBoard")
	public String Posts(Board review, Model model) {
		model.addAttribute("selectPosts", reviewBoardService.selectPostsReviewBoard(review));
		System.out.println(reviewBoardService.selectPostsReviewBoard(review).toString());
		return "board/Posts";
	}
	
	@PostMapping("/ReviewBoard")
	public String notice(Board review, Model model) {
		reviewBoardService.insertReviewBoard(review);
		System.out.println(review.toString());
		return "redirect:/ReviewBoard";
	}

	@GetMapping("/ReviewBoard")
	public String notice(Model model) {
		model.addAttribute("title", "리뷰게시판");
		model.addAttribute("selectNotice", reviewBoardService.selectReviewBoard());
		return "board/notice";
	}
	
	@GetMapping("/ReviewBoardWrite")
	public String write(Model model) {
		model.addAttribute("send", "/ReviewBoard");
		return "board/write";
	}
}
