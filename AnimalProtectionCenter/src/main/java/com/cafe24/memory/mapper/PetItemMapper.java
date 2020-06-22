package com.cafe24.memory.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.PetFood;

@Mapper
public interface PetItemMapper {
	
	int deletePetFood(String petFoodCode);
	
	/**
	 * 사료종류로 사료리스트찾음
	 * @return
	 */
	List<PetFood> selectPetFoodByFoodType(String foodType);
	
	/**
	 * 사료 종류별로 숫자 찾음
	 * @return
	 */
	List<Map<String, Object>> selectPetFoodTypeCount();
	
	/**
	 * 펫사료 등록
	 * @return
	 */
	int insertPetFood(PetFood petFood);
	
	/**
	 * 펫사료 수정처리
	 * @param petFood
	 * @return
	 */
	int updatePetFood(PetFood petFood);
	
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
