package com.cafe24.memory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.memory.domain.Member;
import com.cafe24.memory.service.MemberService;

@Controller
public class MemberController {
	@Autowired private MemberService memberService;
	
	@GetMapping("/login")
	public String login() {
	
		
		return "member/login";
	}
	
	@PostMapping("/login")
	public String login(Member member) {
	
		
		return "index";
	}
	
	@GetMapping("/addMember")
	public String addMebmer() {

		return "member/addMember";
	}
	
	@PostMapping("/addMember")
	public String addMebmer(Model model,Member member) {
		model.addAttribute("title", "회원가입");
		return "index";
	}
	@GetMapping("/adminAddMember")
	public String addMebmer(Model model) {

		return "member/adminAddMember";
	}
	@GetMapping("/getMemberList")
	public String getMemberList(Model model) {
		model.addAttribute("memberList", memberService.getMemberList());
		return "member/memberList";
	}
	@GetMapping("/memberUpdate")
	public String memberUpdate(Model model,Member member) {
		System.out.println(member+"<-member");
		List<Member> mem=memberService.getMemberList(member);
		model.addAttribute("mem", mem.get(0));
		System.out.println(mem+"<-model의 mem");
		return "member/updateMember";
	}
	@PostMapping("/memberUpdate")
	public String memberUpdate(Member member) {

		return "index";
	}
	
	@GetMapping("/memberDelete")
	public String memberDelete(Member member) {
		memberService.deleteMember(member.getMemberId());
		return "index";
	}
	
}
