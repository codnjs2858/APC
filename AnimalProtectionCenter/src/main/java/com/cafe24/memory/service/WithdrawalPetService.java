package com.cafe24.memory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.WithdrawalPet;
import com.cafe24.memory.mapper.WithdrawalPetMapper;

@Service
@Transactional
public class WithdrawalPetService {
	
	@Autowired
	WithdrawalPetMapper withdrawalPetMapper;
	
	public List<WithdrawalPet> selectWithdrawalPet(){
		
		List<WithdrawalPet> list = withdrawalPetMapper.selectWithdrawalPet();
		
		return list;
	}
	
	public int insertWithdrawalPet(WithdrawalPet withdrawalPet) {
		
		int result = withdrawalPetMapper.insertWithdrawalPet(withdrawalPet);
		
		return result;
	}
		
	public int updateWithdrawalPet(WithdrawalPet withdrawalPet) {
			
			int result = withdrawalPetMapper.updateWithdrawalPet(withdrawalPet);
			
			return result;
	}

	public int deleteWithdrawalPet(String withdrawalPetCode) {
		
		int result = withdrawalPetMapper.deleteWithdrawalPet(withdrawalPetCode);
		
		return result;
	}
	
	public WithdrawalPet selectWithdrawalPetCode(String withdrawalPetCode) {
		
		return withdrawalPetMapper.selectWithdrawalPetCode(withdrawalPetCode);
	}
	
}
