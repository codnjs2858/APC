package com.cafe24.memory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.Deposit;
import com.cafe24.memory.mapper.DepositMapper;

@Service
@Transactional
public class DepositService {
	
	@Autowired 
	DepositMapper depositMapper;
	
	public List<Deposit> selectDeposit(){
		
		List<Deposit> list = depositMapper.selectDeposit();
		
		return list;
		
	}
}
