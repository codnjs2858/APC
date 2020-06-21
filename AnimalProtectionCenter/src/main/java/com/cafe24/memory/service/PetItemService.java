package com.cafe24.memory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.PetFood;
import com.cafe24.memory.mapper.PetItemMapper;

@Service
@Transactional
public class PetItemService {
	
	@Autowired
	private PetItemMapper petItemMapper;
	
	/**
	 * 펫사료 등록 처리
	 * @param petFood
	 * @return
	 */
	public int insertPetFood(PetFood petFood) {
		return petItemMapper.insertPetFood(petFood);
	}
	
	/**
	 * 펫사료 수정 처리
	 * @param petFood
	 * @return
	 */
	public int updatePetFood(PetFood petFood) {
		return petItemMapper.updatePetFood(petFood);
	}
	
	/**
	 * 모든 사료 리스트
	 * @param petFoodCode
	 * @return
	 */
	public List<PetFood> selectPetFood(){
		return petItemMapper.selectPetFood();
	}
	
	/**
	 * 펫사료 코드로 사료 찾기
	 * @param petFoodCode
	 * @return
	 */
	public PetFood selectPetFoodByPetFoodCode(String petFoodCode) {
		return petItemMapper.selectPetFoodByPetFoodCode(petFoodCode);
	}
	
}
