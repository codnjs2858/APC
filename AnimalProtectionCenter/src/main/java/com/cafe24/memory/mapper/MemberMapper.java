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
	

}
