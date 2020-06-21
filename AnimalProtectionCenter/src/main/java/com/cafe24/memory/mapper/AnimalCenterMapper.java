package com.cafe24.memory.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.AnimalCenter;
import com.cafe24.memory.domain.SearchReportAnimal;

@Mapper
public interface AnimalCenterMapper {

	
	public String searchReportManager(String reCode);
	/**
	 * 보호동물 센터 등록 - 설채원
	 * @param animal
	 * @return
	 */
	public int insertAnimalCenter(AnimalCenter animal);
	
	/**
	 * 센터 동물 조회(전체) - 설채원
	 * @return
	 */
	public List<AnimalCenter> selectAnimalCenter();
	
	/**
	 * 센터 동물 조회(타입선택) - 설채원
	 * @param send_type
	 * @return
	 */
	public List<AnimalCenter> selectAnimalCenter(String send_type);
	
	/**
	 * 센터 동물 종류 및 종류에 따른 등록 동물 수 조회 - 설채원
	 * @return
	 */
	public List<Map<String,Object>> selectCenterCnt();
	
	/**
	 * 신고 내역 조회 - 설채원
	 * @param memberName
	 * @param memberPhone
	 * @return
	 */
	public ArrayList<SearchReportAnimal> selectCenterReport(String memberName,String memberPhone);
	
	/**
	 * 센터 동물 개체 조회(한 개체) -설채원
	 * @param send_code
	 * @return
	 */
	public AnimalCenter selectCenterAnimal(String send_code);
}
