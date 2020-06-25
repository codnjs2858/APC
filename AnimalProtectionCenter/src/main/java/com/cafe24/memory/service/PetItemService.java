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
import com.cafe24.memory.mapper.StaffMapper;

@Service
@Transactional
public class PetItemService {
	
	@Autowired
	private PetItemMapper petItemMapper;
	
	@Autowired
	private ImplementMapper implementMapper;
	
	@Autowired
	private AnimalCenterMapper animalCenterMapper;
	
	@Autowired
	private StaffMapper staffMapper;
	
	/**
	 * 펫용품 삭제 - 손충기
	 * @param petGoodsCode
	 * @return
	 */
	public int deletePetGoods(String petGoodsCode) {
		return petItemMapper.deletePetGoods(petGoodsCode);
	}
	
	/**
	 * 펫용품을 시설코드로 찾음 - 손충기
	 * @param implementCode
	 * @return
	 */
	public List<PetGoods> selectGoodsByImplementCode(String implementCode){
		return petItemMapper.selectGoodsByImplementCode(implementCode);
	}
	
	/**
	 * 펫용품 등록 - 손충기
	 * @param petGoods
	 * @return
	 */
	public int insertPetGoods(PetGoods petGoods) {
		return petItemMapper.insertPetGoods(petGoods);
	}
	
	/**
	 * 시설종류가 등록된 코드와 갯수 찾음 - 손충기
	 * @return
	 */
	public List<Map<String, Object>> selectImplementTypeNCodeNCnt(){
		return petItemMapper.selectImplementTypeNCodeNCnt();
	}
	
	/**
	 * 펫용품 찾을 시 시설, 센터등록동물을 펫용품에 등록된 코드값들로 찾음 - 손충기
	 * @param sendCode
	 * @return
	 */
	public List<Map<String, Object>> searchImplementNAnimalInsertByPetGoods(String sendCode){
		List<Map<String, Object>> lso = new ArrayList<Map<String,Object>>();
		List<PetGoods> goodsList = null;
		PetGoods goods = null;
		System.out.println(sendCode);
		if(sendCode != null && !"".equals(sendCode)) {
			goodsList = selectGoodsByImplementCode(sendCode);
			System.out.println(goodsList + " <-- if goodsList searchImplementNAnimalInsertByPetGoods()");
		}else {
			goodsList = selectPetGoods();
		}
		
		System.out.println(goodsList + " <-- goodsList searchImplementNAnimalInsertByPetGoods()");
		
		if(goodsList != null) {
			for(int i = 0; i < goodsList.size(); i++) {
				goods = goodsList.get(i);
				Implement implement = implementMapper.selectImplementByCode(goods.getImplementCode());
				AnimalCenter animalCenter = animalCenterMapper.selectCenterAnimal(goods.getAnimalInsertCode());
				
				Map<String, Object> so = new HashMap<String, Object>();
				so.put("goods", goods);
				so.put("implement", implement);
				so.put("animalCenter", animalCenter);
				
				lso.add(so);			
			}			
		}
		
		return lso;
	}
	
	/**
	 * 펫용품 리스트 - 손충기
	 * @return
	 */
	public List<PetGoods> selectPetGoods(){
		return petItemMapper.selectPetGoods();
	}
	
	/**
	 * 펫사료 삭제 - 손충기
	 * @param petFoodCode
	 * @return
	 */
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
