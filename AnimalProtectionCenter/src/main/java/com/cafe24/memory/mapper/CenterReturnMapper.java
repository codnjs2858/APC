package com.cafe24.memory.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.CenterReturn;

@Mapper
public interface CenterReturnMapper {
	
	public List<CenterReturn> selectCenterReturn();
	
	public int insertCenterReturn(CenterReturn centerReturn);
	
	public int updateCenterReturn(CenterReturn centerReturn);
	
	public int deleteCenterReturn(String centerReturnCode);
	
	public CenterReturn selectCenterReturnCode(String centerReturnCode);
	
	public List<Map<String, Object>> selectPetTypeCount();
	
	public List<CenterReturn> selectAnimalType(String animalType);
}
