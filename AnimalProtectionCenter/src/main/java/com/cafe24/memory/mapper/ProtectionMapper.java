package com.cafe24.memory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.AnimalCenter;
import com.cafe24.memory.domain.AnimalProtect;
import com.cafe24.memory.domain.Implement;
import com.cafe24.memory.domain.ProtectionSpace;

@Mapper
public interface ProtectionMapper {

	/**
	 * 보호공간 삭제
	 * @param protectionSpaceCode
	 * @return
	 */
	int deleteProtectionSpace(String protectionSpaceCode);
	
	/**
	 * 보호공간 등록 - 손충기
	 * @param implement
	 * @return
	 */
	int insertProtectionSpace(ProtectionSpace protectionSpace);
	
	/**
	 * 보호공간에서 보호공간코드로 찾음 - 손충기
	 * @param proSpaceCode
	 * @return
	 */
	ProtectionSpace selectProtectionSpaceByCode(String proSpaceCode);
		
	/**
	 * 보호관리 번호로 보호관리동물을 찾음 - 손충기
	 * @param animalNum
	 * @return
	 */
	AnimalProtect selectAnimalProtect(String animalNum);
	
	/**
	 * 보호관리에서 미보호인 상태를 찾음 - 손충기
	 * @param animalNum
	 * @return
	 */
	List<AnimalProtect> selectAnimalNotProtect(String animalNum);
	
	/**
	 * 모든 보호공간을 찾음 - 손충기
	 * @return
	 */
	List<ProtectionSpace> selectProtectionSpace();
	
	/**
	 * 보호공간안에서 센터등록코드로 동물을 찾음 - 손충기
	 * @param aniInsertCode
	 * @return
	 */
	List<ProtectionSpace> selectProtectionSpaceByAniInCode(String aniInsertCode);
	
	/**
	 * 보호공간 안에 있는 동물들을 찾음 - 손충기
	 * @return
	 */
	List<ProtectionSpace> selectProtectionSpaceInAnimal();
	
	/**
	 * 보호공간에 없는 센터등록된 동물들을 찾음 - 손충기
	 * @return
	 */
	List<ProtectionSpace> selectProtectionSpaceOutAnimal();
	
	/**
	 * 보호공간을 상태현황으로 찾음(없음, 사용중) - 손충기
	 * @param state
	 * @return
	 */
	List<ProtectionSpace> selectProtectionSpaceUseState(String state);
	
	/**
	 * 보호공간을 갖고 있지 않은 동물들 찾음 - 손충기
	 * @return
	 */
	List<AnimalCenter> selectAnimalHaveNotSpace();
	
	/**
	 * 보호공간에 등록 - 손충기
	 * @param animalProtect
	 * @return
	 */
	int updateAnimalProtectionInSpace(AnimalProtect animalProtect);
	
	/**
	 * 보호공간에서 미보호로 바꿈 - 손충기
	 * @param proSpaceCode
	 * @return
	 */
	int updateAnimalProtectionExitSpace(String proSpaceCode);
	
	/**
	 * 보호공간 등록 - 손충기
	 * @param animalProtect
	 * @return
	 */
	int insertAniamlProtection(AnimalProtect animalProtect);
	
	/**
	 * 보관관리에서 미보호로 변환 - 손충기
	 * @param animalProtectionNum
	 * @return
	 */
	int updateAnimalProtectionExit(String animalProtectionNum);
}
