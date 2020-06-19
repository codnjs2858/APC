package com.cafe24.memory.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.AnimalType;
import com.cafe24.memory.mapper.AnimalTypeMapper;

@Service
@Transactional
public class AnimalTypeService {
	
	@Autowired private AnimalTypeMapper animalTypeMapper;
	
	/**
	 * 축종별 개체수 조회
	 * @return
	 */
	public List<Map<String,Object>> selectAnimalCnt(){
		return animalTypeMapper.selectAnimalCnt();
	}
	
	/**
	 * 동물 종류 삭제
	 * @param send_code
	 * @return
	 */
	public int deleteAnimalType(String send_code) {
		return animalTypeMapper.deleteAnimalType(send_code);
	}
	
	/**
	 * 동물 종류 수정
	 * @param atype
	 * @return
	 */
	public int updateAnimalType(AnimalType atype) {
		return animalTypeMapper.updateAnimalType(atype);
	}
	
	public AnimalType selectType(String send_code){
		return animalTypeMapper.selectType(send_code);
	}
	//
	public List<AnimalType> selectAnimalType(){
		return animalTypeMapper.selectAnimalType();
	}
	public List<AnimalType> selectAnimalType(String send_type){
		return animalTypeMapper.selectAnimalType(send_type);
	}
	//
	public int insertAnimalType(AnimalType atype) {
		return animalTypeMapper.insertAnimalType(atype);
	}
	
	
}
