package com.cafe24.memory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.CenterReturn;

@Mapper
public interface CenterReturnMapper {
	
	public List<CenterReturn> selectCenterReturn();
}
