package com.cafe24.memory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.AnimalDisposal;

@Mapper
public interface AnimalDisposalMapper {
	public List<AnimalDisposal> selectResultTest();
	public AnimalDisposal selectResultTest(String send_code);
}
