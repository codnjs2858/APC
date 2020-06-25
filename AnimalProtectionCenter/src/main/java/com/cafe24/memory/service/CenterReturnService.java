package com.cafe24.memory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.CenterReturn;
import com.cafe24.memory.mapper.CenterReturnMapper;


@Service
@Transactional
public class CenterReturnService {
	
	@Autowired CenterReturnMapper centerReturnMapper;
	
	public List<CenterReturn> selectCenterReturn(){
		
		List<CenterReturn> list = centerReturnMapper.selectCenterReturn();
		
		return list;
	}
	
	public int insertCenterReturn(CenterReturn centerReturn) {
		
		return centerReturnMapper.insertCenterReturn(centerReturn);
	}
	
	public int updateCenterReturn(CenterReturn centerReturn) {
		
		return centerReturnMapper.updateCenterReturn(centerReturn);
	}
	
	public int deleteCenterReturn(String centerReturnCode) {
		
		return centerReturnMapper.deleteCenterReturn(centerReturnCode);
	}
	
	public CenterReturn selectCenterReturnCode(String centerReturnCode) {
		
		return centerReturnMapper.selectCenterReturnCode(centerReturnCode);
	}
}
