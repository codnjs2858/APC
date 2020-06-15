package com.cafe24.memory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.Member;

@Mapper
public interface MemberMapper {
	public int deleteMember(String Mid);
	
	public List<Member> getMemberList();
}
