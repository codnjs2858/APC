package com.cafe24.memory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.ScreeningComplete;
import com.cafe24.memory.mapper.ScreeningCompleteMapper;

@Service
@Transactional
public class ScreeningCompleteService {
	
	@Autowired
	private ScreeningCompleteMapper screeningCompleteMapper;
	
	public List<ScreeningComplete> selectScreeningComplete(){
		return screeningCompleteMapper.selectScreeningComplete();
	}
}
