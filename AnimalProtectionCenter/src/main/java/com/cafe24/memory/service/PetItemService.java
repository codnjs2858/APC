package com.cafe24.memory.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.AnimalCenter;
import com.cafe24.memory.domain.Implement;
import com.cafe24.memory.domain.PetFood;
import com.cafe24.memory.domain.PetGoods;
import com.cafe24.memory.mapper.AnimalCenterMapper;
import com.cafe24.memory.mapper.ImplementMapper;
import com.cafe24.memory.mapper.PetItemMapper;

@Service
@Transactional
public class PetItemService {
	
	@Autowired
	private PetItemMapper petItemMapper;
	
	@Autowired
	private ImplementMapper implementMapper;
	
	@Autowired
	private AnimalCenterMapper animalCenterMapper;
	
	public int insertPetGoods(PetGoods petGoods) {
		return petItemMapper.insertPetGoods(petGoods);
	}
	
	public List<Map<String, Object>> searchImplementNAnimalInsertByPetGoods(){
		List<Map<String, Object>> lso = new ArrayList<Map<String,Object>>();
		List<PetGoods> goodsList = selectPetGoods();
		
		for(int i = 0; i < goodsList.size(); i++) {
			Implement implement = implementMapper.selectImplementByCode(goodsList.get(i).getImplementCode());
			AnimalCenter animalCenter = animalCenterMapper.selectCenterAnimal(goodsList.get(i).getAnimalInsertCode());
			
			Map<String, Object> so = new HashMap<String, Object>();
			
			so.put("implement", implement);
			so.put("animalCenter", animalCenter);
			
			lso.add(so);			
		}
		
		return lso;
	}
	
	public List<PetGoods> selectPetGoods(){
		return petItemMapper.selectPetGoods();
	}
	
	public int deletePetFood(String petFoodCode) {
		return petItemMapper.deletePetFood(petFoodCode);
	}
	
	/**
	 * 사료종류로 리스트 검색 - 손충기
	 * @param foodType
	 * @return
	 */
	public List<PetFood> selectPetFoodByFoodType(String foodType){
		return petItemMapper.selectPetFoodByFoodType(foodType);
	}
	
	/**
	 * 사료종류별로 등록개수찾기 - 손충기
	 * @return
	 */
	public List<Map<String, Object>> selectPetFoodTypeCount(){
		return petItemMapper.selectPetFoodTypeCount();
	}
	
	/**
	 * 펫사료 등록 처리 - 손충기
	 * @param petFood
	 * @return
	 */
	public int insertPetFood(PetFood petFood) {
		return petItemMapper.insertPetFood(petFood);
	}
	
	/**
	 * 펫사료 수정 처리 - 손충기
	 * @param petFood
	 * @return
	 */
	public int updatePetFood(PetFood petFood) {
		return petItemMapper.updatePetFood(petFood);
	}
	
	/**
	 * 모든 사료 리스트 - 손충기
	 * @param petFoodCode
	 * @return
	 */
	public List<PetFood> selectPetFood(){
		return petItemMapper.selectPetFood();
	}
	
	/**
	 * 펫사료 코드로 사료 찾기 - 손충기
	 * @param petFoodCode
	 * @return
	 */
	public PetFood selectPetFoodByPetFoodCode(String petFoodCode) {
		return petItemMapper.selectPetFoodByPetFoodCode(petFoodCode);
	}
	
}
