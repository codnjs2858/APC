package com.cafe24.memory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.AnimalProtect;
import com.cafe24.memory.domain.ProtectionSpace;

@Mapper
public interface ProtectionMapper {

	ProtectionSpace selectProtectionSpaceByCode(String proSpaceCode);
	
	List<ProtectionSpace> selectProtectionSpaceByAniInCode(String aniInsertCode);
	
	AnimalProtect selectAnimalProtect(String animalNum);
	
	List<ProtectionSpace> selectProtectionSpace();
	
	int updateAnimalProtectionIn(AnimalProtect animalProtect);
	
	int updateAnimalProtectionExit(String proSpaceCode);
	
	int insertAniamlProtection(AnimalProtect animalProtect);
}
