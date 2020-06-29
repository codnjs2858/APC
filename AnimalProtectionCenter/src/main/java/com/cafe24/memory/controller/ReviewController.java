package com.cafe24.memory.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.memory.domain.Member;
import com.cafe24.memory.domain.Review;
import com.cafe24.memory.domain.Staff;
import com.cafe24.memory.service.MemberService;
import com.cafe24.memory.service.ReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {
	
	private final static Logger logger = 
			LoggerFactory.getLogger(SpringBootApplication.class);
	
	@Autowired
	ReviewService reviewServiece;
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/reviewDelete")
	public String reviewDelete(@RequestParam(name="reviewCode" ,required = false)
								String reviewCode, Model model) {
		
		reviewServiece.deleteReview(reviewCode);
		
		return "redirect:/review/reviewList";
		
	}
	
	@GetMapping("/reviewInsert")
	public String reviewInsert(Model model) {
		
		List<Member> mList = memberService.getMemberList();
		model.addAttribute("mList", mList);
		
		logger.info("mList << {}", mList);
		return "review/reviewInsert";
	}
	
	@PostMapping("/reviewInsert")
	public String reviewInsert(Review review, Member member, Staff staff) {
		
		review.setMember(member);
		review.setStaff(staff);
		reviewServiece.insertReview(review);
		
		logger.info("member <<{}", review);
		return "redirect:/review/reviewList";
	}
	
	@GetMapping("/reviewList")
	public String reviewList(Model model) {
		
		model.addAttribute("RVL", reviewServiece.selectReview());
		
		return "review/reviewList";
	}
	
	@GetMapping("/reviewUpdate")
	public String reviewUpdate(@RequestParam(name="reviewCode" ,required = false)
								String reviewCode, Model model) {
		Review review = reviewServiece.selectReviewCode(reviewCode);
		model.addAttribute("RVL" , review);
		
		logger.info("review <<{}", review);
		return "review/reviewUpdate";
	}
	
	@PostMapping("/reviewUpdate")
	public String reviewUpdate(Review review) {
		
		reviewServiece.updateReview(review);
		
		return "redirect:/review/reviewList";
	}
}
