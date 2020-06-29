package com.cafe24.memory.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.Deposit;

@Mapper
public interface DepositMapper {
	
	public List<Deposit> selectDeposit();
	
	public int insertDeposit(Deposit deposit);
	
	public int updateDeposit(Deposit deposit);
	
	public int deleteDeposit(String depositCode);
	
	public Deposit selectDepositCode(String depositCode);
	
	public List<Map<String, Object>> selectReviewCount();
	
}
