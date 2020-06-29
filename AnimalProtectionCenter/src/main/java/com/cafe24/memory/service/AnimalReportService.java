package com.cafe24.memory.service;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.SearchReportAnimal;
import com.cafe24.memory.mapper.AnimalReportMapper;

@Service
@Transactional
public class AnimalReportService {
	@Autowired 
	private AnimalReportMapper animalReportMapper;
	
	public int insertAnimalReport(SearchReportAnimal searchReportAnimal) {
			return animalReportMapper.insertAnimalReport(searchReportAnimal);
	}
}
