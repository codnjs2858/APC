package com.cafe24.memory.service;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.AnimalCenter;
import com.cafe24.memory.mapper.AnimalCenterMapper;

@Service
@Transactional
public class AnimalCenterService {
	
	@Autowired
	private AnimalCenterMapper animalCenterMapper;
	
	public List<AnimalCenter> selectAnimalCenter(){
		return animalCenterMapper.selectAnimalCenter();
	}
	public List<AnimalCenter> selectAnimalCenter(String send_type){
		return animalCenterMapper.selectAnimalCenter(send_type);
	}
	public List<Map<String,Object>> selectCenterCnt(){
		return animalCenterMapper.selectCenterCnt();
	}
	
}
