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
	
	@Autowired
	private AnimalTypeMapper animalTypeMapper;
	
	public List<Map<String,Object>> selectAnimalCnt(){
		return animalTypeMapper.selectAnimalCnt();
	}
	
	public int deleteAnimalType(String send_code) {
		return animalTypeMapper.deleteAnimalType(send_code);
	}
	
	public int updateAnimalType(AnimalType atype) {
		return animalTypeMapper.updateAnimalType(atype);
	}
	
	public AnimalType selectType(String send_code){
		return animalTypeMapper.selectType(send_code);
	}
	
	public List<AnimalType> selectAnimalType(){
		return animalTypeMapper.selectAnimalType();
	}
	
	public List<AnimalType> selectTypeList(String send_type){
		return animalTypeMapper.selectTypeList(send_type);
	}
	
	public int insertAnimalType(AnimalType atype) {
		return animalTypeMapper.insertAnimalType(atype);
	}
	
	
}
