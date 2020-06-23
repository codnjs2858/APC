package com.cafe24.memory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.AnimalHealth;

@Mapper
public interface AnimalHealthMapper {

	/**
	 * 건강 기록 삭제
	 * @param send_code
	 * @return
	 */
	public int deleteAnimalHealthHistory(String send_code);
	
	/**
	 * 개체별 건강 기록+내역 검색 - 설채원
	 * @param send_code
	 * @return
	 */
	public List<AnimalHealth> selectAnimalHealthInfo(String send_code);
	
	/**
	 * 건강 기록 수정 - 설채원
	 * @param aheal
	 * @return
	 */
	public int updateAnimalHealth(AnimalHealth aheal);
	
	/**
	 * 건강코드로 기록 하나 검색 - 설채원
	 * @param send_code
	 * @return
	 */
	public AnimalHealth searchHealthCode(String send_code);
	
	/**
	 * 건강 기록 삭제 - 설채원
	 * @param send_code
	 * @return
	 */
	public int deleteAnimalHealth(String send_code);
	
	/**
	 * 건강 기록 등록(치료 전) - 설채원
	 * @param aheal
	 * @return
	 */
	public int insertAnimalHealth(AnimalHealth aheal);
	
	/**
	 * 건강 기록(치료 미완료 동물) 리스트 - 설채원
	 * @return
	 */
	public List<AnimalHealth> selectAnimalHealth();
	
	/**
	 * 건강 기록(치료 완료 동물) 리스트 - 설채원
	 * @return
	 */
	public List<AnimalHealth> selectAnimalHealthed();
}

