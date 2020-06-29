package com.cafe24.memory.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.SearchReportAnimal;

@Mapper
public interface AnimalReportMapper {
	public int insertAnimalReport(SearchReportAnimal searchReportAnimal);
	
}
