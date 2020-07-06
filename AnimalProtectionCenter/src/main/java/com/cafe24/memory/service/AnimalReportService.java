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
	/**
	 * 유기동물신고(searchReport) insert
	 * @param searchReportAnimal
	 * @return
	 */
	public int insertAnimalReport(SearchReportAnimal searchReportAnimal) {
			return animalReportMapper.insertAnimalReport(searchReportAnimal);
	}
	/**
	 * 분실신고(lostReport) insert
	 * @param lostReportAnimal
	 * @return
	 */
	public int insertLostAnimalReport(LostReportAnimal lostReportAnimal) {
		return animalReportMapper.insertLostReportAnimal(lostReportAnimal);
	}
	/**
	 * 종합관리(reportManager)리스트를 가져오는 메서드
	 * @return
	 */
	public List<ReportManger> selectAllReport(){
		
		return animalReportMapper.selectAllReport();
	}
	/**
	 * 유기동물신고(searchReport)시에  종합관리(reportManager)에 자동으로 입력하는 메서드
	 * @param reportManger
	 * @return
	 */
	public int insertAniSearchReportManager(ReportManger reportManger) {
		
		return animalReportMapper.insertAniSearchReportManager(reportManger);
	}
	/**
	 * 분실신고(lostReport)시에 종합관리(reportManager)에 자동으로 입력하는 메서드
	 * @param reportManger
	 * @return
	 */
	public int insertAniLostReportManager(ReportManger reportManger) {
		return animalReportMapper.insertAniLostReportManager(reportManger);
	}
	/**
	 * 유기동물신고(searchReport) 리스트 select
	 * @return List<SearchReportAnimal>
	 */
	public List<SearchReportAnimal> selectSearchReportAnimal(){
		return animalReportMapper.selectSearchReportAnimal();
	}
	public List<LostReportAnimal> selectLostReportAnimal(){
		return animalReportMapper.selectLostReportAnimal();
	}
}
