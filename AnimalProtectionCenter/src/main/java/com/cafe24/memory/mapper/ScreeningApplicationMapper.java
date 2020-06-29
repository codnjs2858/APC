package com.cafe24.memory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.ScreeningApplication;

@Mapper
public interface ScreeningApplicationMapper {
	public List<ScreeningApplication> selectScreeningApplication();
	public List<ScreeningApplication> selectScreeningApplication(ScreeningApplication screening_application_code);
	public int updateScreeningApplication(ScreeningApplication screeningApplication);
}
