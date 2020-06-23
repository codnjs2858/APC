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
	 * 건강 내역 삭제-> 건강 기록으로 update
	 * @param sed_code
	 * @return
	 */
	public int deleteAnimalHealthHistory(String send_code) {
		return animalHealthMapper.deleteAnimalHealthHistory(send_code);
	}
	
	/**
	 * 건강 기록+내역 개체별 검색 - 설채원
	 * @param send_code
	 * @return
	 */
	public List<AnimalHealth> selectAnimalHealthInfo(String send_code){
		return animalHealthMapper.selectAnimalHealthInfo(send_code);
	}
	
	/**
	 * 건강 기록 수정 - 설채원
	 * @param aheal
	 * @return
	 */
	public int updateAnimalHealth(AnimalHealth aheal) {
		return animalHealthMapper.updateAnimalHealth(aheal);
	}
	
	/**
	 * 동물 건강 코드로 기록 하나 검색 - 설채원
	 * @param send_code
	 * @return
	 */
	public AnimalHealth searchHealthCode(String send_code) {
		return animalHealthMapper.searchHealthCode(send_code);
	}
	/**
	 * 동물 건강 기록 삭제 - 설채원
	 * @param send_code
	 * @return
	 */
	public int deleteAnimalHealth(String send_code) {
		return animalHealthMapper.deleteAnimalHealth(send_code);
	}
	
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
