package com.cafe24.memory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.CompanionAnimalRegister;

@Mapper
public interface CompanionAnimalRegisterMapper {
	
	public List<CompanionAnimalRegister> selectCompanionAnimalRegisterList();
	
	public List<String> selectMemberAll();
	
	public int insertCompanionAnimalRegister(CompanionAnimalRegister cAniReg);
	
	public int updateCompanionAnimalRegister();
}
