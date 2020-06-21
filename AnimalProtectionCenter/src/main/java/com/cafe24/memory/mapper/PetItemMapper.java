package com.cafe24.memory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.PetFood;

@Mapper
public interface PetItemMapper {
	
	/**
	 * 모든 사료 리스트
	 * @return
	 */
	List<PetFood> selectPetFood();
	
	/**
	 * 펫사료코드로 사료 찾음
	 * @return
	 */
	PetFood selectPetFoodByPetFoodCode(String petFoodCode);
	
}
