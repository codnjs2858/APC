package com.cafe24.memory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.BlackList;
import com.cafe24.memory.mapper.BlackListMapper;

@Service
@Transactional
public class BlackListService {
	
	@Autowired
	BlackListMapper blackListMapper;
	
	public List<BlackList> selectBlackList(){
		
		List<BlackList> list = blackListMapper.selectBlackList();
		
		return list;
		
	}
}
