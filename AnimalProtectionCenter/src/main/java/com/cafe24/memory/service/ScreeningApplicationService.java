package com.cafe24.memory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.ScreeningApplication;
import com.cafe24.memory.mapper.ScreeningApplicationMapper;

@Service
@Transactional
public class ScreeningApplicationService {
	
	@Autowired
	private ScreeningApplicationMapper screeningApplicationMapper;
	
	public List<ScreeningApplication> selectScreeningApplication(){
		return screeningApplicationMapper.selectScreeningApplication();
	}
}
