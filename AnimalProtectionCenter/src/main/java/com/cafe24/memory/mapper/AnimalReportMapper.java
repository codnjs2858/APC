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
	
	public int insertLostReportAnimal(LostReportAnimal lostReportAnimal);
	public List<LostReportAnimal> selectLostReportAnimal();
	
	public int insertAniSearchReportManager(ReportManger reportManager);
	public int insertAniLostReportManager(ReportManger reportManager);
	
	public List<ReportManger> selectAllReport();
	public List<Map<String,Object>> selectReportCnt();
}
