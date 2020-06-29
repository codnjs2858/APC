package com.cafe24.memory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.memory.domain.Member;
import com.cafe24.memory.service.MemberService;

@RestController
@RequestMapping("/ajax")
public class AjaxLKJController {
	@Autowired private MemberService memberService;
	
	/**
	 * 회원가입시 기존 아이디 존재하는지 중복확인-이경진
	 * @param model
	 * @return
	 */
	@RequestMapping("/Addmember")
	public String ajaxAddmember(@RequestParam(value = "id") String id) {
		System.out.println(id);
		Member mList=memberService.getMemberList(id);
		String result="";
		if(mList != null && !"".equals(mList.getMemberId())){
			result="N";
		}
		return result;
	}

}
