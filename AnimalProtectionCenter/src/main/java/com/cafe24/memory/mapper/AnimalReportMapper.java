package com.cafe24.memory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.LostReportAnimal;
import com.cafe24.memory.domain.ReportManger;
import com.cafe24.memory.domain.SearchReportAnimal;

@Mapper
public interface AnimalReportMapper {
	public int insertAnimalReport(SearchReportAnimal searchReportAnimal);
	public int insertLostReportAnimal(LostReportAnimal lostReportAnimal);
	public List<ReportManger> selectAllReport();
}
