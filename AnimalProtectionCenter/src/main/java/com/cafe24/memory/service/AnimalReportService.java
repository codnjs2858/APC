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
	public List<SearchReportAnimal> selectSearchReportAnimal(SearchReportAnimal searchReportAnimal){
		return animalReportMapper.selectSearchReportAnimal(searchReportAnimal);
	}
	public List<SearchReportAnimal> selectSearchReportAnimal(){
		return animalReportMapper.selectSearchReportAnimal();
	}
	public List<LostReportAnimal> selectLostReportAnimal(LostReportAnimal lostReportAnimal){
		return animalReportMapper.selectLostReportAnimal(lostReportAnimal);
	}
	public List<LostReportAnimal> selectLostReportAnimal(){
		return animalReportMapper.selectLostReportAnimal();
	}
	/**
	 * 종합관리(reportManager)에서 삭제
	 */

	public int deleteReportManager(ReportManger reportManger) {
	  
		return animalReportMapper.deleteReportManger(reportManger); 
	}
	/**
	 * 유기신고에서 삭제
	 * @param lostReportAnimal
	 * @return
	 */
	public int deleteLostReportAnimal(LostReportAnimal lostReportAnimal) {
		return animalReportMapper.deleteLostReportAnimal(lostReportAnimal);
	  
	}
	/**
	 * 분실신고에서 삭제
	 * @param searchReportAnimal
	 * @return
	 */
	public int deleteSearchReportAnimal(SearchReportAnimal searchReportAnimal) {
		return animalReportMapper.deleteSearchReportAnimal(searchReportAnimal);
	  
	}  
	
	/**
	 * 신고취소버튼 클릭시 신고 취소한 오늘날짜 로 db에 업데이트
	 * @param searchReportAnimal
	 * @return
	 */
	public int searchReportCancel(SearchReportAnimal searchReportAnimal) {
		return animalReportMapper.searchReportCancel(searchReportAnimal);
	}
	/**
	 * searchReport신고 update
	 * @param searchReportAnimal
	 * @return
	 */
	public int updateSearchReport(SearchReportAnimal searchReportAnimal) {
		return animalReportMapper.updateSearchReport(searchReportAnimal);
	}
	public int updateReportManager(ReportManger reportManager) {
		return animalReportMapper.updateReportManager(reportManager);
		}
}
