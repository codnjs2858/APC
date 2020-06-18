package com.cafe24.memory.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@ResponseBody
	public String login(HttpServletRequest request,@RequestParam(name="id")String loginId,
			@RequestParam(name="pw")String loginPw) {
		
			HttpSession session=request.getSession();
			
			String result=memberService.loginConfirm(loginId, loginPw,session);
			if(result.equals("로그인성공")) {
				return "index";
			}else {
				return "아이디와 비밀번호를 다시 확인하세요";
			}
		} 
	
	
	@GetMapping("/addMember")
	public String addMebmer() {

		return "member/addMember";
	}
	
	@PostMapping("/addMember")
	public String addMebmer(Model model,Member member) {
		model.addAttribute("title", "회원가입");
		int result=memberService.insertMember(member);
		System.out.println(result+"<-controller insertMember결과값");
		return "redirect:/getMemberList";
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
		int result=memberService.deleteMember(member);
		System.out.println(result+"<-delete 결과값");
		return "redirect:/getMemberList";
	}
	@GetMapping("/forgotPassword")
	public String forgotPassword(Member member) {
		
		return "member/forgetPassword";
	}
	

}
