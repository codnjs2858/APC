package com.cafe24.memory.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.memory.domain.Adoptee;
import com.cafe24.memory.domain.Member;
import com.cafe24.memory.domain.ReportManger;
import com.cafe24.memory.domain.Review;
import com.cafe24.memory.service.AdopteeService;
import com.cafe24.memory.service.AnimalReportService;
import com.cafe24.memory.service.MemberService;
import com.cafe24.memory.service.NoteService;
import com.cafe24.memory.service.ReviewService;

@Controller
@RequestMapping("/my")
public class MyPageController {
	
	private final static Logger logger = 
			LoggerFactory.getLogger(SpringBootApplication.class);
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	NoteService noteService;
	
	@Autowired
	AdopteeService adopteeService;
	
	@Autowired
	AnimalReportService reportService;
	
	@Autowired
	ReviewService reviewService;
	
	@GetMapping("/myPageAdmin")
	public String myPageAdmin(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		String mId = (String) session.getAttribute("SID");
		logger.info("세션에 있는 아이디 {}", mId);
		Member member = null;
		Adoptee adoptee = null;
		ReportManger reportManager = null;
		List<Review> review = new ArrayList<Review>();
		//아이디로 멤버 찾기
		//입양신청 찾기
		//신고 찾기
		//후기 등록 찾기
		if(mId != null && !"".equals(mId)) {
			member = memberService.getMemberList(mId);
			adoptee = adopteeService.selectAdopteeById(mId);
			List<ReportManger> reportAllList = reportService.selectAllReport();
			for(int i = 0; i < reportAllList.size(); i++) {
				ReportManger re = new ReportManger(); 
				re = reportAllList.get(i);
				if(re.getMember().getMemberId().equals(mId)) {
					reportManager = re;
					break;
				}
			}
			List<Review> reviewList = reviewService.selectReview();
			for(int i = 0; i < reviewList.size(); i++) {
				Review re = reviewList.get(i);
				if(re.getMember().getMemberId().equals(mId)) {
					review.add(re);
					break;
				}
			}
			
		}
		logger.info("member {}", member);
		logger.info("adoptee {}", adoptee);
		logger.info("reportManager {}", reportManager);
		logger.info("review {}", review);
		
		String adopteeInfo = "입양 불가능";
		
		if(adoptee != null) {
			if("screening_complete_code_01".equals(adoptee.getScreeningComplete().getScreening_complete_code())) {
				adopteeInfo = "입양가능";
			}			
		}
		
		model.addAttribute("member", member);
		model.addAttribute("adoptee", adopteeInfo);
		model.addAttribute("reportManager", reportManager);
		model.addAttribute("review", review);
		
		model.addAttribute("noteList", noteService.selectNote(mId));
		model.addAttribute("sendNoteList", noteService.selectSendNote(mId));
		
		return "/mypage/myPageAdmin";
	}
	
	@GetMapping("/myPage")
	public String myPage(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String mId = (String) session.getAttribute("SID");
		
		logger.info("세션에 있는 아이디 {}", mId);
		Member member = null;
		Adoptee adoptee = null;
		ReportManger reportManager = null;
		List<Review> review = new ArrayList<Review>();
		//아이디로 멤버 찾기
		//입양신청 찾기
		//신고 찾기
		//후기 등록 찾기
		if(mId != null && !"".equals(mId)) {
			member = memberService.getMemberList(mId);
			adoptee = adopteeService.selectAdopteeById(mId);
			List<ReportManger> reportAllList = reportService.selectAllReport();
			for(int i = 0; i < reportAllList.size(); i++) {
				ReportManger re = new ReportManger(); 
				re = reportAllList.get(i);
				if(re.getMember().getMemberId().equals(mId)) {
					reportManager = re;
					break;
				}
			}
			List<Review> reviewList = reviewService.selectReview();
			for(int i = 0; i < reviewList.size(); i++) {
				Review re = reviewList.get(i);
				if(re.getMember().getMemberId().equals(mId)) {
					review.add(re);
					break;
				}
			}
			
		}
		logger.info("member {}", member);
		logger.info("adoptee {}", adoptee);
		logger.info("reportManager {}", reportManager);
		logger.info("review {}", review);
		
		String adopteeInfo = "입양 불가능";
		
		if(adoptee != null) {
			if("screening_complete_code_01".equals(adoptee.getScreeningComplete().getScreening_complete_code())) {
				adopteeInfo = "입양가능";
			}			
		}
		
		model.addAttribute("member", member);
		model.addAttribute("adoptee", adopteeInfo);
		model.addAttribute("reportManager", reportManager);
		model.addAttribute("review", review);
		
		model.addAttribute("noteList", noteService.selectNote(mId));
		model.addAttribute("sendNoteList", noteService.selectSendNote(mId));
		
		return "/mypage/myPage";
	}
}
