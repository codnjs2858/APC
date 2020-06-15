package com.cafe24.memory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.Member;
import com.cafe24.memory.domain.ProtectionSpace;

@Mapper
public interface ProtectionMapper {

	List<ProtectionSpace> selectProtectionSpace();
	
}
