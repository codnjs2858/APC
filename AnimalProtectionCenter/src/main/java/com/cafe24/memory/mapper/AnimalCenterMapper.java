package com.cafe24.memory.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.AnimalCenter;

@Mapper
public interface AnimalCenterMapper {

	//보호동물 센터 등록
	public int insertAnimalCenter(AnimalCenter animal);
	
	//센터 동물 조회 (전체조회, 종류 선택조회)
	public List<AnimalCenter> selectAnimalCenter();
	public List<AnimalCenter> selectAnimalCenter(String send_type);
	
	//센터 동물 종류 및 종류에 따른 등록 동물 수 조회
	public List<Map<String,Object>> selectCenterCnt();
}
