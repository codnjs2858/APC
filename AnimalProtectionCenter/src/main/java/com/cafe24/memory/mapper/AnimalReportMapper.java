package com.cafe24.memory.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.LostReportAnimal;
import com.cafe24.memory.domain.ReportManger;
import com.cafe24.memory.domain.SearchReportAnimal;

@Mapper
public interface AnimalReportMapper {
	public int insertAnimalReport(SearchReportAnimal searchReportAnimal);
	public List<SearchReportAnimal> selectSearchReportAnimal();
	public List<SearchReportAnimal> selectSearchReportAnimal(SearchReportAnimal searchReportAnimal);
	
	public int insertLostReportAnimal(LostReportAnimal lostReportAnimal);
	public List<LostReportAnimal> selectLostReportAnimal();
	public List<LostReportAnimal> selectLostReportAnimal(LostReportAnimal lostReportAnimal);
	
	public int insertAniSearchReportManager(ReportManger reportManager);
	public int insertAniLostReportManager(ReportManger reportManager);
	/**
	 * 신고취소
	 * @param searchReportAnimal
	 * @return
	 */
	public int searchReportCancel(SearchReportAnimal searchReportAnimal);
	public int lostReportCancel(LostReportAnimal lostReportAnimal);
	
	public List<ReportManger> selectAllReport();
	/** 
	 * 종합관리에서 삭제
	 * @param reportManager
	 * @return
	 */
	public int deletelostReportManger(ReportManger reportManager);
	public int deletesearchReportManger(ReportManger reportManager);
	/**
	 * 신고삭제
	 * @param lostReportAnimal
	 * @return
	 */
	public int deleteLostReportAnimal(LostReportAnimal lostReportAnimal);
	public int deleteSearchReportAnimal(SearchReportAnimal searchReportAnimal);
	
	/**
	 * 신고수정
	 * @param searchReportAnimal
	 * @return
	 */
	public int updateSearchReport(SearchReportAnimal searchReportAnimal);
	public int updateReportManager(ReportManger reportManager);
	
	public int updateLostReportAnimal(LostReportAnimal lostReportAnimal);
	
}
