package com.cafe24.memory.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.AnimalType;

@Mapper
public interface AnimalTypeMapper {

	public int deleteAnimalType(String send_code);
	
	public int updateAnimalType(AnimalType atype);
	
	public AnimalType selectType(String send_code);
	
	public List<AnimalType> selectAnimalType();
	
	public int insertAnimalType(AnimalType atype);
	
	public List<Map<String, Object>> selectAnimalCnt();
}
