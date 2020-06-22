package com.cafe24.memory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.AnimalHealth;
import com.cafe24.memory.mapper.AnimalHealthMapper;

@Service
@Transactional
public class AnimalHealthService {

	@Autowired  AnimalHealthMapper animalHealthMapper;
	
	/**
	 * 건강 기록 등록(치료 전) - 설채원
	 * @param aheal
	 * @return
	 */
	public int insertAnimalHealth(AnimalHealth aheal) {
		return animalHealthMapper.insertAnimalHealth(aheal);
	}
	
	/**
	 * 건강 기록(치료 완료 동물) 리스트 - 설채원
	 * @return
	 */
	public List<AnimalHealth> selectAnimalHealthed(){
		return animalHealthMapper.selectAnimalHealthed();
	}
	
	/**
	 * 건강 기록(치료 미완료 동물) 리스트 - 설채원
	 * @return
	 */
	public List<AnimalHealth> selectAnimalHealth(){
		return animalHealthMapper.selectAnimalHealth();
	}
}
