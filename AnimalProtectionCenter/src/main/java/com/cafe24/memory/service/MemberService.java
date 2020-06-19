package com.cafe24.memory.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.Member;
import com.cafe24.memory.mapper.MemberMapper;

@Service
@Transactional
public class MemberService {
	@Autowired private MemberMapper memberMapper;

	
	public List<Member> getMemberList(){
	
		return memberMapper.getMemberList();
	}
	
	public List<Member> getMemberList(Member member){
		
		return memberMapper.getMemberList(member.getMemberId());
	}
	public int insertMember(Member m) {
		
		int result=memberMapper.insertMember(m);
		System.out.println(result+"<-Service insertMember결과값");
		return result;
	}
	public int deleteMember(Member m) {
		int result=memberMapper.deleteMember(m);
		return result;
	}

}
