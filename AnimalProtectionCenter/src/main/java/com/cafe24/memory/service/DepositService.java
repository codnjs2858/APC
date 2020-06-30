package com.cafe24.memory.service;

import java.util.List;
import java.util.Map;

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
	
	public int insertDeposit(Deposit deposit) {
		if("".equals(deposit.getDepositDate())){
			deposit.setDepositDate(null);
		}if("".equals(deposit.getDepositReturnDate())) {
			deposit.setDepositReturnDate(null);
		}
		
		return depositMapper.insertDeposit(deposit);
	}
	
	public int updateDeposit(Deposit deposit) {
		if("".equals(deposit.getDepositDate())){
			deposit.setDepositDate(null);
		}if("".equals(deposit.getDepositReturnDate())) {
			deposit.setDepositReturnDate(null);
		}
		
		return depositMapper.updateDeposit(deposit);
	}
	
	public int deleteDeposit(String depositCode) {
		
		return depositMapper.deleteDeposit(depositCode);
	}
	
	public Deposit selectDepositCode(String depositCode) {
		
		return depositMapper.selectDepositCode(depositCode);
	}
	
	public List<Map<String, Object>> selectReviewCount(){
		
		return depositMapper.selectReviewCount();
	}
}
