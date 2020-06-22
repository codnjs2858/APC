package com.cafe24.memory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.AnimalHealth;

@Mapper
public interface AnimalHealthMapper {

	/**
	 * 건강 기록 등록(치료 전) - 설채원
	 * @param aheal
	 * @return
	 */
	public int insertAnimalHealth(AnimalHealth aheal);
	
	/**
	 * 건강 기록(치료 미완료 동물) 리스트 - 설채원
	 * @return
	 */
	public List<AnimalHealth> selectAnimalHealth();
	
	/**
	 * 건강 기록(치료 완료 동물) 리스트 - 설채원
	 * @return
	 */
	public List<AnimalHealth> selectAnimalHealthed();
}

