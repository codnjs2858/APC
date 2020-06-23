package com.cafe24.memory.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.memory.domain.Level;
import com.cafe24.memory.domain.Member;
import com.cafe24.memory.service.MemberService;
import com.cafe24.memory.service.StaffService;

@Controller
public class MemberController {
	@Autowired private MemberService memberService;
	@Autowired private StaffService staffService;
	@GetMapping("/login")
	public String login() {
	
		
		return "member/login";
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest request,Member member) {
		
			HttpSession session=request.getSession();
			
			if((member.getMemberId())!=null&&!"".equals(member.getMemberId())&&(member.getMemberPw())!=null&&!"".equals(member.getMemberPw())) {
				List<Member> result=memberService.getMemberList(member);
				Member getMember=result.get(0);
				if((getMember.getMemberPw()).equals(member.getMemberPw())) {
					session.setAttribute("SID", getMember.getMemberId());
					session.setAttribute("SNAME", getMember.getMemberName());
					session.setAttribute("SEMAIL", getMember.getMemberEmail());
					session.setAttribute("SLEVEL", getMember.getLevel().getLevelCode());
				}if(getMember.getLevel().getLevelCode().equals("level_code_02")||getMember.getLevel().getLevelCode().equals("level_code_01")) {
					session.setAttribute("STAFFCODE",staffService.selectStaffMember(member.getMemberId()).getStaffCode());
					session.setAttribute("STAFF",staffService.selectStaffMember(member.getMemberId()));
					
				}
				
			}
			return "redirect:/";
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
	
	/**
	 * 회원가입시 기존 아이디 존재하는지 중복확인-이경진
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ajax/Addmember", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String ajaxAddmember(@RequestParam(value = "id") String id) {
		System.out.println(id);
		Member member= new Member();
		member.setMemberId(id);
		List<Member>mList=memberService.getMemberList(member);
		String result="";
		if(mList != null && !"".equals(mList.get(0).getMemberId())){
			result="이미 존재하는 아이디 입니다";
		}
		return result;
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
	public String memberUpdate(Member member,Level level) {
		member.setLevel(level);
		System.out.println(member+"<-회원update");
		int result=memberService.updateMember(member);
		System.out.println(result+"<-회원update 결과값");
		return "index";
	}
	
	@GetMapping("/memberDelete")
	public String memberDelete(Member member) {
		
		try {
			int result=memberService.deleteMember(member);
			System.out.println(result+"<-delete 결과값");
		
		} catch (Exception e) {
			System.out.println("회원삭제 실패");
		}
		return "redirect:/animalcenterlist";
	}
	@GetMapping("/forgotPassword")
	public String forgotPassword(Member member) {
		
		return "member/forgetPassword";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	@PostMapping(value="/indexlogin", produces="application/json")
	@ResponseBody
	public HashMap<String,String> indexlogin() {
		HashMap<String,String>result=new HashMap();
		List<Member>mList=memberService.getMemberList();
		for(int i=0;i<mList.size();i++) {
			if(("level_code_01".equals(mList.get(i).getLevel().getLevelCode()))||("level_code_02".equals(mList.get(i).getLevel().getLevelCode()))) {
				result.put("관리자레벨", mList.get(i).getLevel().getLevelCode());
				result.put("관리자아이디", mList.get(i).getMemberId());
				result.put("관리자비밀번호",mList.get(i).getMemberPw());
				
			}if("level_code_03".equals(mList.get(i).getLevel().getLevelCode())) {
				result.put("회원레벨", mList.get(i).getLevel().getLevelCode());
				result.put("회원아이디", mList.get(i).getMemberId());
				result.put("회원비밀번호",mList.get(i).getMemberPw());
			}
			
			
		}
		return result;
	}
}
