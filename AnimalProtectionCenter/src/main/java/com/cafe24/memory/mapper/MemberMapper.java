package com.cafe24.memory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.Member;

@Mapper
public interface MemberMapper {
	
	public int deleteMember(String Mid);
	public Member getMemberList(String mId);
	public List<Member> getMemberList();
	public int insertMember(Member M);
	public int deleteMember(Member M);
	public int updateMember(Member M);
	public Member findId(Member member);	//아이디 찾기
	public Member findPw(Member member);	//비밀번호 찾기

}
