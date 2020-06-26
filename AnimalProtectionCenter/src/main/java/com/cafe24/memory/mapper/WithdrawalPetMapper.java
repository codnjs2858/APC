package com.cafe24.memory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.WithdrawalPet;

@Mapper
public interface WithdrawalPetMapper {
	
	public List<WithdrawalPet> selectWithdrawalPet();
	
	public int insertWithdrawalPet(WithdrawalPet withdrawalPet);
	
	public int updateWithdrawalPet(WithdrawalPet withdrawalPet);
	
	public int deleteWithdrawalPet(String withdrawalPetCode);
	
	public WithdrawalPet selectWithdrawalPetCode(String withdrawalPetCode);
}
