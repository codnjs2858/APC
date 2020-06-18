package com.cafe24.memory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.Member;
import com.cafe24.memory.mapper.MemberMapper;

@Service
@Transactional
public class MemberService {
	@Autowired private MemberMapper memberMapper;
	
	public int deleteMember(String Mid) {
		return memberMapper.deleteMember(Mid);
	}
	
	public List<Member> getMemberList(){
	
		return memberMapper.getMemberList();
	}
	
	public List<Member> getMemberList(Member member){
		
		return memberMapper.getMemberList(member.getMemberId());
	}
}
