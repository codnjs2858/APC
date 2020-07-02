package com.cafe24.memory.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.cafe24.memory.domain.CompanionAnimalRegister;

@Mapper
public interface CompanionAnimalRegisterMapper {
	
	public List<CompanionAnimalRegister> selectCompanionAnimalRegisterList();
	
	public List<String> selectMemberAll();
	
	public int insertCompanionAnimalRegister(CompanionAnimalRegister cAniReg);
	
	public int updateCompanionAnimalRegister(CompanionAnimalRegister cAniReg);
	
	public CompanionAnimalRegister selectCompanionAnimalRegister(String companionAnimalRegisterCode);
	
	public int deleteCompanionAnimalRegister(String companionAnimalRegisterCode);
	
	public List<Map<String, Object>> selectComAniRegCount();
	
	public List<CompanionAnimalRegister> selectComAniRegList(String CARL);
}
