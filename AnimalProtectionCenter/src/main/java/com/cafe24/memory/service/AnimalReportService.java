package com.cafe24.memory.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.LostReportAnimal;
import com.cafe24.memory.domain.ReportManger;
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
	public int insertLostAnimalReport(LostReportAnimal lostReportAnimal) {
		return animalReportMapper.insertLostReportAnimal(lostReportAnimal);
	}
	public List<ReportManger> selectAllReport(){
		
		return animalReportMapper.selectAllReport();
	}
	public int insertAniSearchReportManager(ReportManger reportManger) {
		
		return animalReportMapper.insertAniSearchReportManager(reportManger);
	}
	public int insertAniLostReportManager(ReportManger reportManger) {
		return animalReportMapper.insertAniLostReportManager(reportManger);
	}
}
