package com.cafe24.memory.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.AnimalCenter;
import com.cafe24.memory.domain.SearchReportAnimal;
import com.cafe24.memory.mapper.AnimalCenterMapper;

@Service
@Transactional
public class AnimalCenterService {
	
	@Autowired
	private AnimalCenterMapper animalCenterMapper;
	
	/**
	 * 보호 동물 센터 등록 - 설채원
	 * @param animal
	 * @return
	 */
	public int insertAnimalCenter(AnimalCenter animal) {
		System.out.println(animal);
		return animalCenterMapper.insertAnimalCenter(animal);
	}
	
	/**
	 * 센터 등록 동물 조회 - 설채원
	 * @return
	 */
	public List<AnimalCenter> selectAnimalCenter(){
		return animalCenterMapper.selectAnimalCenter();
	}
	
	/**
	 * 센터 등록 동물 타입별 조회 - 설채원
	 * @param send_type
	 * @return
	 */
	public List<AnimalCenter> selectAnimalCenter(String send_type){
		return animalCenterMapper.selectAnimalCenter(send_type);
	}

	/**
	 * 센터 등록 동물 선택 조회 - 설채원
	 * @param send_code
	 * @return
	 */
	public AnimalCenter selectCenterAnimal(String send_code){
		return animalCenterMapper.selectCenterAnimal(send_code);
	}
	
	/**
	 * 센터 등록 동물 타입별 개체 수 조회 - 설채원
	 * @return
	 */
	public List<Map<String,Object>> selectCenterCnt(){
		return animalCenterMapper.selectCenterCnt();
	}
	
	/**
	 * 이름, 연락처로 신고 내역 조회 - 설채원
	 * @param memberName
	 * @param memberPhone
	 * @return
	 */
	public ArrayList<SearchReportAnimal> selectCenterReport(String memberName,String memberPhone){
		return animalCenterMapper.selectCenterReport(memberName, memberPhone);
	}
}
